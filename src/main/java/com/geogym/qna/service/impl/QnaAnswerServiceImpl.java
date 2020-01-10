package com.geogym.qna.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.qna.dao.QnaAnswerDao;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;
import com.geogym.qna.service.face.QnaAnswerService;
import com.geogym.qna.service.face.QnaService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.trainer.service.TrainerService;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Service
public class QnaAnswerServiceImpl implements QnaAnswerService {

	@Autowired
	QnaAnswerDao qnaAnswerDao;
	@Autowired
	QnaService qnaService;
	@Autowired
	TrainerService trainerService;
	@Autowired
	UserService userService;

	@Override
	public void writeAnswer(QnaAnswer qnaAnswer) {
		qnaAnswerDao.writeAnswer(qnaAnswer);
	}

	@Override
	public QnaAnswer viewAnswer(Qna qna) {

		QnaAnswer answer = qnaAnswerDao.selectAnswerByQnaNo(qna);
		Trainer trainer = new Trainer() ;
		trainer.setTrainer_no(answer.getTrainer().getTrainer_no());
		
		answer.setQna(qnaService.view(answer.getQna()));
		answer.setTrainer(trainerService.getTrainer2(trainer));
		
		return answer;

	}

}
