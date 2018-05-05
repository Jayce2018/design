package com.design.biz;

import java.util.List;

import com.design.entity.Quota;
import com.design.entity.User_serf;

public interface QuotaBiz {
	public void addQuota(Quota condition);
	public List<User_serf> findSerfinfo(int m,int n);
	public List<User_serf> fuzzyFindSerfinfo(String keys);
	public List<User_serf> screenFindSerfinfo(String key1,String key2);
	
	public List<User_serf> fuzzyAllFindSerfinfo(String keys);
	public List<User_serf> screenAllFindSerfinfo(String key1,String key2);
	public boolean deleteQuota(Quota condition);
}

