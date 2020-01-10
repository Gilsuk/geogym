package com.geogym.qna.dao;

import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;

public interface QnaAnswerDao {
	
	public void writeAnswer(QnaAnswer qnaAnswer);

	public QnaAnswer selectAnswerByQnaNo(Qna qna);

	/**
	 * 답글 삭제
	 * 
	 * @param answer - QnaAnswer 의 QnaAnswer_no 를 가용
	 */
	public void delete(QnaAnswer answer);
}
