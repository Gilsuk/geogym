package com.geogym.qna.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.qna.dao.QnaAnswerDao;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;
import com.geogym.qna.service.face.QnaAnswerService;

@Service
public class QnaAnswerServiceImpl implements QnaAnswerService {

	@Autowired
	QnaAnswerDao qnaAnswerDao;

	@Override
	public void writeAnswer(QnaAnswer qnaAnswer) {
		qnaAnswerDao.writeAnswer(qnaAnswer);
	}

	@Override
	public QnaAnswer viewAnswer(Qna qna) {
		return qnaAnswerDao.selectAnswerByQnaNo(qna);
	}

}
