package com.design.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.design.dao.AnswerDAO;
import com.design.entity.Answer;
import com.design.entity.AnswerId;
import com.design.entity.Answer_table;
import com.design.entity.Charts_data;

public class AnswerDAOImpl implements AnswerDAO{
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}	

	@Override
	public void addAnswer(AnswerId condition) {
		// 增加答案信息
		System.out.println("AnswerDAOImpl:"+condition.getUserid()+" "+condition.getOptionid());
		String sql="insert into answer(userid,optionid) values('"+condition.getUserid()+"',"+condition.getOptionid()+")";
		System.out.println("AnswerDAOImpl_sql:"+sql);
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
	}

	@Override
	public List<Answer_table> tableAnswer(Answer_table condition) {
		// 检索答案表结构
				Session session = sessionFactory.getCurrentSession();
				String sql=null;
				 sql="select a.qnid,qnname,b.topicid,b.content tocontent,b.orderid toorderid,c.optionid,c.content opcontent,c.orderid oporderid from questionnaire a "
					+"join topic b on b.qnid=a.qnid "
					+"join `option` c on c.topicid=b.topicid "
					+"where a.qnid="+condition.getQnid();
				 Query query = session.createSQLQuery(sql);
				 System.out.println("AnswerDAOImpl_sql:"+sql);
				 List<Object[]> list =query.list();		
				
				 List<Answer_table> un=new ArrayList<Answer_table>(list.size());				 
				 for (Object[] objs : list) {					
					Answer_table qn=new Answer_table();					
					qn.setQnid((Integer)objs[0]);
					qn.setQnname((String)objs[1]);
					qn.setTopicid((Integer)objs[2]);
					qn.setTocontent((String)objs[3]);
					qn.setToorderid((Integer)objs[4]);
					qn.setOptionid((Integer)objs[5]);
					qn.setOpcontent((String)objs[6]);
					qn.setOporderid((String)objs[7]);					
					un.add(qn);
				}
				System.out.println("AnswerDAOImpl_tableAnswer_size:"+list.size());
				return un;	
	}

	@Override
	public List<AnswerId> findAnswerByQnid(Integer qnid) {
		// 检索答案
		Session session = sessionFactory.getCurrentSession();
		String sql=null;
		 sql="SELECT a.* from answer a "
			+"join `option` b on b.optionid=a.optionid "
			+"join topic c on c.topicid=b.topicid "
			+"join questionnaire d on d.qnid=c.qnid "
			+"where d.qnid="+qnid;
		 Query query = session.createSQLQuery(sql);
		 System.out.println("AnswerDAOImpl_sql:"+sql);
		 List<Object[]> list =query.list();		
		
		 List<AnswerId> un=new ArrayList<AnswerId>(list.size());				 
		 for (Object[] objs : list) {					
			AnswerId qn=new AnswerId();
			qn.setUserid((String)objs[0]);
			qn.setOptionid((Integer)objs[1]);
							
			un.add(qn);
		}
		System.out.println("AnswerDAOImpl_Answer_size:"+list.size());
		return un;
	}

	@Override
	public List<Charts_data> findChartData(Integer qnid, Integer topicid) {
		// 检索图形数据
				Session session = sessionFactory.getCurrentSession();
				String sql=null;
				 sql="SELECT b.orderid,count(1) num from answer a  "
					+"join `option` b on b.optionid=a.optionid "
					+"join topic c on c.topicid=b.topicid "
					+"where qnid="+qnid+" and b.topicid="+topicid+" "
					+"GROUP BY b.optionid";
				 Query query = session.createSQLQuery(sql);
				 System.out.println("AnswerDAOImpl_sql:"+sql);
				 List<Object[]> list =query.list();		
				
				 List<Charts_data> un=new ArrayList<Charts_data>(list.size());				 
				 for (Object[] objs : list) {					
					 Charts_data qn=new Charts_data();
					qn.setContent((String)objs[0]);
					qn.setNum((BigInteger)objs[1]);									
					un.add(qn);
				}
				System.out.println("AnswerDAOImpl_Answer_size:"+list.size());
				return un;
	}

	@Override
	public boolean findUserSerfflag(Integer qnid, String userid) {
		// 检索用户操作标记
		Session session = sessionFactory.getCurrentSession();
		String sql=null;
		 sql="select DISTINCT userid,c.qnid from answer a "
			+"join `option` b on b.optionid=a.optionid "
			+"join topic c on c.topicid=b.topicid "
			+"where userid='"+userid+"' and qnid="+qnid;
		 Query query = session.createSQLQuery(sql);
		 System.out.println("AnswerDAOImpl_sql:"+sql);
		 List<Object[]> list =query.list();		
		 
		 System.out.println("AnswerDAOImpl_listsize:"+list.size());
		if(list.size()==1){
			 System.out.println("AnswerDAOImpl_serfflag:true");
			return true;
		}else{
			System.out.println("AnswerDAOImpl_serfflag:false");
			return false;
			}
	}		
}
