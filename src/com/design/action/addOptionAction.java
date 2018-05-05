package com.design.action;


import java.util.Iterator;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.design.biz.OptionBiz;

import com.design.entity.Option;
import com.design.entity.Topic;
import com.opensymphony.xwork2.ActionSupport;

public class addOptionAction extends ActionSupport implements SessionAware,ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	
	OptionBiz optionBiz;
	public void setOptionBiz(OptionBiz OptionBiz){
		this.optionBiz=OptionBiz;
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
	public String addOption() throws Exception{	
		String options=request.getParameter("options");
		System.out.println("addOptionAction_options:"+options);
		JSONArray ops= JSONArray.parseArray(options);
		for(int i=0;i<ops.size();i++){
				JSONObject option=(JSONObject)ops.get(i);
				System.out.println("addOptionAction:选项序号："+option.get("id")+"  选项内容："+option.get("content")+"  问卷编码："+option.get("qnid")+"  题目序号："+option.get("topicorderid"));
				
				Integer topicorderid=Integer.parseInt(option.get("topicorderid").toString());
				Integer qnid=Integer.parseInt(option.get("qnid").toString());
				String content=option.get("content").toString();
				String orderid=option.get("id").toString();
				
				Topic tc=new Topic();
				tc.setOrderid(topicorderid);
				tc.setQnid(qnid);
				List ls=optionBiz.findTopic(tc);
				Iterator it = ls.iterator(); 
				Topic tcs =(Topic) it.next();
				Integer id=tcs.getTopicid();
				//System.out.println("++++++++getTopic:"+id);
				
				Option condition=new Option();	
				condition.setContent(content);		
				condition.setOrderid(orderid);//选项在问卷中序号			
				condition.setTopicid(id);//所属topic的id,通过数据库获取
				//System.out.println("addOptionAction_data:test-------------------");
				optionBiz.addOption(condition);
		}
		System.out.println("addOptionAction_result:insert_success");
		return "success";
		
	}

	
}
