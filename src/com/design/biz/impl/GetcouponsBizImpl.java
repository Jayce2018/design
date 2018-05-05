package com.design.biz.impl;

import java.util.List;

import com.design.biz.GetcouponsBiz;
import com.design.dao.GetcouponsDAO;
import com.design.entity.Get_coupons;

public  class GetcouponsBizImpl implements GetcouponsBiz {
	
	GetcouponsDAO getcouponsDAO;
	public void setGetcouponsDAO(GetcouponsDAO getcouponsDAO){
		this.getcouponsDAO=getcouponsDAO;
	}
	@Override
	public void addGetcoupons(String userid, int qnid) {
		// TODO Auto-generated method stub
		getcouponsDAO.addGetcoupons(userid, qnid);
	}
	@Override
	public List<Get_coupons> findGetcouponsByUserid(String userid) {
		// TODO Auto-generated method stub
		List<Get_coupons> list=getcouponsDAO.findGetcouponsByUserid(userid);
		return list;
	}
	
	
}
