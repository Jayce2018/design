package com.design.dao;

import java.util.List;
import com.design.entity.Get_coupons;

public interface GetcouponsDAO {	
	public void addGetcoupons(String userid,int qnid);// �����û��񽱼�¼	
	public List<Get_coupons> findGetcouponsByUserid(String userid);//��ѯĳ�û�������Ч�Ľ�ȯ 	
}
