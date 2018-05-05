package com.design.action;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.design.biz.AnswerBiz;
import com.design.entity.Answer;
import com.design.entity.AnswerId;
import com.design.entity.Topic;
import com.opensymphony.xwork2.ActionSupport;

public class addAnswerAction extends ActionSupport implements SessionAware,ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	
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
	
	//处理增加请求	
	public String addAnswer() throws Exception{				
		String rs=request.getParameter("rs");
		System.out.println("addAnswerAction1:"+rs);
		
		JSONArray j= JSONArray.parseArray(rs);
		for(int i=0;i<j.size();i++){
			JSONObject j1=(JSONObject)j.get(i);
			System.out.println("addAnswerAction2:"+j1.get("userid")+" "+j1.get("optionid"));
			
			String userid = j1.get("userid").toString();
			int optionid = Integer.parseInt(j1.get("optionid").toString());		
			
			AnswerId condition=new AnswerId();	
			condition.setUserid(userid);
			condition.setOptionid(optionid);
			
			answerBiz.addAnswer(condition);
			System.out.println("addAnswerAction_result:insert_success");	
		}
		return "success";
	}

	
}
