package com.design.dao;


import java.util.List;

import com.design.entity.Quota;
import com.design.entity.User_serf;

public interface QuotaDAO {	
	public void addQuota(Quota condition);// ���ӷ��������Ϣ	
	public List<User_serf> findSerfinfo(int m,int n);//�����ѷ����Ļ��ϸ��Ϣ
	public List<User_serf> fuzzyFindSerfinfo(String keys);//ģ������ʱ����Ч���ϸ��Ϣ
	public List<User_serf> screenFindSerfinfo(String key1,String key2);//ɸѡʱ����Ч���ϸ��Ϣ
	
	public List<User_serf> fuzzyAllFindSerfinfo(String keys);//ģ���������л��ϸ��Ϣ
	public List<User_serf> screenAllFindSerfinfo(String key1,String key2);//ɸѡ���л��ϸ��Ϣ
	
	public boolean deleteQuota(Quota condition);// ɾ�����������Ϣ
}
