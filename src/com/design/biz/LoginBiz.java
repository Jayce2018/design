package com.design.biz;
import java.util.List;
import com.design.entity.User;

public interface LoginBiz {
	public List Login(User condition);
	public void addUser(User condition);
	public boolean findLogin(User condition);
	public void updateUser(User condition);
	public void checkUser(User condition);
	public List selectUser();
	public boolean deleteUser(User condition);
	public boolean findUser(User condition);
}

