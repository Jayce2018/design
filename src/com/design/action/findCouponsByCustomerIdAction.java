package com.design.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.design.biz.CouponsBiz;
import com.design.entity.Coupons;
import com.opensymphony.xwork2.ActionSupport;

public class findCouponsByCustomerIdAction extends ActionSupport{	
	private String result;	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	CouponsBiz couponsBiz;
	public void setCouponsBiz(CouponsBiz couponsBiz){
		this.couponsBiz=couponsBiz;
	}
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request=ServletActionContext.getRequest();

	//处理查询请求		
		public String findCouponsByCustomerId(){	
			String cid=request.getParameter("cid");
			System.out.println("findCouponsByCustomerIdAction:"+cid);			
			Coupons condition=new Coupons();
			condition.setCustomerid(cid);
			List<Coupons> list=couponsBiz.findCouponsByCustomerid(condition);
			
			result = "{\"result\":"+JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd")+"}";
			System.out.println("result:"+result);
			if(list.size()>0){				
				System.out.println("findCouponsByCustomerIdAction_success");
				return "success";					
			}			
			return "error";			
		}
}
