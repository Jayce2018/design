package com.design.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.design.dao.TypesDAO;
import com.design.entity.Types;
import com.design.entity.User;

public class TypesDAOImpl implements TypesDAO{
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}	
	@Override
	public List<Types> typeList() {
		//用于获取所有的类型		
		  Session session = sessionFactory.getCurrentSession();		  
		  String hql=null;	
		  hql="from Types";		 
		  System.out.println("TypesDAOImpl:"+hql);		  
		  Query query = session.createQuery(hql);		
		  List<Types> list = query.list();
			  System.out.println("TypesDAOImpl_list.size:"+list.size());
			  return list;		
	}		
}
