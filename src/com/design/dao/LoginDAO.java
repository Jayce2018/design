package com.design.dao;

import java.util.List;
import com.design.entity.User;
import com.design.entity.Questionnaire;;

public interface LoginDAO {
	public List search(User condition);//用于登录信息的验证
	public void addUser(User condition);// 注册新增用户
	public boolean findLogin(String userid);// 用于查找用户是否存在
	public void updateUser(User condition);// update用户信息
	public void checkUser(User condition);// 审核商户和管理员授权
	public List selectUser();// 检索user所有的数据
	public boolean deleteUser(String userid);// 根据id删除用户
	public boolean findUser(User condition);// 用于查找某类型用户是否存在
}
