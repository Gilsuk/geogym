package com.geogym.qna.dao;

import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;

public interface QnaAnswerDao {
	
	public void writeAnswer(QnaAnswer qnaAnswer);

	public QnaAnswer selectAnswerByQnaNo(Qna qna);
}
