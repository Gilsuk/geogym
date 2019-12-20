package com.geogym.qna.service;

public interface Attachment {
	
	/**
	 * 파일 업로드(큐앤에이, 기타 포함)
	 * @param attachment - 첨부파일 정보 
	 */
	public void uploadFile(Attachment attachment);
	
	/**
	 * 첨부파일 얻기
	 * 
	 * @param qna(글) - 첨부파일을 조회할 게시글 번호 객체
	 * @return QnAFile(첨부파일) - 게시글에 첨부된 파일 정보
	 */
	public QnAFile viewFile(QnA qna);

}
