package com.design.action;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.design.biz.QuotaBiz;
import com.design.entity.Quota;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class addQuotaAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer qnid;
	private String endingdate;	
	private Integer couponsid;
	
	public Integer getQnid() {
		return qnid;
	}
	public void setQnid(Integer qnid) {
		this.qnid = qnid;
	}
	public String getEndingdate() {
		return endingdate;
	}
	public void setEndingdate(String endingdate) {
		this.endingdate = endingdate;
	}	
	public Integer getCouponsid() {
		return couponsid;
	}
	public void setCouponsid(Integer couponsid) {
		this.couponsid = couponsid;
	}


	QuotaBiz quotaBiz;
	public void setQuotaBiz(QuotaBiz QuotaBiz){
		this.quotaBiz=QuotaBiz;
	}
	Map<String,Object> session;	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	//处理增加请求	
	public String addQuota() throws Exception{			
		
		Quota condition=new Quota();		
		
		SimpleDateFormat sdf =   new SimpleDateFormat( "MM/dd/yyyy" );
		Date date = sdf.parse(endingdate);
		
		condition.setQnid(qnid);	
		condition.setEnddate(date);	
		condition.setCouponsid(couponsid);
		
	
		quotaBiz.addQuota(condition);		
		System.out.println("addQuotaAction_result:insert_success");	
		
		return "success";
		
	}
}
