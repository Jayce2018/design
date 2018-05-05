package com.design.dao;

import java.util.List;
import com.design.entity.User;
import com.design.entity.Questionnaire;;

public interface LoginDAO {
	public List search(User condition);//���ڵ�¼��Ϣ����֤
	public void addUser(User condition);// ע�������û�
	public boolean findLogin(String userid);// ���ڲ����û��Ƿ����
	public void updateUser(User condition);// update�û���Ϣ
	public void checkUser(User condition);// ����̻��͹���Ա��Ȩ
	public List selectUser();// ����user���е�����
	public boolean deleteUser(String userid);// ����idɾ���û�
	public boolean findUser(User condition);// ���ڲ���ĳ�����û��Ƿ����
}
