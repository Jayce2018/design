package com.design.dao;

import java.util.List;

import com.design.entity.Qn_quota;
import com.design.entity.Questionnaire;;

public interface QuestionnaireDAO {	
	public void addQuestionnaire(Questionnaire condition);// �����ʾ�
	public List selectQuestionnaire(Questionnaire condition);//��ѯ�ҵ������ʾ���Ϣ
	public List<Questionnaire> finddfbQuestionnaire(Questionnaire condition);//��ѯ���д������ʾ���Ϣ	
	public List<Questionnaire> findysjQuestionnaire(Questionnaire condition);//��ѯ����������ʾ���Ϣ	
	public List<Qn_quota> findyfbQuestionnaire(Qn_quota condition);//��ѯ�����ѷ����ʾ���Ϣ	
	public List<Questionnaire> findwwcQuestionnaire(Questionnaire condition);//��ѯδ����ʾ���Ϣ
}
