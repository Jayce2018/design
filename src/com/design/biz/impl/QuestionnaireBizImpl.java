package com.design.biz.impl;

import java.util.List;

import com.design.biz.QuestionnaireBiz;
import com.design.dao.QuestionnaireDAO;
import com.design.entity.Qn_quota;
import com.design.entity.Questionnaire;


public  class QuestionnaireBizImpl implements QuestionnaireBiz {
	
	QuestionnaireDAO QuestionnaireDAO;
	public void setQuestionnaireDAO(QuestionnaireDAO QuestionnaireDAO){
		this.QuestionnaireDAO=QuestionnaireDAO;
	}
	
	@Override
	public void addQuestionnaire(Questionnaire condition) {
		// TODO Auto-generated method stub
		QuestionnaireDAO.addQuestionnaire(condition);
	}

	@Override
	public List<Questionnaire> selectQuestionnaire(Questionnaire condition) {
		// TODO Auto-generated method stub
		List<Questionnaire> list=QuestionnaireDAO.selectQuestionnaire(condition);
		return list;
	}

	@Override
	public List<Questionnaire> finddfbQuestionnaire(Questionnaire condition) {
		// TODO Auto-generated method stub
		List<Questionnaire> list=QuestionnaireDAO.finddfbQuestionnaire(condition);
		return list;
	}

	@Override
	public List<Questionnaire> findysjQuestionnaire(Questionnaire condition) {
		// TODO Auto-generated method stub
		List<Questionnaire> list=QuestionnaireDAO.findysjQuestionnaire(condition);
		return list;
	}

	@Override
	public List<Qn_quota> findyfbQuestionnaire(Qn_quota condition) {
		// TODO Auto-generated method stub
		List<Qn_quota> list=QuestionnaireDAO.findyfbQuestionnaire(condition);
		return list;
	}

	@Override
	public List<Questionnaire> findwwcQuestionnaire(Questionnaire condition) {
		// TODO Auto-generated method stub
		List<Questionnaire> list=QuestionnaireDAO.findwwcQuestionnaire(condition);
		return list;
	}

}
