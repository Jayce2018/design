package com.design.action;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.design.biz.CustomersBiz;
import com.design.biz.LoginBiz;
import com.design.entity.Customers;
import com.design.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class addCustomersAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerid;
	private String name;
	private String managername;
	private String phone;
	private String mail;
	private String storeurl;
	
	
	
	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getStoreurl() {
		return storeurl;
	}

	public void setStoreurl(String storeurl) {
		this.storeurl = storeurl;
	}
	CustomersBiz customersBiz;
	public void setCustomersBiz(CustomersBiz CustomersBiz){
		this.customersBiz=CustomersBiz;
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
	public String addCustomers() throws Exception{			
		ActionContext ctx = ActionContext.getContext();
		List<String> info = new ArrayList<String>();// 收集错误
		
		Customers condition=new Customers();		
		condition.setCustomerid(customerid);
		condition.setName(name);
		condition.setManagername(managername);
		condition.setPhone(phone);
		condition.setMail(mail);
		condition.setStoreurl(storeurl);	
		
		User user=new User();
		user.setId(customerid);
		user.setType("商家");
		boolean userflag=loginBiz.findUser(user);
		System.out.println("userflag:"+userflag);
		boolean customerflag=customersBiz.findCustomer(condition);
		System.out.println("customerflag:"+customerflag);
		if(!userflag){
			info.add("商家未注册！") ;			
		}
		if(customerflag){
			info.add("信息已填写完成,等待管理审核！") ;			
		}
		if(condition.getCustomerid().length()==0||condition.getName().length()==0||condition.getManagername().length()==0||condition.getPhone().length()==0||condition.getMail().length()==0||condition.getStoreurl().length()==0){
			info.add("信息不完整！") ;			
		}	
		System.out.println("infosize:"+info.size());
		if(info.size()==0){
			customersBiz.addCustomers(condition);		
			System.out.println("addCustomersAction_result:insert_success");			
		}else{
			ctx.put("req", info);
			System.out.println("addCustomersAction_result:insert_error");				
		}
		return "success";
		
	}
}
