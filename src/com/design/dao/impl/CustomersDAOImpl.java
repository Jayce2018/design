package com.design.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.design.dao.CustomersDAO;
import com.design.entity.Customers;
import com.design.entity.Types;
import com.design.entity.User;


public class CustomersDAOImpl implements CustomersDAO{
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}	

	@Override
	public void addCustomers(Customers condition) {
		// 增加商家详细信息
		 Session session = sessionFactory.getCurrentSession();
		 session.save(condition);
	}

	@Override
	public boolean findCustomer(Customers condition) {
		//查询某id的商家是否已存在
		 Session session = sessionFactory.getCurrentSession();		  
		  String hql=null;
		  hql="from Customers where id='"+condition.getCustomerid()+"'";
		  System.out.println("CustomersDAOIpml:"+hql);	
		  Query query = session.createQuery(hql);
		  //System.out.println("LoginDAOIpml:"+3);	
		  List<Customers> list = query.list();		 
		  if(list.size()>0){ 			 
			  return true;
		  }
		  return false;
	}

	@Override
	public void deleteCustomers(Customers condition) {
		//删除某id的商家详细信息
		Session session=sessionFactory.getCurrentSession();
		String hql=null;
		hql="delete Customers where customerid='"+condition.getCustomerid()+"'";
		System.out.println("LonginDAOImpl_deleteCustomer:hql="+hql);
		Query query = session.createQuery(hql);
		query.executeUpdate();			
	}

	@Override
	public List<Customers> listCustomers() {
		//用于获取所有的商家信息	
		  Session session = sessionFactory.getCurrentSession();		  
		  String hql=null;	
		  hql="from Customers";		 
		  System.out.println("CustomersDAOImpl:"+hql);		  
		  Query query = session.createQuery(hql);		
		  List<Customers> list = query.list();
			  System.out.println("CustomersDAOImpl_list.size:"+list.size());
			  return list;		
	}	
	
	
}
