package com.design.biz.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.design.biz.UnionQnBiz;
import com.design.dao.UnionQnDAO;
import com.design.entity.Qn_topic_option_Union;


public  class UnionQnBizImpl implements UnionQnBiz {
	UnionQnDAO UnionQnDAO;
	public void setUnionQnDAO(UnionQnDAO UnionQnDAO){
		this.UnionQnDAO=UnionQnDAO;
	}

	@Override
	public List<Qn_topic_option_Union> selectUnionQn(int qnid) {
		
		List<Object[]> list=UnionQnDAO.selectUnionQn(qnid);
		//System.out.println("++++++++++++:"+list.get(0));
		List<Qn_topic_option_Union> un=new ArrayList<Qn_topic_option_Union>(list.size());
		
		for (Object[] objs : list) {
			Qn_topic_option_Union qn=new Qn_topic_option_Union();	
			qn.setQnid((Integer)objs[0]);
			qn.setQnname((String)objs[1]);
			qn.setToorderid((Integer)objs[2]);
			qn.setCreaterid((String)objs[3]);
			qn.setCreatedate((Date)objs[4]);			
			qn.setTopicid((Integer)objs[5]);
			qn.setTocontent((String)objs[6]);
			qn.setToorderid((Integer)objs[7]);			
			qn.setOptionid((Integer)objs[8]);
			qn.setOpcontent((String)objs[9]);
			qn.setOporderid(Integer.parseInt((String)objs[10]));	
			qn.setTixing((Integer)objs[11]);
			un.add(qn);
		}
		//System.out.println("test++++++++++++++++:"+un.size());
		return un;
	}


}
