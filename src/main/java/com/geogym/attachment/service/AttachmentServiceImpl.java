package com.geogym.attachment.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.geogym.attachment.dto.Attachment;
import com.geogym.body.dto.BodyInfo;
import com.geogym.memo.dto.TrainingMemo;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;
import com.geogym.trainer.dto.Trainer;

public class AttachmentServiceImpl implements AttachmentService {

	@Override
	public Attachment upload(MultipartFile multipartFile) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNextAttachmentNo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AttachmentService> getAttachments(Qna qna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttachmentService> getAttachments(QnaAnswer qnaAnswer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttachmentService> getAttachments(BodyInfo bodyinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttachmentService getAttachment(Trainer trainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttachmentService getAttachment(TrainingMemo trainingMemo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAllAttachments(Qna qna) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAllAttachments(QnaAnswer qnaAnswer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAllAttachments(BodyInfo bodyinfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAttachment(Qna qna, AttachmentService attachment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAttachment(QnaAnswer qnaAnswer, AttachmentService attachment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAttachment(BodyInfo bodyinfo, AttachmentService attachment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAttachment(Attachment attachment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAttachment(Trainer trainer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAttachment(TrainingMemo trainingMemo) {
		// TODO Auto-generated method stub
		
	}

}
