package com.design.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.design.biz.CustomersBiz;
import com.design.biz.LoginBiz;
import com.design.entity.Customers;
import com.design.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class deleteUserAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private String id;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	LoginBiz loginBiz;
	public void setLoginBiz(LoginBiz loginBiz){
		this.loginBiz=loginBiz;
	}
	
	CustomersBiz customersBiz;	
	public void setCustomersBiz(CustomersBiz customersBiz) {
		this.customersBiz = customersBiz;
	}

	Map<String,Object> session;	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	//…æ≥˝«Î«Û¥¶¿Ì
	public String deleteUser() throws Exception{
		User condition=new User();
		condition.setId(id);
		boolean flag=loginBiz.deleteUser(condition);
		
		Customers c=new Customers();
		c.setCustomerid(id);
		customersBiz.deleteCustomers(c);
		System.out.println("deleteUserAction_deleteUser_flag:"+flag);		
		return "userlist";		
	}
}


