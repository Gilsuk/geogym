package com.geogym.attachment.service;

import java.util.List;

import com.geogym.attachment.dto.Attachment;
import com.geogym.body.dto.BodyInfo;
import com.geogym.memo.dto.TrainingMemo;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;
import com.geogym.trainer.dto.Trainer;

/**
 * 업로드 파일 관리 서비스
 *
 */
public interface AttachmentService {
	
	/**
	 * 파일을 업로드 한다.
	 * @param attachment - attachment_no를 포함하여 완전한 정보를 담고 있는 attachment 객체
	 * attachment_no는 시퀀스를 통해 얻어온다.
	 */
	void upload(AttachmentService attachment);
	
	/**
	 * 시퀀스 nextval
	 */
	int getNextAttachmentNo();
	
	/**
	 * 연결된 업로드 파일 조회
	 * Qna_no를 기준으로 조회
	 * @param 게시글 번호가 포함된 qna dto
	 * @return 업로드 파일 리스트 반환. 조회 결과가 없다면, 비어있는 리스트를 반환한다.
	 */
	List<AttachmentService> getAttachments(Qna qna);
	
	/**
	 * 연결된 업로드 파일 조회
	 * QnaAnswer_no를 기준으로 조회
	 * @param 게시글 번호가 포함된 qnaAnswer dto
	 * @return 업로드 파일 리스트 반환. 조회 결과가 없다면, 비어있는 리스트를 반환한다.
	 */
	List<AttachmentService> getAttachments(QnaAnswer qnaAnswer);

	/**
	 * 연결된 업로드 파일 조회
	 * bodyinfo_no를 기준으로 조회
	 * @param 고유 번호가 포함된 BodyInfo dto
	 * @return 업로드 파일 리스트 반환. 조회 결과가 없다면, 비어있는 리스트를 반환한다.
	 */
	List<AttachmentService> getAttachments(BodyInfo bodyinfo);
	
	/**
	 * 트레이너의 프로필 사진을 반환
	 * @param trainer trainer_no를 포함하는 객체
	 */
	AttachmentService getAttachment(Trainer trainer);

	/**
	 * 트레이닝 메모의 첨부자료 조회
	 * @param trainingMemo - training_memo_no를 포함하는 객체
	 * @return
	 */
	AttachmentService getAttachment(TrainingMemo trainingMemo);

	/**
	 * 연결된 파일 모두 삭제
	 * 게시글이 삭제될 때 호출할 메소드
	 * 즉, qna 게시글이 삭제될 때 그 게시글이 포함하고 있던 모든 attachment가 삭제되길 원함
	 * Qna_no를 기준으로 조회
	 * @param 게시글 번호가 포함된 qna dto
	 */
	void removeAllAttachments(Qna qna);
	
	void removeAllAttachments(QnaAnswer qnaAnswer);

	void removeAllAttachments(BodyInfo bodyinfo);
	
	/**
	 * 해당 글에 포함된 하나의 업로드 파일만 삭제한다.
	 * qna_no와 attachment_no를 활용
	 * @param qna qna_no를 포함하는 객체
	 * @param attachment attachment_no를 포함하는 객체
	 */
	void removeAttachment(Qna qna, AttachmentService attachment);
	
	void removeAttachment(QnaAnswer qnaAnswer, AttachmentService attachment);

	void removeAttachment(BodyInfo bodyinfo, AttachmentService attachment);
	
	/**
	 * 업로드 파일을 교체한다.
	 * 기존 업로드된 파일은 삭제한다.
	 * @param attachment 교체 대상 attachment_no를 포함하는 객체
	 */
	void updateAttachment(Attachment attachment);

	/**
	 * 트레이너의 프로필 사진을 삭제
	 * 단, 해당컬럼은 NOT NULL 이므로 파일만 삭제하고, 컬럼에는 기본값 사진 주소로 업데이트 한다.
	 * @param trainer trainer_no를 포함하는 객체
	 */
	void removeAttachment(Trainer trainer);

	/**
	 * 상동
	 */
	void removeAttachment(TrainingMemo trainingMemo);
	
}
