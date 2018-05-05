package com.design.dao.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;








import com.design.dao.QuestionnaireDAO;
import com.design.entity.Qn_quota;
import com.design.entity.Qn_topic_option_Union;
import com.design.entity.Questionnaire;


public class QuestionnaireDAOImpl implements QuestionnaireDAO{
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	
	public void addQuestionnaire(Questionnaire condition) {
		// 增加问卷
		System.out.println("LoginDAOImpl_addQuestionnaire:"+condition.getQnname()+' '+condition.getCreaterid()+' '+condition.getTypeid()+' '+condition.getCreatedate());
		 Session session = sessionFactory.getCurrentSession();
		 session.save(condition);
	}


	@Override
	public List<Questionnaire> selectQuestionnaire(Questionnaire condition) {
		// 检索我的所有问卷		
		System.out.println("QuestionnaireDAOImpl_selectQuestionnaire:"+condition.getCreaterid());		
		Session session = sessionFactory.getCurrentSession();
		String hql=null;
		 hql="from Questionnaire where createrid='"+condition.getCreaterid()+"'";
		 System.out.println("QuestionnaireDAOImpl_select_hql:"+hql);
		 Query query = session.createQuery(hql);
		 List<Questionnaire> list = query.list();		
		return list;	
	}


	@Override
	public List<Questionnaire> finddfbQuestionnaire(Questionnaire condition) {
		// 检索待发布问卷		
		Session session = sessionFactory.getCurrentSession();
		String hql=null;
		hql="select  distinct a.* from questionnaire a "
		+"join topic b on b.qnid=a.qnid "
		+"join `option` c on c.topicid=b.topicid "
		+"where createrid='"+condition.getCreaterid() +"'  and  a.qnid not in (  SELECT a.qnid from questionnaire a  join quota b on b.qnid=a.qnid)";
		System.out.println("QuestionnaireDAOImpl_finddfb_hql:"+hql);	
		Query query=session.createSQLQuery(hql);
		
		List<Object[]> list =query.list();	
		List<Questionnaire> un=new ArrayList<Questionnaire>(list.size());	
		for (Object[] objs : list) {
			Questionnaire qn=new Questionnaire();	
			qn.setQnid((Integer)objs[0]);
			qn.setQnname((String)objs[1]);
			qn.setTypeid((Integer)objs[2]);
			qn.setCreaterid((String)objs[3]);
			qn.setCreatedate((Date)objs[4]);					
			un.add(qn);
		}
		System.out.println("QuestionnaireDAOImpl_finddfb_list_size:"+list.size());
		return un;	
	}


	@Override
	public List<Questionnaire> findysjQuestionnaire(Questionnaire condition) {
		// 检索已设计问卷		
				Session session = sessionFactory.getCurrentSession();
				String hql=null;
				hql="select  distinct a.* from questionnaire a "
				+"join topic b on b.qnid=a.qnid "
				+"join `option` c on c.topicid=b.topicid "
				+"where createrid='"+condition.getCreaterid() +"'";
				System.out.println("QuestionnaireDAOImpl_findysj_hql:"+hql);	
				Query query=session.createSQLQuery(hql);
				
				List<Object[]> list =query.list();	
				List<Questionnaire> un=new ArrayList<Questionnaire>(list.size());	
				for (Object[] objs : list) {
					Questionnaire qn=new Questionnaire();	
					qn.setQnid((Integer)objs[0]);
					qn.setQnname((String)objs[1]);
					qn.setTypeid((Integer)objs[2]);
					qn.setCreaterid((String)objs[3]);
					qn.setCreatedate((Date)objs[4]);					
					un.add(qn);
				}
				System.out.println("QuestionnaireDAOImpl_findysj_list_size:"+list.size());
				return un;	
	}


	@Override
	public List<Qn_quota> findyfbQuestionnaire(Qn_quota condition) {
		// 检索已发布问卷		
		Session session = sessionFactory.getCurrentSession();
		String hql=null;
		hql="select  distinct a.*,enddate from questionnaire a "
		+"join quota b on b.qnid=a.qnid "
		+"where createrid='"+condition.getCreaterid() +"'";
		System.out.println("QuestionnaireDAOImpl_findyfb_hql:"+hql);	
		Query query=session.createSQLQuery(hql);
		
		List<Object[]> list =query.list();	
		List<Qn_quota> un=new ArrayList<Qn_quota>(list.size());	
		for (Object[] objs : list) {
			Qn_quota qn=new Qn_quota();	
			qn.setQnid((Integer)objs[0]);
			qn.setQnname((String)objs[1]);
			qn.setTypeid((Integer)objs[2]);
			qn.setCreaterid((String)objs[3]);
			qn.setCreatedate((Date)objs[4]);	
			qn.setEndingdate((Date)objs[5]);
			un.add(qn);
		}
		System.out.println("QuestionnaireDAOImpl_findyfb_list_size:"+list.size());
		return un;
	}


	@Override
	public List<Questionnaire> findwwcQuestionnaire(Questionnaire condition) {
		// 检索未完成问卷		
				Session session = sessionFactory.getCurrentSession();
				String hql=null;
				hql="SELECT * from questionnaire WHERE qnid not in( "
				+"select DISTINCT a.qnid from questionnaire a " 
				+"JOIN topic b on b.qnid=a.qnid "
				+"join `option` c on c.topicid=b.topicid) "
				+"and createrid='"+condition.getCreaterid() +"'";
				System.out.println("QuestionnaireDAOImpl_finwwcb_hql:"+hql);	
				Query query=session.createSQLQuery(hql);
				
				List<Object[]> list =query.list();	
				List<Questionnaire> un=new ArrayList<Questionnaire>(list.size());	
				for (Object[] objs : list) {
					Questionnaire qn=new Questionnaire();	
					qn.setQnid((Integer)objs[0]);
					qn.setQnname((String)objs[1]);
					qn.setTypeid((Integer)objs[2]);
					qn.setCreaterid((String)objs[3]);
					qn.setCreatedate((Date)objs[4]);						
					un.add(qn);
				}
				System.out.println("QuestionnaireDAOImpl_findwwc_list_size:"+list.size());
				return un;
	}

}
