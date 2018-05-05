package com.design.action;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.design.biz.LoginBiz;
import com.design.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class addUserAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String ps;
	private String type;
	private Integer flag;
	private String gender;
	private String zhucedate;
	private String name;
	
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;		
	}
	
	public String getZhucedate() {
		return zhucedate;
	}
	public void setZhucedate(String zhucedate) {		
		this.zhucedate = zhucedate;
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
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;		
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	//处理增加请求	
	public String addUser() throws Exception{			
		System.out.println("addUseraction:"+id+' '+name+' '+password+' '+type+' '+zhucedate+' '+gender);
		User condition=new User();		
		List<String> info = new ArrayList<String>() ;	// 收集错误
		SimpleDateFormat sdf =   new SimpleDateFormat( "MM/dd/yyyy" );
		Date date = sdf.parse(zhucedate);
		
		condition.setId(id);
		condition.setName(name);
		condition.setPassword(password);
		condition.setType(type);		
		condition.setDate(date);
		condition.setGender(gender);
		String ps=null;
		ps=getPs();
		System.out.println(ps+"----"+condition.getPassword());
		
		boolean flag=loginBiz.findLogin(condition);
		ActionContext ctx =ActionContext.getContext();
		System.out.println("addUserAction_condition.type:"+condition.getType());
		System.out.println("addUserAction_flag:"+flag);
		if(condition.getId().length()==0){
			System.out.println("addUserAction:id不能为空！");	
			info.add("id不能为空！") ;
			ctx.put("req", info);			
		}
		if(condition.getName().length()==0){
			System.out.println("addUserAction:姓名不能为空！");	
			info.add("姓名不能为空！") ;
			ctx.put("req", info);			
		}
		if(condition.getGender().length()==0){
			System.out.println("addUserAction:性别不能为空！");	
			info.add("性别不能为空！") ;
			ctx.put("req", info);			
		}
		if(condition.getPassword().length()==0){
			System.out.println("addUserAction:密码不能为空！");	
			info.add("密码不能为空！") ;
			ctx.put("req", info);			
		}
		if(condition.getType().length()==0){
			System.out.println("addUserAction:类型不能为空！");	
			info.add("类型不能为空！") ;
			ctx.put("req", info);			
		}
		if(condition.getPassword().equals(ps)){}else{
			System.out.println("addUserAction:密码输入不一致！");	
			info.add("密码输入不一致！") ;
			ctx.put("req", info);			
		}
		if(info.size()!=0){
			return "input";
		}
		if(flag==false) {
			System.out.println("addUserAction:id重复！");	
			info.add("id重复！") ;
			ctx.put("req", info);
			return "input";
		}		
		else{
		loginBiz.addUser(condition);		
		System.out.println("addUserAction_result:insert_success");	
		}
		return "success";
		
	}
}
