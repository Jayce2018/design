package com.design.biz;

import java.util.List;

import com.design.entity.Topic;

public interface TopicBiz {	
	public void addTopic(Topic condition);
	public List findTopic(Topic condition);
}

