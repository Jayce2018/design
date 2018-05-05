package com.design.action;

import java.util.List;
import java.util.Map;

import com.design.biz.LoginBiz;
import com.opensymphony.xwork2.ActionContext;

public class selectUserAction {
	
	LoginBiz loginBiz;
	public void setLoginBiz(LoginBiz loginBiz){
		this.loginBiz=loginBiz;
	}
	Map<String,Object> session;	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	//处理查询请求	
		public String selectUser() throws Exception{		 
			ActionContext ctx =ActionContext.getContext();
			List list=loginBiz.selectUser();		
			System.out.println("selectAction_list.size:"+list.size());
			
			if(list.size()>0){
				ctx.getSession().put("ses", list);//往session里放入ses		
				System.out.println("selectAction_success");
				return "userlist";					
			}			
			return "error";
		}
}
