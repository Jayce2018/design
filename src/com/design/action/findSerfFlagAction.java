package com.design.action;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;






import com.alibaba.fastjson.JSON;
import com.design.biz.AnswerBiz;
import com.design.biz.QuotaBiz;
import com.design.entity.Questionnaire;
import com.design.entity.User_serf;
import com.opensymphony.xwork2.ActionSupport;

public class findSerfFlagAction extends ActionSupport implements SessionAware,ServletRequestAware {
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
	
	AnswerBiz answerBiz;
	public void setAnswerBiz(AnswerBiz answerBiz){
		this.answerBiz=answerBiz;
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
	public String findSerfFlag() throws Exception{			
		String userid=request.getParameter("userid");		
		Integer qnid=Integer.parseInt(request.getParameter("qnid"));	
		boolean flag=answerBiz.findUserSerfflag(qnid, userid);
		result = String.valueOf(flag);
		System.out.println("result:"+result);
		System.out.println("findSerfFlagAction_result:find_success");			
		return "success";	
	}

	
}
