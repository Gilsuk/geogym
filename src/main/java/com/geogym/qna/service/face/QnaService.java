package com.geogym.qna.service.face;

import java.util.List;

import com.geogym.common.dto.Paging;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.Search;
import com.geogym.user.dto.User;

public interface QnaService {
	
	
	/**
	 * 페이징 정보를 활용하여 보여질 게시글 목록만 조회
	 *  
	 * @param Paging - 페이징 정보
	 * @return List - 게시글 목록
	 */
	public List<Qna> getListAll(Paging paging);
	

	/**
	 * 유저가 쓴 글 검색 (페이징)
	 * @param User - 유저 
	 * @param paging - 페이징
	 * @return 
	 */
	public List<Qna> getListAccount(User user, Paging paging);
	
	/**
	 * 조건 검색 (페이징)
	 * @param search - 검색조건
	 * @param paging - 페이징
	 * @return
	 */
	public List<Qna> getListAccount(Search search, Paging paging);
	
	
	
	/**
	 * 요청파라미터 curPage를 파싱한다
	 * Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
	 * 
	 * @return Paging - 페이징 정보
	 */
	public Paging getPaging();
	
	
	/**
	 * 페이징 계산 
	 * @param user - 유저
	 * @return
	 */
	public Paging getPaging(User user);
	
	
	/**
	 * 페이징 계산 
	 * @param paging - 검색조건
	 * @return
	 */
	public Paging getPaging(int curPage);
	
	
	/**
	 * 요청 파라미터 게시글 번호 파싱
	 * 
	 * @return QnA - 게시글 번호를 가진 객체
	 */
	public Qna getQna_no();
	
	
	/**
	 * 질문글 작성(유저)
	 * 	입력한 게시글 내용을 DB에 저장
	 * 
	 *  첨부파일을 함께 업로드 할 수 있도록 처리
	 * 
	 * @param req - 요청정보 객체(게시글내용 + 첨부파일)
	 * write - 글쓰기
	 * void - 반환 받을게 아무것도 없을 때
	 */
	public void write(Qna qna);
	
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
	public void writeAnswer();
	

	/**
	 * 게시글 수정
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void modify(Qna qna);

	
	/**
	 * 게시글 삭제
	 * 
	 * @param qna - 삭제할 게시글 번호를 가진 객체
	 * String - 삭제됐다는 확인 메세지 보내기 
	 */
	public void delete(Qna qna);

	/**
	 * 게시글 조회
	 * 
	 * @param qna - qna_no DTO
	 * @return Qna - 조회 결과
	 */
	public Qna view(Qna qna);






	
	



}
