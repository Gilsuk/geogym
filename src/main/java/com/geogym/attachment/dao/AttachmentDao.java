package com.geogym.attachment.dao;

import java.util.List;

import com.geogym.attachment.dto.Attachment;
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
	 * 연결된 파일 모두 삭제
	 * 게시글이 삭제될 때 호출할 메소드
	 * 즉, qna 게시글이 삭제될 때 그 게시글이 포함하고 있던 모든 attachment가 삭제되길 원함
	 * Qna_no를 기준으로 조회
	 * @param 게시글 번호가 포함된 qna dto
	 */
	void removeQna(Qna qna);



}
