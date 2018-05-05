package com.design.biz;
import java.util.List;

import com.design.entity.Qn_quota;
import com.design.entity.Questionnaire;

public interface QuestionnaireBiz {	
	public void addQuestionnaire(Questionnaire condition);
	public List<Questionnaire> selectQuestionnaire(Questionnaire condition);
	public List<Questionnaire> finddfbQuestionnaire(Questionnaire condition);
	public List<Questionnaire> findysjQuestionnaire(Questionnaire condition);
	public List<Qn_quota> findyfbQuestionnaire(Qn_quota condition);
	public List<Questionnaire> findwwcQuestionnaire(Questionnaire condition);
}

