package com.design.biz.impl;

import java.util.List;

import com.design.biz.AnswerBiz;
import com.design.biz.TypesBiz;
import com.design.dao.AnswerDAO;
import com.design.dao.TypesDAO;
import com.design.entity.AnswerId;
import com.design.entity.Answer_table;
import com.design.entity.Charts_data;
import com.design.entity.Types;

public class TypesBizImpl implements TypesBiz {
	TypesDAO typesDAO;
	public void setTypesDAO(TypesDAO typesDAO){
		this.typesDAO=typesDAO;
	}	

	@Override
	public List<Types> typeList() {
		// TODO Auto-generated method stub
		List<Types> list=typesDAO.typeList();
		return list;
	}

}
