package com.design.biz;

import java.util.List;

import com.design.entity.Option;
import com.design.entity.Topic;

public interface OptionBiz {	
	public void addOption(Option condition);
	public List findTopic(Topic condition);
}

