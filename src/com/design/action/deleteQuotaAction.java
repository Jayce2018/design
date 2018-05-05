package com.design.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSON;
import com.design.biz.CustomersBiz;
import com.design.biz.LoginBiz;
import com.design.biz.QuotaBiz;
import com.design.entity.Customers;
import com.design.entity.Quota;
import com.design.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class deleteQuotaAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	
	private String result;	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	QuotaBiz quotaBiz;
	public void setQuotaBiz(QuotaBiz quotaBiz){
		this.quotaBiz=quotaBiz;
	}
	

	Map<String,Object> session;	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request=ServletActionContext.getRequest();
	
	//…æ≥˝«Î«Û¥¶¿Ì
	public String deleteQuota() throws Exception{
		Integer id=Integer.parseInt(request.getParameter("id").trim());
		Quota condition=new Quota();
		condition.setQnid(id);
		boolean flag=quotaBiz.deleteQuota(condition);		
		System.out.println("deleteQuotaAction_delete_flag:"+flag);	
		result="{\"result\":"+String.valueOf(flag)+"}";		
		System.out.println("result:"+result);
		return "success";
	}
}


