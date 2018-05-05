package com.design.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.design.biz.LoginBiz;
import com.design.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class updateUserAction extends ActionSupport implements SessionAware{
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
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	//�����������	
		public String updateUser() throws Exception{		
			String ps=null;
			ps=getPs();
			System.out.println("ps="+ps);
			System.out.println("updateUseraction:"+id+' '+name+' '+password+' '+type);
			User condition=new User();		
			User user=new User();		
			List<String> info = new ArrayList<String>() ;	// �ռ�����			
			condition.setId(id);
			condition.setPassword(password);
			condition.setType(type);
			condition.setName(name);
			condition.setGender(gender);
			user.setId(id);
			user.setPassword(ps);
			user.setType(type);
			List list =loginBiz.Login(user);
			ActionContext ctx =ActionContext.getContext();
			System.out.println("updateUserAction_flag:"+flag);
			if(condition.getId().length()==0){
				System.out.println("addUserAction:id����Ϊ�գ�");	
				info.add("id����Ϊ�գ�") ;
				ctx.put("req", info);			
			}
			if(condition.getName().length()==0){
				System.out.println("addUserAction:��������Ϊ�գ�");	
				info.add("��������Ϊ�գ�") ;
				ctx.put("req", info);			
			}
			if(condition.getPassword().length()==0){
				System.out.println("addUserAction:���벻��Ϊ�գ�");	
				info.add("���벻��Ϊ�գ�") ;
				ctx.put("req", info);			
			}
			if(ps.length()==0){
				System.out.println("addUserAction:�����벻��Ϊ�գ�");	
				info.add("�����벻��Ϊ�գ�") ;
				ctx.put("req", info);			
			}
			if(condition.getType().length()==0){
				System.out.println("addUserAction:���Ͳ���Ϊ�գ�");	
				info.add("���Ͳ���Ϊ�գ�") ;
				ctx.put("req", info);			
			}
			if(list.size()==0){
				info.add("ԭ������û����Ͳ���ȷ��");
				ctx.put("req", info);	
				return "input";
			}
			loginBiz.updateUser(condition);
			return "success";
		}
	

}
