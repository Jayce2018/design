package com.design.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.design.dao.QuotaDAO;
import com.design.entity.Quota;
import com.design.entity.User_serf;
import com.design.entity.User_serf;


public class QuotaDAOImpl implements QuotaDAO{
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}	

	@Override
	public void addQuota(Quota condition) {
		// 增加配额信息
		 Session session = sessionFactory.getCurrentSession();
		 session.save(condition);
	}

	@Override
	public List<User_serf> findSerfinfo(int m,int n) {		
		//检索已发布的活动详细信息
				Session session = sessionFactory.getCurrentSession();
				String hql=null;
				 hql="select a.qnid,qnname,typecontent,`name`,enddate from quota a "
					+"join questionnaire b on b.qnid=a.qnid "
					+"join types c on c.typeid=b.typeid "
					+"join customers d on d.customerid=b.createrid "
					+"where enddate>DATE(now()) "
					+"LIMIT "+m+","+n;
				 System.out.println("QuotaDAOImpl_hql:"+hql);
				 
				 Query query = session.createSQLQuery(hql);
				
				 List<Object[]> list =query.list();			
				 List<User_serf> un=new ArrayList<User_serf>(list.size());	
				for (Object[] objs : list) {
					User_serf qn=new User_serf();	
					qn.setQnid((Integer)objs[0]);
					qn.setQnname((String)objs[1]);
					qn.setTypecontent((String)objs[2]);
					qn.setStorename((String)objs[3]);
					qn.setEndingdate((Date)objs[4]);
					
					un.add(qn);
				}
				System.out.println("QuotaDAOImpl_list_size:"+list.size());
				return un;	
	}

	@Override
	public List<User_serf> fuzzyFindSerfinfo(String keys) {
		//模糊检索已发布的活动详细信息
		Session session = sessionFactory.getCurrentSession();
		String hql=null;
		 hql="select a.qnid,qnname,typecontent,`name`,enddate from quota a "
			+"join questionnaire b on b.qnid=a.qnid "
			+"join types c on c.typeid=b.typeid "
			+"join customers d on d.customerid=b.createrid "
			+"where (qnname LIKE '%"+keys+"%' or `name` LIKE '%"+keys+"%' or typecontent like '%"+keys+"%') and enddate>DATE(now())";
			
		 System.out.println("QuotaDAOImpl_hql:"+hql);
		 
		 Query query = session.createSQLQuery(hql);
		
		 List<Object[]> list =query.list();			
		 List<User_serf> un=new ArrayList<User_serf>(list.size());	
		for (Object[] objs : list) {
			User_serf qn=new User_serf();	
			qn.setQnid((Integer)objs[0]);
			qn.setQnname((String)objs[1]);
			qn.setTypecontent((String)objs[2]);
			qn.setStorename((String)objs[3]);
			qn.setEndingdate((Date)objs[4]);			
			un.add(qn);
		}
		System.out.println("QuotaDAOImpl_list_size:"+list.size());
		return un;	
	}

	@Override
	public List<User_serf> screenFindSerfinfo(String key1, String key2) {
		//筛选已发布的活动详细信息
				Session session = sessionFactory.getCurrentSession();
				String hql=null;
				 hql="select a.qnid,qnname,typecontent,`name`,enddate from quota a "
					+"join questionnaire b on b.qnid=a.qnid join types c on c.typeid=b.typeid " 
					+"join customers d on d.customerid=b.createrid "
					+"where (`name` like '%"+key1+"%' and typecontent like '%"+key2+"%') and enddate>DATE(now())";
					
				 System.out.println("QuotaDAOImpl_hql:"+hql);
				 
				 Query query = session.createSQLQuery(hql);
				
				 List<Object[]> list =query.list();			
				 List<User_serf> un=new ArrayList<User_serf>(list.size());	
				for (Object[] objs : list) {
					User_serf qn=new User_serf();	
					qn.setQnid((Integer)objs[0]);
					qn.setQnname((String)objs[1]);
					qn.setTypecontent((String)objs[2]);
					qn.setStorename((String)objs[3]);
					qn.setEndingdate((Date)objs[4]);			
					un.add(qn);
				}
				System.out.println("QuotaDAOImpl_list_size:"+list.size());
				return un;
	}

	@Override
	public List<User_serf> fuzzyAllFindSerfinfo(String keys) {
		//模糊检索所有已发布的活动详细信息
				Session session = sessionFactory.getCurrentSession();
				String hql=null;
				 hql="select a.qnid,qnname,typecontent,`name`,enddate from quota a "
					+"join questionnaire b on b.qnid=a.qnid "
					+"join types c on c.typeid=b.typeid "
					+"join customers d on d.customerid=b.createrid "
					+"where (qnname LIKE '%"+keys+"%' or `name` LIKE '%"+keys+"%' or typecontent like '%"+keys+"%')";
					
				 System.out.println("QuotaDAOImpl_hql:"+hql);
				 
				 Query query = session.createSQLQuery(hql);
				
				 List<Object[]> list =query.list();			
				 List<User_serf> un=new ArrayList<User_serf>(list.size());	
				for (Object[] objs : list) {
					User_serf qn=new User_serf();	
					qn.setQnid((Integer)objs[0]);
					qn.setQnname((String)objs[1]);
					qn.setTypecontent((String)objs[2]);
					qn.setStorename((String)objs[3]);
					qn.setEndingdate((Date)objs[4]);			
					un.add(qn);
				}
				System.out.println("QuotaDAOImpl_list_size:"+list.size());
				return un;	
	}

	@Override
	public List<User_serf> screenAllFindSerfinfo(String key1, String key2) {
		//筛选所有已发布的活动详细信息
		Session session = sessionFactory.getCurrentSession();
		String hql=null;
		 hql="select a.qnid,qnname,typecontent,`name`,enddate from quota a "
			+"join questionnaire b on b.qnid=a.qnid join types c on c.typeid=b.typeid " 
			+"join customers d on d.customerid=b.createrid "
			+"where (`name` like '%"+key1+"%' and typecontent like '%"+key2+"%')";
			
		 System.out.println("QuotaDAOImpl_hql:"+hql);
		 
		 Query query = session.createSQLQuery(hql);
		
		 List<Object[]> list =query.list();			
		 List<User_serf> un=new ArrayList<User_serf>(list.size());	
		for (Object[] objs : list) {
			User_serf qn=new User_serf();	
			qn.setQnid((Integer)objs[0]);
			qn.setQnname((String)objs[1]);
			qn.setTypecontent((String)objs[2]);
			qn.setStorename((String)objs[3]);
			qn.setEndingdate((Date)objs[4]);			
			un.add(qn);
		}
		System.out.println("QuotaDAOImpl_list_size:"+list.size());
		return un;
	}

	@Override
	public boolean deleteQuota(Quota condition) {
		// 根据id下架问卷
				Session session=sessionFactory.getCurrentSession();
				String hql=null;
				hql="delete Quota s where s.qnid='"+condition.getQnid()+"'";
				System.out.println("QuotaDAOImpl_delete:hql="+hql);
				Query query = session.createQuery(hql);
				int bj=query.executeUpdate();
				System.out.println("QuotaDAOImpl_delete:hql="+hql+";bj:"+bj);
				if(bj>0){
					return true;
				}
				return false;
		
	}
	
	
	
}
