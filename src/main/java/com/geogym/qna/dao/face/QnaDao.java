package com.geogym.qna.dao.face;

import java.util.List;

import com.geogym.common.dto.Paging;
import com.geogym.qna.dto.Qna;

public interface QnaDao {
	
	public int selectCntAll();

	public List<Qna> selectAll(Paging paging);

	public Qna selectQnaByQnaNo(Qna qna);

	public void updateHit(Qna qna);

	public void delete(Qna qna);

	public void update(Qna qna);

	public void write(Qna qna);

}
