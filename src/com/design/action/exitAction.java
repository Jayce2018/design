package com.design.action;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class exitAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	
	//处理退出请求	
	public String exit() throws Exception{	
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpSession session1 = request.getSession();  
		session1.invalidate();
		return "success"; 
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub		
	}

	
}
