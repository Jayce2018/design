package com.design.dao;

import java.util.List;

import com.design.entity.Answer;
import com.design.entity.AnswerId;
import com.design.entity.Answer_table;
import com.design.entity.Charts_data;

public interface AnswerDAO {	
	public void addAnswer(AnswerId condition);// 增加填写答案信息	
	public List<Answer_table> tableAnswer(Answer_table condition);// 获取表结构
	public List<AnswerId> findAnswerByQnid(Integer qnid);// 获取某表结果
	public List<Charts_data> findChartData(Integer qnid,Integer topicid);// 获取数据图表数据
	public boolean findUserSerfflag(Integer qnid,String userid);//获取用户是否填写某活动的标记
}
