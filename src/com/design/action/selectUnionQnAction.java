package com.design.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.design.biz.UnionQnBiz;
import com.design.entity.Qn_topic_option_Union;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class selectUnionQnAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	HttpServletRequest request=ServletActionContext.getRequest();
	
	UnionQnBiz UnionQnBiz;
	public void setUnionQnBiz(UnionQnBiz UnionQnBiz){
		this.UnionQnBiz=UnionQnBiz;
	}
	Map<String,Object> session;	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	//处理查询请求		
		public String selectUnionQn(){		
			int qnid=Integer.parseInt(request.getParameter("data"));
			System.out.println("selectUnionQnAction_qnid:"+qnid);
			//ActionContext ctx =ActionContext.getContext();
			List<Qn_topic_option_Union> list=UnionQnBiz.selectUnionQn(qnid);
			System.out.println("selectUnionQnAction_list.size:"+list.size());
			
			if(list.size()>0){
				//ctx.getSession().put("ses", list);//往session里放入ses	
				//System.out.println("++++++++++++++++t1:"+list.size());
				request.setAttribute("qn", list);
				System.out.println("selectUnionQnAction_success");
				return "success";					
			}			
			return "error";
		}
}
