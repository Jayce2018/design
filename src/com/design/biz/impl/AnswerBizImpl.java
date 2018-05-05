package com.design.biz.impl;

import java.util.List;

import com.design.biz.AnswerBiz;
import com.design.dao.AnswerDAO;
import com.design.entity.AnswerId;
import com.design.entity.Answer_table;
import com.design.entity.Charts_data;

public class AnswerBizImpl implements AnswerBiz {
	AnswerDAO answerDAO;
	public void setAnswerDAO(AnswerDAO answerDAO){
		this.answerDAO=answerDAO;
	}	
	
	public void addAnswer(AnswerId condition) {
		answerDAO.addAnswer(condition);
	}

	@Override
	public List<Answer_table> tableAnswer(Answer_table condition) {
		List<Answer_table> list=answerDAO.tableAnswer(condition);
		return list;
	}

	@Override
	public List<AnswerId> findAnswerByQnid(Integer qnid) {
		// TODO Auto-generated method stub
		List<AnswerId> list=answerDAO.findAnswerByQnid(qnid);
		return list;
	}

	@Override
	public List<Charts_data> findChartData(Integer qnid, Integer topicid) {
		// TODO Auto-generated method stub
		List<Charts_data> list=answerDAO.findChartData(qnid, topicid);
		return list;
	}

	@Override
	public boolean findUserSerfflag(Integer qnid, String userid) {
		// TODO Auto-generated method stub
		boolean flag=answerDAO.findUserSerfflag(qnid, userid);		
		return flag;
	}

}
