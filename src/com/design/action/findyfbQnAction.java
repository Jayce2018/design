package com.design.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.design.biz.QuestionnaireBiz;
import com.design.entity.Qn_quota;
import com.design.entity.Questionnaire;
import com.opensymphony.xwork2.ActionSupport;

public class findyfbQnAction extends ActionSupport{	
	private String result;	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	private static final long serialVersionUID = 1L;
	
	
	QuestionnaireBiz questionnaireBiz;
	public void setQuestionnaireBiz(QuestionnaireBiz QuestionnaireBiz){
		this.questionnaireBiz=QuestionnaireBiz;
	}
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request=ServletActionContext.getRequest();

	//处理查询请求		
		public String findyfbQn(){	
			String cid=request.getParameter("createrid");
			System.out.println("findyfbQnAction:"+cid);			
			Qn_quota condition=new Qn_quota();
			condition.setCreaterid(cid);
			List<Qn_quota> list=questionnaireBiz.findyfbQuestionnaire(condition);			
			result = "{\"result\":"+JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd")+"}";
			System.out.println("result:"+result);
			if(list.size()>0){				
				System.out.println("findyfbQnAction_success");
				return "success";					
			}			
			return "error";
		}
}
