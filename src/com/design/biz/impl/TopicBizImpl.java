package com.design.biz.impl;

import java.util.List;

import com.design.biz.TopicBiz;
import com.design.dao.TopicDAO;
import com.design.entity.Topic;


public  class TopicBizImpl implements TopicBiz {
	
	TopicDAO TopicDAO;
	public void setTopicDAO(TopicDAO TopicDAO){
		this.TopicDAO=TopicDAO;
	}
	
	@Override
	public void addTopic(Topic condition) {
		// TODO Auto-generated method stub
		TopicDAO.addTopic(condition);
	}

	@Override
	public List findTopic(Topic condition) {
		// TODO Auto-generated method stub
		List rs= TopicDAO.findTopic(condition);
		return rs;
	}

}
