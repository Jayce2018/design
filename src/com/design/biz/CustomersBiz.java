package com.design.biz;

import java.util.List;

import com.design.entity.Customers;

public interface CustomersBiz {
	public void addCustomers(Customers condition);
	public boolean findCustomer(Customers condition);
	public void deleteCustomers(Customers condition);
	public List<Customers> listCustomers();
}

