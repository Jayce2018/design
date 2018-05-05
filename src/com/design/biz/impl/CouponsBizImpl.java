package com.design.biz.impl;

import java.util.List;

import com.design.biz.CouponsBiz;
import com.design.dao.CouponsDAO;
import com.design.entity.Coupons;


public  class CouponsBizImpl implements CouponsBiz {
	
	CouponsDAO couponsDAO;
	public void setCouponsDAO(CouponsDAO couponsDAO){
		this.couponsDAO=couponsDAO;
	}
	
	@Override
	public void addCoupons(Coupons condition) {
		// TODO Auto-generated method stub
		couponsDAO.addCoupons(condition);
	}

	@Override
	public List<Coupons> findCouponsByCustomerid(Coupons condition) {
		// TODO Auto-generated method stub
		List<Coupons> list=couponsDAO.findCouponsByCustomerid(condition);
		return list;
	}
}
