package com.geogym.qna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.attachment.service.AttachmentService;
import com.geogym.qna.dao.QnaDao;
import com.geogym.qna.dto.Paging;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;
import com.geogym.qna.dto.Search;
import com.geogym.qna.service.face.QnaService;
import com.geogym.user.dto.User;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	QnaDao qnaDao;
	@Autowired
	AttachmentService attachmentService;

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
	public Paging getPaging(Paging param) {

		int totalCount = qnaDao.selectCntAll(param);

		Paging paging = new Paging(totalCount, param.getCurPage());

		paging.setCategoryNo(param.getCategoryNo());
		paging.setSearch(param.getSearch());

		return paging;
	}

	@Override
	public Qna getQna_no() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(Qna qna) {
		qnaDao.write(qna);
	}

	@Override
	public void modify(Qna qna) {
		qnaDao.update(qna);
	}

	@Override
	public void delete(Qna qna) {
		attachmentService.removeAllAttachments(qna);
		qnaDao.delete(qna);
	}

	@Override
	public Qna view(Qna qna) {

		return qnaDao.selectQnaByQnaNo(qna);
	}

	

}
