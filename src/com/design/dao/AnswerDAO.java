package com.design.dao;

import java.util.List;

import com.design.entity.Answer;
import com.design.entity.AnswerId;
import com.design.entity.Answer_table;
import com.design.entity.Charts_data;

public interface AnswerDAO {	
	public void addAnswer(AnswerId condition);// ������д����Ϣ	
	public List<Answer_table> tableAnswer(Answer_table condition);// ��ȡ��ṹ
	public List<AnswerId> findAnswerByQnid(Integer qnid);// ��ȡĳ����
	public List<Charts_data> findChartData(Integer qnid,Integer topicid);// ��ȡ����ͼ������
	public boolean findUserSerfflag(Integer qnid,String userid);//��ȡ�û��Ƿ���дĳ��ı��
}
