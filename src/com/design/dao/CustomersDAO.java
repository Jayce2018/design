package com.design.dao;

import java.util.List;

import com.design.entity.Customers;

public interface CustomersDAO {	
	public void addCustomers(Customers condition);// �����̼���ϸ��Ϣ��Ϣ	
	public boolean findCustomer(Customers condition);// ����ID��ѯ�̼��Ƿ����
	public void deleteCustomers(Customers condition);// ɾ���̼���ϸ��Ϣ��Ϣ	
	public List<Customers> listCustomers();// ��ȡ�����̼���ϸ��Ϣ	
}
