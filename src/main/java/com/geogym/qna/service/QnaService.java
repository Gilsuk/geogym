package com.geogym.qna.service;

import java.util.List;

import org.springframework.ui.Model;

import com.geogym.common.dto.Paging;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAttachment;

public interface QnaService {
	
	//목록불러오기
	public List<Qna> getList(Paging paging, int boardno);

	//검색했을때 검색조건에 맞는 목록만 불러오기 
	public List<Qna> getSearchList(Paging paging, int boardno);

	//페이징 불러오기
	public Paging getPaging(Model req);

	//상세보기
	//boardno로 조회해서 게시글 보기
	public Qna view(Qna qna_no);

	//게시글 작성(파일첨부 x )
	public void write(Qna qna_no);

	//게시글 작성(파일첨부 o )
	public int write(Model req);

	//게시글에 첨부된 파일 가져오기 
	public QnaAttachment getFile(QnaAttachment qnaAttachment);
	   
	//게시판 큐앤에이 넘버 추출
	public Qna getIdx(Model req);
  
	//게시글 삭제
	public void delete(Qna qna_no);

	//게시글 수정
	public void update(Model req);


}
