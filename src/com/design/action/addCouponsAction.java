package com.design.action;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.design.biz.CouponsBiz;
import com.design.entity.Coupons;
import com.opensymphony.xwork2.ActionSupport;

public class addCouponsAction extends ActionSupport implements SessionAware,ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	
	CouponsBiz couponsBiz;
	public void setCouponsBiz(CouponsBiz couponsBiz){
		this.couponsBiz=couponsBiz;
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
	public String addCoupons() throws Exception{			
		int type=Integer.parseInt(request.getParameter("type").trim());
		int amount=Integer.parseInt(request.getParameter("amount").trim());
		String customerid=request.getParameter("customerid");
		System.out.println("addCouponsAction:"+type+" "+amount+" "+customerid);
		Coupons condition=new Coupons();	
		condition.setType(type);
		condition.setAmount(amount);
		condition.setCustomerid(customerid);		
		
		couponsBiz.addCoupons(condition);
		System.out.println("addCouponsAction_result:insert_success");			
		return "success";	
	}

	
}
