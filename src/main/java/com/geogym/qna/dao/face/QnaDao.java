package com.geogym.qna.dao.face;

import java.util.List;

import com.geogym.common.dto.Paging;
import com.geogym.qna.dto.Qna;

public interface QnaDao {
	
	public int selectCntAll();

	public List<Qna> selectAll(Paging paging);

}
