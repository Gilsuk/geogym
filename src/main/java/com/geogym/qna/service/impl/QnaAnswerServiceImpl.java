package com.geogym.qna.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.attachment.service.AttachmentService;
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
	@Autowired
	AttachmentService attachmentService;

	@Override
	public void writeAnswer(QnaAnswer qnaAnswer) {
		System.out.println("1");
		qnaAnswerDao.writeAnswer(qnaAnswer);
	}

	@Override
	public QnaAnswer viewAnswer(Qna qna) {

		QnaAnswer answer = qnaAnswerDao.selectAnswerByQnaNo(qna);
		Trainer trainer = new Trainer() ;
		if (answer != null) {
			trainer.setTrainer_no(answer.getTrainer().getTrainer_no());
			answer.setTrainer(trainerService.getTrainer2(trainer));			
			answer.setQna(qnaService.view(answer.getQna()));
		}
		
		
		return answer;

	}

	@Override
	public void answerDelete(QnaAnswer answer) {
		// TODO Auto-generated method stub
		attachmentService.removeAllAttachments(answer);
		qnaAnswerDao.delete(answer);
		
	}

}
