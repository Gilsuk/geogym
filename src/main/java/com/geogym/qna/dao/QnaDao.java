package com.geogym.qna.dao;

import java.util.List;

import com.geogym.qna.dto.Paging;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;

public interface QnaDao {
	
	public int selectCntAll(Paging param);

	public List<Qna> selectAll(Paging paging);

	public Qna selectQnaByQnaNo(Qna qna);

	public void delete(Qna qna);

	public void update(Qna qna);

	public void write(Qna qna);

}
