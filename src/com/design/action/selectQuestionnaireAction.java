package com.design.action;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSON;
import com.design.biz.QuestionnaireBiz;
import com.design.entity.Questionnaire;
import com.opensymphony.xwork2.ActionSupport;

public class selectQuestionnaireAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	private String createrid;	
	private String result;
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCreaterid() {
		return createrid;
	}

	public void setCreaterid(String createrid) {
		this.createrid = createrid;
	}

	
	QuestionnaireBiz QuestionnaireBiz;
	public void setQuestionnaireBiz(QuestionnaireBiz QuestionnaireBiz){
		this.QuestionnaireBiz=QuestionnaireBiz;
	}
	Map<String,Object> session;	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}	
	 HttpServletResponse response = ServletActionContext.getResponse();
	 HttpServletRequest request=ServletActionContext.getRequest();
	 
	
	public String selectQuestionnaire() throws Exception{	
		//´¦Àí¼ìË÷ÇëÇó	
		String cid=request.getParameter("createrid");
		System.out.println("selectQuestionnaireAction:"+cid);			
		Questionnaire condition=new Questionnaire();	
		
		condition.setCreaterid(cid);
		List<Questionnaire> list=QuestionnaireBiz.selectQuestionnaire(condition);
		result = "{\"result\":"+JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd")+"}";
		System.out.println("result:"+result);
		System.out.println("selectQuestionnaireAction_result:select_success");				
		return "success";		
	}	 
}
