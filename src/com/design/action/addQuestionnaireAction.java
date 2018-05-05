package com.design.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.design.biz.QuestionnaireBiz;
import com.design.entity.Questionnaire;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class addQuestionnaireAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */	
	
	private static final long serialVersionUID = 1L;
	private String qnname;
	private String createrid;
	private Date createdate;
	private Integer typeid;	

	public String getQnname() {
		return qnname;
	}

	public void setQnname(String qnname) {
		this.qnname = qnname;
	}

	public String getCreaterid() {
		return createrid;
	}

	public void setCreaterid(String createrid) {
		this.createrid = createrid;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
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
	//处理增加请求	
	public String addQuestionnaire() throws Exception{		
		response.setContentType("text/html;charset=UTF-8"); 
	    request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("ISO-8859-1");
		
		createdate=new Date();		
		String qnname2 = new String(qnname.getBytes("ISO-8859-1"),"utf8");
		System.out.println("addQuestionnaireAction:"+qnname2+' '+typeid+' '+createdate+' '+createrid);
		
		ActionContext ctx =ActionContext.getContext();
		/*SimpleDateFormat sdf =   new SimpleDateFormat( "MM/dd/yyyy" );
		String date = sdf.format(createdate);*/
		
		Questionnaire condition=new Questionnaire();	
		condition.setQnname(qnname2);
		condition.setTypeid(typeid);
		condition.setCreatedate(createdate);
		condition.setCreaterid(createrid);
		QuestionnaireBiz.addQuestionnaire(condition);
		System.out.println("addQuestionnaire_qnid:"+condition.getQnid());
		System.out.println("addQuestionnaire_result:insert_success");	
		
		ctx.put("qnid",condition.getQnid() );
		ctx.put("qnname",condition.getQnname() );
		
		return "success";
		
	}

	
	 
}
