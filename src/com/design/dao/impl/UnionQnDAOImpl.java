package com.design.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.design.dao.UnionQnDAO;


public class UnionQnDAOImpl implements UnionQnDAO{
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	public List selectUnionQn(int qnid){
		// 检索UnionQn所有的数据
		Session session = sessionFactory.getCurrentSession();
		String hql=null;
		
		hql="select a.*,b.topicid,b.content tocontent,b.orderid toorderid,c.optionid,c.content opcntent,c.orderid oporderid,tixing from Questionnaire a  ";
		hql+="join topic b on b.qnid=a.qnid  ";
		hql+="join `option` c on c.topicid=b.topicid  ";
		hql+="where a.qnid="+qnid;
		System.out.println("UnionQnDAOImpl_hql:"+hql);	
		Query query=session.createSQLQuery(hql);
		 System.out.println("UnionQnDAOImpl_hql:test");
		 List list = query.list();	
		 
		 System.out.println("UnionQnDAOImpl_list:"+list.size());
		return list;
	}	
}
