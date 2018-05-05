package com.design.dao.impl;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.design.dao.GetcouponsDAO;
import com.design.entity.Get_coupons;
import com.design.entity.User_serf;



public class GetcouponsDAOImpl implements GetcouponsDAO{
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public void addGetcoupons(String userid, int qnid) {
		// 增加用户获奖信息
		System.out.println("GetcouponsDAOImpl:"+userid+" "+qnid);
		String sql="insert into getcoupons(userid,couponsid,finaldate) " 
				+"select '"+userid+"',couponsid,enddate from quota where qnid="+qnid;
		System.out.println("GetcouponsDAOImpl_sql:"+sql);
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
		
	}

	@Override
	public List<Get_coupons> findGetcouponsByUserid(String userid) {
		//检索已发布的活动详细信息
		Session session = sessionFactory.getCurrentSession();
		String sql=null;
		 sql="SELECT a.couponsid,finaldate,type,amount,`name`,storeurl from getcoupons a "
			+"join coupons b on b.couponsid=a.couponsid "
			+"JOIN customers c on c.customerid=b.customerid "
			+"where userid='"+userid+"' and finaldate>DATE(now())";
		 System.out.println("GetcouponsDAOImpl_hql:"+sql);
		 
		 Query query = session.createSQLQuery(sql);		
		 List<Object[]> list =query.list();			
		 List<Get_coupons> un=new ArrayList<Get_coupons>(list.size());	
		for (Object[] objs : list) {
			Get_coupons qn=new Get_coupons();	
			qn.setCouponsid((Integer)objs[0]);
			qn.setFinaldata((Date)objs[1]);
			qn.setType((Integer)objs[2]);
			qn.setAmount((Integer)objs[3]);
			qn.setName((String)objs[4]);
			qn.setStoreurl((String)objs[5]);			
			un.add(qn);
		}
		System.out.println("GetcouponsDAOImpl_list_size:"+list.size());
		return un;	
	}	
}
