package com.design.biz.impl;

import java.util.List;

import com.design.biz.OptionBiz;
import com.design.dao.OptionDAO;
import com.design.entity.Option;
import com.design.entity.Topic;


public  class OptionBizImpl implements OptionBiz {
	
	OptionDAO OptionDAO;
	public void setOptionDAO(OptionDAO OptionDAO){
		this.OptionDAO=OptionDAO;
	}
	
	@Override
	public void addOption(Option condition) {
		// TODO Auto-generated method stub
		OptionDAO.addOption(condition);
	}

	@Override
	public List findTopic(Topic condition) {		
		// TODO Auto-generated method stub
				List rs= OptionDAO.findTopic(condition);
				return rs;
		
	}

}
