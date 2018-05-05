package com.design.action;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;


import com.design.biz.GetcouponsBiz;

import com.opensymphony.xwork2.ActionSupport;

public class addGetcouponsAction extends ActionSupport implements SessionAware,ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	
	GetcouponsBiz getcouponsBiz;
	public void setGetcouponsBiz(GetcouponsBiz getcouponsBiz){
		this.getcouponsBiz=getcouponsBiz;
	}
	Map<String,Object> session;	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
	//处理增加请求	
	public String addGetcoupons() throws Exception{			
		String userid=request.getParameter("userid").trim();
		int qnid=Integer.parseInt(request.getParameter("qnid").trim());
		getcouponsBiz.addGetcoupons(userid, qnid);
		System.out.println("addGetcouponsAction_result:insert_success");			
		return "success";	
	}

	
}
