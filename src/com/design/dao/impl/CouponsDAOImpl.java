package com.design.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.design.dao.CouponsDAO;
import com.design.entity.Coupons;


public class CouponsDAOImpl implements CouponsDAO{
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Override
	public void addCoupons(Coupons condition) {
		// 增加奖券
		System.out.println("CouponsDAOImpl_addCoupons:"+condition.getType()+' '+condition.getAmount()+' '+condition.getCustomerid());
		 Session session = sessionFactory.getCurrentSession();
		 session.save(condition);		
	}

	@Override
	public List<Coupons> findCouponsByCustomerid(Coupons condition) {
		//查询某id的商家全部奖券
		 Session session = sessionFactory.getCurrentSession();		  
		  String hql=null;
		  hql="from Coupons where customerid='"+condition.getCustomerid()+"'";
		  System.out.println("CouponsDAOIpml:"+hql);	
		  Query query = session.createQuery(hql);
		  //System.out.println("LoginDAOIpml:"+3);	
		  List<Coupons> list = query.list();
		return list;		 
		 
	}

	
}
