package com.geogym.qna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.common.dto.Paging;
import com.geogym.qna.dao.face.QnaDao;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.Search;
import com.geogym.qna.service.face.QnaService;
import com.geogym.user.dto.User;


@Service
public class QnaServiceImpl implements QnaService{
	
	@Autowired QnaDao qnaDao;

	@Override
	public List<Qna> getListAll(Paging paging) {
		
		return qnaDao.selectAll(paging);
	}

	@Override
	public List<Qna> getListAccount(User user, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Qna> getListAccount(Search search, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paging getPaging() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paging getPaging(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paging getPaging(int curPage) {
		
		
		int totalCount = qnaDao.selectCntAll();
		
		Paging paging2 = new Paging(totalCount, curPage);
				
		return paging2;
	}

	@Override
	public Qna getQna_no() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeAnswer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String delete(Qna qna) {
		// TODO Auto-generated method stub
		return null;
	}

}
