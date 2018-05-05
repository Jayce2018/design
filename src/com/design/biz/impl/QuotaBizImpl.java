package com.design.biz.impl;

import java.util.List;

import com.design.biz.QuotaBiz;
import com.design.dao.QuotaDAO;
import com.design.entity.Quota;
import com.design.entity.User_serf;

public  class QuotaBizImpl implements QuotaBiz {
	QuotaDAO QuotaDAO;
	public void setQuotaDAO(QuotaDAO QuotaDAO){
		this.QuotaDAO=QuotaDAO;
	}	
	@Override
	public void addQuota(Quota condition) {
		// TODO Auto-generated method stub
		QuotaDAO.addQuota(condition);
	}
	@Override
	public List<User_serf> findSerfinfo(int m, int n) {
		// TODO Auto-generated method stub
		List<User_serf> list=QuotaDAO.findSerfinfo(m, n);
		return list;
	}
	@Override
	public List<User_serf> fuzzyFindSerfinfo(String keys) {
		// TODO Auto-generated method stub
		List<User_serf> list=QuotaDAO.fuzzyFindSerfinfo(keys);
		return list;
	}
	@Override
	public List<User_serf> screenFindSerfinfo(String key1, String key2) {
		// TODO Auto-generated method stub
		List<User_serf> list=QuotaDAO.screenFindSerfinfo(key1, key2);
		return list;
	}
	@Override
	public List<User_serf> fuzzyAllFindSerfinfo(String keys) {
		// TODO Auto-generated method stub
		List<User_serf> list=QuotaDAO.fuzzyAllFindSerfinfo(keys);
		return list;
	}
	@Override
	public List<User_serf> screenAllFindSerfinfo(String key1, String key2) {
		// TODO Auto-generated method stub
		List<User_serf> list=QuotaDAO.screenAllFindSerfinfo(key1, key2);
		return list;
	}
	@Override
	public boolean deleteQuota(Quota condition) {
		// TODO Auto-generated method stub
		boolean flag=QuotaDAO.deleteQuota(condition);
		return flag;
	}
}
