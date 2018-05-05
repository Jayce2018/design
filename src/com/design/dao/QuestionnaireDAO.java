package com.design.dao;

import java.util.List;

import com.design.entity.Qn_quota;
import com.design.entity.Questionnaire;;

public interface QuestionnaireDAO {	
	public void addQuestionnaire(Questionnaire condition);// 新增问卷
	public List selectQuestionnaire(Questionnaire condition);//查询我的所有问卷信息
	public List<Questionnaire> finddfbQuestionnaire(Questionnaire condition);//查询所有待发布问卷信息	
	public List<Questionnaire> findysjQuestionnaire(Questionnaire condition);//查询所有已设计问卷信息	
	public List<Qn_quota> findyfbQuestionnaire(Qn_quota condition);//查询所有已发布问卷信息	
	public List<Questionnaire> findwwcQuestionnaire(Questionnaire condition);//查询未完成问卷信息
}
