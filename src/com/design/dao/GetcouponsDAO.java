package com.design.dao;

import java.util.List;
import com.design.entity.Get_coupons;

public interface GetcouponsDAO {	
	public void addGetcoupons(String userid,int qnid);// 新增用户获奖记录	
	public List<Get_coupons> findGetcouponsByUserid(String userid);//查询某用户所有有效的奖券 	
}
