package com.design.action;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.design.biz.TopicBiz;
import com.design.entity.Topic;
import com.opensymphony.xwork2.ActionSupport;

public class addTopicAction extends ActionSupport implements SessionAware,ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	
	TopicBiz TopicBiz;
	public void setTopicBiz(TopicBiz TopicBiz){
		this.TopicBiz=TopicBiz;
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
	public String addTopic() throws Exception{			
		String a=request.getParameter("a");
		/*JsonObject data = new JsonParser().parse(a).getAsJsonObject();*/
		System.out.println("addTopicAction1:"+a);
		
		JSONArray j= JSONArray.parseArray(a);
		for(int i=0;i<j.size();i++){
			JSONObject j1=(JSONObject)j.get(i);
			System.out.println("addTopicAction2:"+j1.get("id")+" "+j1.get("name")+" "+j1.get("qnid")+" "+j1.get("tixing"));
			
		int id = Integer.parseInt(j1.get("id").toString());
		int qnid = Integer.parseInt(j1.get("qnid").toString());
		int tixing = Integer.parseInt(j1.get("tixing").toString());
		
		Topic condition=new Topic();	
		condition.setContent(j1.get("name").toString());
		condition.setQnid(qnid);
		condition.setOrderid(id);
		condition.setTixing(tixing);
		
		TopicBiz.addTopic(condition);
		System.out.println("addTopicAction_result:insert_success");	
		}
		return "success";
		
	}

	
}
