package com.design.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.design.biz.QuestionnaireBiz;
import com.design.entity.Questionnaire;
import com.opensymphony.xwork2.ActionSupport;

public class finddfbQnAction extends ActionSupport{	
	private String result;	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	private static final long serialVersionUID = 1L;
	
	
	QuestionnaireBiz QuestionnaireBiz;
	public void setQuestionnaireBiz(QuestionnaireBiz QuestionnaireBiz){
		this.QuestionnaireBiz=QuestionnaireBiz;
	}
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request=ServletActionContext.getRequest();

	//处理查询请求		
		public String finddfbQn(){	
			String cid=request.getParameter("createrid");
			System.out.println("finddfbQnAction:"+cid);			
			Questionnaire condition=new Questionnaire();
			condition.setCreaterid(cid);
			List<Questionnaire> list=QuestionnaireBiz.finddfbQuestionnaire(condition);			
			result = "{\"result\":"+JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd")+"}";
			System.out.println("result:"+result);
			if(list.size()>0){				
				System.out.println("finddfbQnAction_success");
				return "success";					
			}			
			return "error";
		}
}
