package com.design.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.design.biz.AnswerBiz;
import com.design.biz.CustomersBiz;
import com.design.biz.TypesBiz;
import com.design.entity.Customers;
import com.design.entity.Types;
import com.opensymphony.xwork2.ActionSupport;
public class listCustomersAction extends ActionSupport{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String result;	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	CustomersBiz customersBiz;	
	public void setCustomersBiz(CustomersBiz customersBiz){
		this.customersBiz=customersBiz;
	}
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request=ServletActionContext.getRequest();

	//处理查询请求		
		public String listCustomers(){		
			List<Customers> list=customersBiz.listCustomers();		
			result = "{\"result\":"+JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd")+"}";
			System.out.println("result:"+result);
			if(list.size()>0){				
				System.out.println("listCustomersAction_success");
				return "success";					
			}			
			return "error";			
		}
}
