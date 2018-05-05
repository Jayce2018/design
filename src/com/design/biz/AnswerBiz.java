package com.design.biz;


import java.util.List;

import com.design.entity.AnswerId;
import com.design.entity.Answer_table;
import com.design.entity.Charts_data;

public interface AnswerBiz {
	public void addAnswer(AnswerId condition);
	public List<Answer_table> tableAnswer(Answer_table condition);
	public List<AnswerId> findAnswerByQnid(Integer qnid);
	public List<Charts_data> findChartData(Integer qnid,Integer topicid);
	public boolean findUserSerfflag(Integer qnid,String userid);
}

