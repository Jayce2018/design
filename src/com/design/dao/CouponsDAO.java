package com.design.dao;

import java.util.List;
import com.design.entity.Coupons;


public interface CouponsDAO {	
	public void addCoupons(Coupons condition);// 新增奖券
	public List<Coupons> findCouponsByCustomerid(Coupons condition);// 根据商家ID获取设置的全部奖券
}
