package com.design.dao;


import java.util.List;

import com.design.entity.Option;
import com.design.entity.Topic;

public interface OptionDAO {	
	public void addOption(Option condition);// ����ѡ��
	public List findTopic(Topic condition);// ��ѯ��Ŀ��Ϣ
}
