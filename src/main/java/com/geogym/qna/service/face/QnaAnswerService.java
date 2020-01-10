package com.geogym.qna.service.face;

import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;

public interface QnaAnswerService {
	
	/**
	 * 답글 작성(트레이너)
	 * 	입력한 게시글 내용을 DB에 저장
	 * 
	 *  첨부파일을 함께 업로드 할 수 있도록 처리
	 * 
	 * @param req - 요청정보 객체(게시글내용 + 첨부파일)
	 * write - 글쓰기
	 * void - 반환 받을게 아무것도 없을 때
	 */
	public void writeAnswer(QnaAnswer qnaAnswer);
	
	/**
	 * 답글 가져오기
	 * 
	 * @param qna
	 * @return
	 */
	public QnaAnswer viewAnswer(Qna qna);

	/**
	 * 답글 삭제
	 * 
	 * @param answer - QnaAnswer 의 QnaAnswer_no 를 가용
	 */
	public void answerDelete(QnaAnswer answer);




}
