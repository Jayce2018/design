package com.design.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.design.biz.AnswerBiz;
import com.design.biz.TypesBiz;
import com.design.entity.Types;
import com.opensymphony.xwork2.ActionSupport;
public class typesListAction extends ActionSupport{	
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
	
	TypesBiz typesBiz;	
	public void setTypesBiz(TypesBiz typesBiz){
		this.typesBiz=typesBiz;
	}
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request=ServletActionContext.getRequest();

	//处理查询请求		
		public String typesList(){		
			List<Types> list=typesBiz.typeList();			
			result = "{\"result\":"+JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd")+"}";
			System.out.println("result:"+result);
			if(list.size()>0){				
				System.out.println("typesListAction_success");
				return "success";					
			}			
			return "error";			
		}
}
