package com.design.dao;


import java.util.List;

import com.design.entity.Topic;

public interface TopicDAO {	
	public void addTopic(Topic condition);// 新增题目
	public List findTopic(Topic condition);// 查询题目
}
