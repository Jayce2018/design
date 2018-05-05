package com.design.dao;


import java.util.List;

import com.design.entity.Option;
import com.design.entity.Topic;

public interface OptionDAO {	
	public void addOption(Option condition);// 新增选项
	public List findTopic(Topic condition);// 查询题目信息
}
