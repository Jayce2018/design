package com.design.dao;

import java.util.List;

import com.design.entity.Customers;

public interface CustomersDAO {	
	public void addCustomers(Customers condition);// 增加商家详细信息信息	
	public boolean findCustomer(Customers condition);// 根据ID查询商家是否存在
	public void deleteCustomers(Customers condition);// 删除商家详细信息信息	
	public List<Customers> listCustomers();// 获取所有商家详细信息	
}
