package com.design.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.design.biz.AnswerBiz;
import com.design.entity.Answer_table;
import com.opensymphony.xwork2.ActionSupport;
public class findAnswertableAction extends ActionSupport{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request=ServletActionContext.getRequest();

	//处理查询请求		
		public String findAnswertable(){	
			int qnid=Integer.parseInt(request.getParameter("qnid"));
			System.out.println("findAnswertableAction:"+qnid);			
			
			Answer_table condition=new Answer_table();
			condition.setQnid(qnid);
			List<Answer_table> list=answerBiz.tableAnswer(condition);
			
			result = "{\"result\":"+JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd")+"}";
			System.out.println("result:"+result);
			if(list.size()>0){				
				System.out.println("findAnswertableAction_success");
				return "success";					
			}			
			return "error";			
		}
}
