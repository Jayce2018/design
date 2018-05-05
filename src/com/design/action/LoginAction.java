package com.design.action;


import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.design.biz.LoginBiz;
import com.design.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String type;
	private Integer flag;
	
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;		
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getType(){
		
		return type;
	}
	public void setType(String type){
		this.type=type;
	}
	
	public Integer getFlag(){
		return flag;
	}
	public void setFlag(Integer flag){
		this.flag=flag;
	}
	
	LoginBiz loginBiz;
	public void setLoginBiz(LoginBiz loginBiz){
		this.loginBiz=loginBiz;
	}
	Map<String,Object> session;	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	//´¦ÀíµÇÂ¼ÇëÇó	
	public String validateLogin() throws Exception{		 
		System.out.println("loginaction:"+id+' '+password+' '+type);
		ActionContext ctx =ActionContext.getContext();
		User condition=new User();
		condition.setId(id);
		condition.setPassword(password);
		condition.setType(type);
		List<User> list=loginBiz.Login(condition);		
		System.out.println("LoginAction_list.size:"+list.size());
		
		if(list.size()>0){					
			ctx.getSession().put("user", list);			
			return "myindex";
		}
		return "error";
		
	}
}
