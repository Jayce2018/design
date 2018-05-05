package com.design.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.design.biz.LoginBiz;
import com.design.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class checkUserAction extends ActionSupport implements SessionAware  {
	/**
	 * 
	 */
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
	Map<String,Object> session;	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	//…Û∫À«Î«Û¥¶¿Ì
	public String checkUser() throws Exception{
		User condition=new User();
		
		condition.setId(id);
		condition.setFlag(1);
		loginBiz.checkUser(condition);
			
		return "userlist";		
	}

}
