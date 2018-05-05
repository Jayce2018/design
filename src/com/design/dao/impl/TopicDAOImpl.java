package com.design.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.design.dao.TopicDAO;
import com.design.entity.Topic;
import com.design.entity.User;



public class TopicDAOImpl implements TopicDAO{
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Override
	public void addTopic(Topic condition) {
		// 增加题目
		System.out.println("TopicDAOImpl_addTopic:"+condition.getContent()+' '+condition.getQnid()+' '+condition.getOrderid());
		 Session session = sessionFactory.getCurrentSession();
		 session.save(condition);		
	}

	@Override
	public List findTopic(Topic condition) {
		// 查询题目
		System.out.println("TopicDAOImpl_findTopic:"+condition.getQnid()+' '+condition.getOrderid());
		
				Session session = sessionFactory.getCurrentSession();
				String hql=null;
				 hql="from Topic where qnid="+condition.getQnid()+" orderid="+condition.getOrderid();
				 Query query = session.createQuery(hql);
				 List list = query.list();		
				return list;		
	}
}
