package com.design.biz;

import java.util.List;

import com.design.entity.Coupons;

public interface CouponsBiz {	
	public void addCoupons(Coupons condition);	
	public List<Coupons> findCouponsByCustomerid(Coupons condition);
}

