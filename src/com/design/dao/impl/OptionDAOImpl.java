package com.design.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.design.dao.OptionDAO;
import com.design.entity.Option;
import com.design.entity.Topic;



public class OptionDAOImpl implements OptionDAO{
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Override
	public void addOption(Option condition) {
		// 增加题目
		System.out.println("OptionDAOImpl_addOption:"+condition.getContent()+' '+condition.getTopicid()+' '+condition.getOrderid());
		 Session session = sessionFactory.getCurrentSession();
		 session.save(condition);		
	}

	@Override
	public List findTopic(Topic condition) {
		// 查询题目
				System.out.println("OptionDAOImpl_findTopic:"+condition.getQnid()+' '+condition.getOrderid());
				
				Session session = sessionFactory.getCurrentSession();
				String hql=null;
				 hql="from Topic where qnid="+condition.getQnid()+" and orderid="+condition.getOrderid();
				
				 Query query = session.createQuery(hql);
				 List list = query.list();		
				return list;	
	}


}
