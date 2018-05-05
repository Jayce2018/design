package com.design.action;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;





import com.alibaba.fastjson.JSON;
import com.design.biz.QuotaBiz;
import com.design.entity.Questionnaire;
import com.design.entity.User_serf;
import com.opensymphony.xwork2.ActionSupport;

public class fuzzyFindSerfinfoAction extends ActionSupport implements SessionAware,ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
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
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
	//¥¶¿Ì«Î«Û	
	public String fuzzyFindSerfinfo() throws Exception{			
		String keys=request.getParameter("keys");		
		List<User_serf> list=quotaBiz.fuzzyFindSerfinfo(keys);
		result = "{\"result\":"+JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd")+"}";
		System.out.println("result:"+result);
		System.out.println("fuzzyFindSerfinfoAction_result:find_success");			
		return "success";	
	}

	
}
