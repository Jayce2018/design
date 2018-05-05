package com.design.dao.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




import com.design.dao.LoginDAO;
import com.design.entity.Questionnaire;
import com.design.entity.User;
import com.design.entity.User_customers;

public class LoginDAOImpl implements LoginDAO{
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Override
	public List search(User condition) {
		//用于登录信息的验证
	
		 //System.out.println("LoginDAOIpml:"+1);	
		  Session session = sessionFactory.getCurrentSession();
		  
		  String hql=null;
		  //System.out.println("LoginDAOIpml:"+2);	
		  if(condition.getType().equals("用户")){
			  hql="from User where password='"+condition.getPassword()+"' and id='"+condition.getId()+"' and type="+"'"+condition.getType()+"'";
		  }else{
			  hql="from User where password='"+condition.getPassword()+"' and id='"+condition.getId()+"' and type="+"'"+condition.getType()+"' and flag='1' ";
		  }
		  System.out.println("LoginDAOIpml:"+hql);	
		  
		  Query query = session.createQuery(hql);
		  //System.out.println("LoginDAOIpml:"+3);	
		  List<User> list = query.list();
				  System.out.println("LoginDAOIpml_list.size:"+list.size());
				  return list;				  
	}
	@Override
	public void addUser(User condition) {
		// 注册新增用户
		System.out.println("LoginDAOImpl_addUser:"+condition.getId()+' '+condition.getName()+' '+condition.getPassword()+' '+condition.getType()+' '+condition.getDate()+' '+condition.getGender());
		 Session session = sessionFactory.getCurrentSession();
		 session.save(condition);
		 
	}
	@Override
	public boolean findLogin(String userid) {
		// 用于查找用户是否存在
		 Session session = sessionFactory.getCurrentSession();		  
		  String hql=null;
		  hql="from User where id='"+userid+"'";
		  System.out.println("LoginDAOIpml:"+hql);	
		  Query query = session.createQuery(hql);
		  //System.out.println("LoginDAOIpml:"+3);	
		  List<User> list = query.list();		 
		  if(list.size()>0){ 			 
			  return false;
		  }
		  return true;
	}
	@Override
	public void updateUser(User condition) {
		// update用户信息
		System.out.println("LoginDAOImpl_updateUser:"+condition.getId()+' '+condition.getName()+' '+condition.getPassword()+' '+condition.getType());
		 Session session = sessionFactory.getCurrentSession();
		 String hql=null;
		 hql="update User user set user.name='"+condition.getName()+"',user.password='"+condition.getPassword()+"',user.type='"+condition.getType()+"',user.name='"+condition.getName()+"' where user.id='"+condition.getId()+"'";
		 System.out.println("LoginDAOIpml:"+hql);	
		 Query query = session.createQuery(hql);
		 query.executeUpdate();
		 //session.update(condition);
		 
	}
	@Override
	public List selectUser() {
		// 检索user所有的数据
		Session session = sessionFactory.getCurrentSession();
		String hql=null;
		 hql="SELECT a.id,a.name,a.type,a.gender,a.date,b.name storename,b.storeurl,a.flag from `user` a "
			+"join customers b on b.customerid=a.id";
		 Query query = session.createSQLQuery(hql);
		
		 List<Object[]> list =query.list();			
		 List<User_customers> un=new ArrayList<User_customers>(list.size());	
		for (Object[] objs : list) {
			User_customers qn=new User_customers();	
			qn.setId((String)objs[0]);
			qn.setName((String)objs[1]);
			qn.setType((String)objs[2]);
			qn.setGender((String)objs[3]);
			qn.setDate((Date)objs[4]);	
			qn.setStorename((String)objs[5]);
			qn.setStoreurl((String)objs[6]);
			qn.setFlag((Integer)objs[7]);
			un.add(qn);
		}
		System.out.println("LoginDAOImpl_selectUser_size:"+list.size());
		return un;	
	}
	@Override
	public boolean deleteUser(String userid) {
		// 根据id删除用户
		Session session=sessionFactory.getCurrentSession();
		String hql=null;
		hql="delete User s where s.id='"+userid+"'";
		System.out.println("LonginDAOImpl_deleteUser:hql="+hql);
		Query query = session.createQuery(hql);
		int condition=query.executeUpdate();
		System.out.println("LonginDAOImpl_deleteUser:hql="+hql+";condition:"+condition);
		if(condition>0){
			return true;
		}
		return false;
	}
	@Override
	public void checkUser(User condition) {
		// 审核商户和管理员授权
		System.out.println("LoginDAOImpl_checkUser:"+condition.getId());
		 Session session = sessionFactory.getCurrentSession();
		 String hql=null;
		 hql="update User user set user.flag='"+condition.getFlag()+"' where user.id='"+condition.getId()+"'";
		 System.out.println("LoginDAOIpml:"+hql);	
		 Query query = session.createQuery(hql);
		 query.executeUpdate();
	}
	@Override
	public boolean findUser(User condition) {
		// 用于查找某类型用户是否存在
		 Session session = sessionFactory.getCurrentSession();		  
		  String hql=null;
		  hql="from User where id='"+condition.getId()+"'  and type='"+condition.getType()+"'";
		  System.out.println("LoginDAOIpml:"+hql);	
		  Query query = session.createQuery(hql);
		  //System.out.println("LoginDAOIpml:"+3);	
		  List<User> list = query.list();		 
		  if(list.size()>0){ 			 
			  return true;
		  }
		  return false;
	}
}
