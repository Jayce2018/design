package com.design.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.design.biz.AnswerBiz;
import com.design.biz.GetcouponsBiz;
import com.design.entity.AnswerId;
import com.design.entity.Answer_table;
import com.design.entity.Get_coupons;
import com.opensymphony.xwork2.ActionSupport;
public class findGetcouponsByUseridAction extends ActionSupport{	
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
	
	GetcouponsBiz getcouponsBiz;	
	public void setGetcouponsBiz(GetcouponsBiz getcouponsBiz){
		this.getcouponsBiz=getcouponsBiz;
	}
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request=ServletActionContext.getRequest();

	//处理查询请求		
		public String findGetcouponsByUserid(){	
			String userid=request.getParameter("userid");		
		
			List<Get_coupons> list=getcouponsBiz.findGetcouponsByUserid(userid);
			
			result = "{\"result\":"+JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd")+"}";
			System.out.println("result:"+result);
			if(list.size()>0){				
				System.out.println("findGetcouponsByUseridAction_success");
				return "success";					
			}			
			return "error";			
		}
}
