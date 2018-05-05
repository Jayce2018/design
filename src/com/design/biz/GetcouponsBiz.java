package com.design.biz;

import java.util.List;

import com.design.entity.Get_coupons;

public interface GetcouponsBiz {	
	public void addGetcoupons(String userid,int qnid);
	public List<Get_coupons> findGetcouponsByUserid(String userid);
}

