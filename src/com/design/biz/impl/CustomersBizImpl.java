package com.design.biz.impl;

import java.util.List;

import com.design.biz.CustomersBiz;
import com.design.dao.CustomersDAO;
import com.design.entity.Customers;

public  class CustomersBizImpl implements CustomersBiz {
	CustomersDAO customersDAO;
	public void setCustomersDAO(CustomersDAO CustomersDAO){
		this.customersDAO=CustomersDAO;
	}	
	@Override
	public void addCustomers(Customers condition) {
		// TODO Auto-generated method stub
		customersDAO.addCustomers(condition);
	}
	@Override
	public boolean findCustomer(Customers condition) {
		// TODO Auto-generated method stub
		boolean flag=customersDAO.findCustomer(condition);
		return flag;
	}
	@Override
	public void deleteCustomers(Customers condition) {
		// TODO Auto-generated method stub
		customersDAO.deleteCustomers(condition);
	}
	@Override
	public List<Customers> listCustomers() {
		// TODO Auto-generated method stub
		List<Customers> list=customersDAO.listCustomers();
		return list;
	}
}
