package com.design.dao;

import java.util.List;
import com.design.entity.Coupons;


public interface CouponsDAO {	
	public void addCoupons(Coupons condition);// ������ȯ
	public List<Coupons> findCouponsByCustomerid(Coupons condition);// �����̼�ID��ȡ���õ�ȫ����ȯ
}
