
package com.geogym.attachment.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.geogym.attachment.dao.AttachmentDao;
import com.geogym.attachment.dto.Attachment;
import com.geogym.body.dto.BodyInfo;
import com.geogym.common.enumeration.Table;
import com.geogym.common.service.SequenceService;
import com.geogym.memo.dto.TrainingMemo;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;
import com.geogym.trainer.dto.Trainer;


@Service
public class AttachmentServiceImpl implements AttachmentService {
	
	private static final Logger logger = LoggerFactory.getLogger(AttachmentServiceImpl.class);

	@Autowired ServletContext context;
	@Autowired SequenceService seqService;
	@Autowired AttachmentDao attachmentDao;



	@Override
	public Attachment upload(MultipartFile file) {
		// TODO Auto-generated method stub
		Attachment attachment = new Attachment();
		
		logger.info(context.getRealPath("upload"));
		
//		파일이 저장될 경로
		String storedPath = context.getRealPath("upload");
		
		// 랜덤 UID 생성
		UUID uuid = UUID.randomUUID(); 

		// 12자리 uid 얻기
		String u = uuid.toString().split("-")[4];
		
		// 저장될 파일 이름 
		String filname = u+"_"+file.getOriginalFilename();
		
		// 저장될 파일 객체
		File dest = new File(storedPath, filname);
		
		
		// DB 에 저장
		
		attachment.setAttachment_no(seqService.getNextVal(Table.ATTACHMENT));
		attachment.setAttachment_origin_name(file.getOriginalFilename());
		attachment.setAttachment_stored_name(filname);
		attachment.setAttachment_size(file.getSize());

		

		if (filname.substring(filname.indexOf(".")+1).equals("zip")) {
			attachment.setMime_no(1);
			attachmentDao.upload(attachment);
		}else if (filname.substring(filname.indexOf(".")+1).equals("mpeg")) {
			attachment.setMime_no(2);		
			attachmentDao.upload(attachment);
		}else if (filname.substring(filname.indexOf(".")+1).equals("x-wav")) {
			attachment.setMime_no(3);		
			attachmentDao.upload(attachment);
		}else if (filname.substring(filname.indexOf(".")+1).equals("gif")) {
			attachment.setMime_no(4);		
			attachmentDao.upload(attachment);
		}else if (filname.substring(filname.indexOf(".")+1).equals("jpeg")) {
			attachment.setMime_no(5);		
			attachmentDao.upload(attachment);
		}else if (filname.substring(filname.indexOf(".")+1).equals("png")) {
			System.out.println(attachment);
			attachment.setMime_no(6);
			attachmentDao.upload(attachment);
		}else if (filname.substring(filname.indexOf(".")+1).equals("mpg")) {
			attachment.setMime_no(7);		
			attachmentDao.upload(attachment);
		}else if (filname.substring(filname.indexOf(".")+1).equals("mp4")) {
			attachment.setMime_no(8);		
			attachmentDao.upload(attachment);
		}else {
			logger.info("확장자 없음");
			return null;
		}
		
		System.out.println(filname.substring(filname.indexOf(".")+1));
		
		
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("업로드성공");
		logger.info(Integer.toString(attachment.getAttachment_no()));
		System.out.println(attachment);

		return attachment;
	}

	@Override
	public int getNextAttachmentNo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Attachment> getAttachments(Qna qna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attachment> getAttachments(QnaAnswer qnaAnswer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attachment> getAttachments(BodyInfo bodyinfo) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Attachment getAttachment(Trainer trainer) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public Attachment getAttachment(TrainingMemo trainingMemo) {
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
	public void removeAttachment(Qna qna, Attachment attachment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAttachment(QnaAnswer qnaAnswer, Attachment attachment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAttachment(BodyInfo bodyinfo, Attachment attachment) {
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