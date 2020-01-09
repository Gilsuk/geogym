package com.geogym.attachment.dao;

import java.util.List;

import com.geogym.attachment.dto.Attachment;
import com.geogym.attachment.dto.Bodyinfo_attachment;
import com.geogym.attachment.dto.Qna_answer_attachment;
import com.geogym.attachment.dto.Qna_attachment;
import com.geogym.attachment.dto.User_attachment;
import com.geogym.body.dto.BodyInfo;
import com.geogym.memo.dto.TrainingMemo;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;
import com.geogym.trainer.dto.Trainer;

public interface AttachmentDao {

	/**
	 * 파일을 업로드 한다.
	 * 
	 *  
	 * @param multipartFile - multipartFile 타입의 파일을 업로드하고 attachment 형식으로 DB에 저장한다
	 * attachment_no는 시퀀스를 통해 얻어온다
	 * @return - 저장한 attachment 를 리턴한다
	 */
	void upload(Attachment attachment);

	/**
	 * 트레이너의 프로필 사진을 삭제
	 * 단, 해당컬럼은 NOT NULL 이므로 파일만 삭제하고, 컬럼에는 기본값 사진 주소로 업데이트 한다.
	 * @param trainer trainer_no를 포함하는 객체
	 */
	void removeTrainer(Trainer trainer);

	/**
	 * 트레이너의 프로필 사진을 반환
	 * @param trainer trainer_no를 포함하는 객체
	 */
	Attachment getTrainer(Trainer trainer);

	/**
	 * 트레이닝 메모의 첨부자료 조회
	 * @param trainingMemo - training_memo_no를 포함하는 객체
	 * @return
	 */
	Attachment getTrainingMemo(TrainingMemo trainingMemo);

	/**
	 * 연결된 업로드 파일 조회
	 * Qna_no를 기준으로 조회
	 * 
	 * @param 게시글 번호가 포함된 qna dto
	 * @return 업로드 파일 리스트 반환. 조회 결과가 없다면, 비어있는 리스트를 반환한다.
	 */
	List<Attachment> getQna_attachment(Qna qna);

	/**
	 * 연결된 업로드 파일 조회
	 * QnaAnswer_no를 기준으로 조회
	 * 
	 * @param 게시글 번호가 포함된 qnaAnswer dto
	 * @return 업로드 파일 리스트 반환. 조회 결과가 없다면, 비어있는 리스트를 반환한다.
	 */
	List<Attachment> getQnaAnswer_attachment(QnaAnswer qnaAnswer);

	/**
	 * 연결된 업로드 파일 조회
	 * bodyinfo_no를 기준으로 조회

	 * 
	 * @param 고유 번호가 포함된 BodyInfo dto
	 * @return 업로드 파일 리스트 반환. 조회 결과가 없다면, 비어있는 리스트를 반환한다.
	 */
	List<Attachment> getBodyInfo_attachment(BodyInfo bodyinfo);

	/**
	 * Qna_attachment 작성
	 * @param qna_attachment 를 입력하여 작성한다
	 */
	void setQna_attachment(Qna_attachment qna_attachment);
	
	/**
	 * Qna_answer_attachment 작성
	 * @param answer_attachment 를 입력하여 작성한다
	 */
	void setQna_answer_attachment(Qna_answer_attachment answer_attachment);
	
	/**
	 * Bodyinfo_attachment 작성 
	 * @param bodyinfo_attachment를 입력하여 작성한다
	 */
	void setBodyinfo_attachment(Bodyinfo_attachment bodyinfo_attachment);

	/**
	 * User_attachment 작성
	 * @param user_attachment를 입력하여 작성한다.
	 */
	void setUser_attachment(User_attachment user_attachment);
	
	/**
	 * Attachment 삭제
	 * 
	 * @param attachment_no 를 사용한다
	 */
	void removeAttachment(Attachment attachment);
	
	/**
	 * 연결된 removeQna_attachment 모두 삭제 
	 * @param qna 번호 사용 
	 */
	void removeQna_attachment(Qna qna);

	/**
	 * 연결된 QnaAnswer_attachment 모두 삭제
	 * 
	 * @param qnaAnswer_no 를 사용한다
	 */
	void removeQnaAnswer_attachment(QnaAnswer qnaAnswer);

	/**
	 * 연결된 BodyInfo_attachment 를 전부 삭제
	 * 
	 * @param bodyinfo_no 를 사용한다
	 */
	void removeBodyInfo_attachment(BodyInfo bodyinfo);

	/**
	 * 트레이너메모의 파일 삭제
	 * 단, 해당컬럼은 NOT NULL 이므로 파일만 삭제하고, 컬럼에는 기본값 사진 주소로 업데이트 한다.
	 * 
	 * @param trainingMemo
	 */
	void removeTrainingMemo(TrainingMemo trainingMemo);
	
	



}
