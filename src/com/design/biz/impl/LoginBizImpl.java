package com.design.biz.impl;

import java.util.List;

import com.design.biz.LoginBiz;
import com.design.dao.LoginDAO;
import com.design.entity.Questionnaire;
import com.design.entity.User;

public  class LoginBizImpl implements LoginBiz {
	LoginDAO loginDAO;
	public void setLoginDAO(LoginDAO loginDAO){
		this.loginDAO=loginDAO;
	}
	@Override
	public List Login(User condition) {
		// TODO Auto-generated method stub		
		return loginDAO.search(condition);
	}
	@Override
	public void addUser(User condition) {
		// TODO Auto-generated method stub
		loginDAO.addUser(condition);
	}
	@Override
	public boolean findLogin(User condition) {
		// TODO Auto-generated method stub
		boolean flag=loginDAO.findLogin(condition.getId());
		return flag;
	}
	@Override
	public void updateUser(User condition) {
		// TODO Auto-generated method stub
		loginDAO.updateUser(condition);
	}
	@Override
	public List selectUser() {
		// TODO Auto-generated method stub
		List list=loginDAO.selectUser();
		return list;
	}
	@Override
	public boolean deleteUser(User condition) {
		// TODO Auto-generated method stub
		boolean flag=loginDAO.deleteUser(condition.getId());
		if(flag){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public void checkUser(User condition) {
		// TODO Auto-generated method stub
		loginDAO.checkUser(condition);
	}
	@Override
	public boolean findUser(User condition) {
		// TODO Auto-generated method stub
		boolean flag=loginDAO.findUser(condition);
		return flag;
	}
}
