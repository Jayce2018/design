package com.design.dao;


import java.util.List;

import com.design.entity.Quota;
import com.design.entity.User_serf;

public interface QuotaDAO {	
	public void addQuota(Quota condition);// 增加发布配额信息	
	public List<User_serf> findSerfinfo(int m,int n);//检索已发布的活动详细信息
	public List<User_serf> fuzzyFindSerfinfo(String keys);//模糊检索时间有效活动详细信息
	public List<User_serf> screenFindSerfinfo(String key1,String key2);//筛选时间有效活动详细信息
	
	public List<User_serf> fuzzyAllFindSerfinfo(String keys);//模糊检索所有活动详细信息
	public List<User_serf> screenAllFindSerfinfo(String key1,String key2);//筛选所有活动详细信息
	
	public boolean deleteQuota(Quota condition);// 删除发布配额信息
}
