package com.design.dao;


import java.util.List;

import com.design.entity.Topic;

public interface TopicDAO {	
	public void addTopic(Topic condition);// ������Ŀ
	public List findTopic(Topic condition);// ��ѯ��Ŀ
}
