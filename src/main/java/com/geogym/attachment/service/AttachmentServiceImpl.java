
package com.geogym.attachment.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import com.geogym.attachment.dao.AttachmentDao;
import com.geogym.attachment.dto.Attachment;
import com.geogym.attachment.dto.Bodyinfo_attachment;
import com.geogym.attachment.dto.Qna_answer_attachment;
import com.geogym.attachment.dto.Qna_attachment;
import com.geogym.body.dto.BodyInfo;
import com.geogym.common.enumeration.Table;
import com.geogym.common.service.SequenceService;
import com.geogym.memo.dto.TrainingMemo;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;
import com.geogym.trainer.dto.Trainer;

@Service
public class AttachmentServiceImpl implements AttachmentService, ServletContextAware {

	private static final Logger logger = LoggerFactory.getLogger(AttachmentServiceImpl.class);

	ServletContext context;
	@Autowired
	HttpServletRequest req;
	@Autowired
	SequenceService seqService;
	@Autowired
	AttachmentDao attachmentDao;

	/**
	 * 파일을 업로드 한다.
	 * 
	 * 
	 * @param multipartFile - multipartFile 타입의 파일을 업로드하고 attachment 형식으로 DB에 저장한다
	 *                      attachment_no는 시퀀스를 통해 얻어온다
	 * @return - 저장한 attachment 를 리턴한다
	 */
	@Override
	public Attachment upload(MultipartFile file) {
		// TODO Auto-generated method stub
		Attachment attachment = new Attachment();

		logger.info("context " + context);
		logger.info("context.getRealPath(\"upload\") : " + context.getRealPath("upload"));

//		파일이 저장될 경로
		String storedPath = context.getRealPath("upload");

		// 랜덤 UID 생성
		UUID uuid = UUID.randomUUID();

		// 12자리 uid 얻기
		String u = uuid.toString().split("-")[4];

		// 저장될 파일 이름
		String filname = u + "_" + file.getOriginalFilename();

		// 저장될 파일 객체
		File dest = new File(storedPath, filname);

		// DB 에 저장

		attachment.setAttachment_no(getNextAttachmentNo());
		attachment.setAttachment_origin_name(file.getOriginalFilename());
		attachment.setAttachment_stored_name(filname);
		attachment.setAttachment_size(file.getSize());

		if (filname.substring(filname.indexOf(".") + 1).equals("zip")) {
			attachment.setMime_no(1);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("mpeg")) {
			attachment.setMime_no(2);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("x-wav")) {
			attachment.setMime_no(3);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("gif")) {
			attachment.setMime_no(4);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("jpeg")) {
			attachment.setMime_no(5);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("png")) {
			System.out.println(attachment);
			attachment.setMime_no(6);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("mpg")) {
			attachment.setMime_no(7);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("mp4")) {
			attachment.setMime_no(8);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("jpg")) {
			attachment.setMime_no(9);
			attachmentDao.upload(attachment);
		} else {
			logger.info("확장자 없음");
			return null;
		}

//		System.out.println(filname.substring(filname.indexOf(".")+1));

		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		logger.info("업로드성공");
//		logger.info(Integer.toString(attachment.getAttachment_no()));
//		System.out.println(attachment);

		return attachment;
	}

	/**
	 * 파일 다중 업로드
	 * 
	 * 그냥 사용해서는 안됨. 반드시 각각의 전용 업로드 서비스를 이용해야 한다.
	 * 
	 * @param files - 멀티파트파일 여러개
	 * @return List<Attachment> 를 리턴한다
	 */
	@Override
	public List<Attachment> upload2(MultipartFile[] files) {
		// TODO Auto-generated method stub

		System.out.println(2);

		List<Attachment> list = new ArrayList<>();

		logger.info("context " + context);
		logger.info("context.getRealPath(\"upload\") : " + context.getRealPath("upload"));

//		파일이 저장될 경로
		String storedPath = context.getRealPath("upload");

		// 랜덤 UID 생성
		UUID uuid = UUID.randomUUID();

		// 12자리 uid 얻기
		String u = uuid.toString().split("-")[4];

		System.out.println(3);

		for (MultipartFile file : files) {

			System.out.println(4);
			Attachment attachment = new Attachment();

			// 저장될 파일 이름
			String filname = u + "_" + file.getOriginalFilename();

			// 저장될 파일 객체
			File dest = new File(storedPath, filname);

			// DB 에 저장

			attachment.setAttachment_no(getNextAttachmentNo());
			attachment.setAttachment_origin_name(file.getOriginalFilename());
			attachment.setAttachment_stored_name(filname);
			attachment.setAttachment_size(file.getSize());

			if (filname.substring(filname.indexOf(".") + 1).equals("zip")) {
				attachment.setMime_no(1);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("mpeg")) {
				attachment.setMime_no(2);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("x-wav")) {
				attachment.setMime_no(3);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("gif")) {
				attachment.setMime_no(4);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("jpeg")) {
				attachment.setMime_no(5);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("png")) {
				System.out.println(attachment);
				attachment.setMime_no(6);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("mpg")) {
				attachment.setMime_no(7);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("mp4")) {
				attachment.setMime_no(8);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("jpg")) {
				attachment.setMime_no(9);
				attachmentDao.upload(attachment);
			} else {
				logger.info("확장자 없음");
				return null;
			}

//			System.out.println(filname.substring(filname.indexOf(".")+1));

			try {
				file.transferTo(dest);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			logger.info("업로드성공");
//			logger.info(Integer.toString(attachment.getAttachment_no()));
//			System.out.println(attachment);



			list.add(attachment);

		}

		return list;
	}

	@Override
	public int getNextAttachmentNo() {
		// TODO Auto-generated method stub
		return seqService.getNextVal(Table.ATTACHMENT);
	}

//	@Override
//	public List<Attachment> getAttachments(Qna qna) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Attachment> getAttachments(QnaAnswer qnaAnswer) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Attachment> getAttachments(BodyInfo bodyinfo) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	/**
	 * 트레이너의 프로필 사진을 반환
	 * 
	 * @param trainer trainer_no를 포함하는 객체
	 */
	@Override
	public Attachment getAttachment(Trainer trainer) {
		// TODO Auto-generated method stub

		return attachmentDao.getTrainer(trainer);
	}

	/**
	 * 트레이닝 메모의 첨부자료 조회
	 * 
	 * @param trainingMemo - training_memo_no를 포함하는 객체
	 * @return
	 */
	@Override
	public Attachment getAttachment(TrainingMemo trainingMemo) {
		// TODO Auto-generated method stub
		return attachmentDao.getTrainingMemo(trainingMemo);
	}

	/**
	 * 연결된 파일 모두 삭제 게시글이 삭제될 때 호출할 메소드 즉, qna 게시글이 삭제될 때 그 게시글이 포함하고 있던 모든
	 * attachment가 삭제되길 원함 Qna_no를 기준으로 조회
	 * 
	 * @param 게시글 번호가 포함된 qna dto
	 */
	@Override
	public void removeAllAttachments(Qna qna) {
		// TODO Auto-generated method stub
		List<Attachment> list = attachmentDao.getQna_attachment(qna);
		attachmentDao.removeQna_attachment(qna);
		
		for (int i = 0; i < list.size(); i++) {
			
			attachmentDao.removeAttachment(list.get(i));
		}
	}

	@Override
	public void removeAllAttachments(QnaAnswer qnaAnswer) {
		// TODO Auto-generated method stub
		List<Attachment> list = attachmentDao.getQnaAnswer_attachment(qnaAnswer);
		attachmentDao.removeQnaAnswer_attachment(qnaAnswer);
		
		for (int i = 0; i < list.size(); i++) {
			
			attachmentDao.removeAttachment(list.get(i));
		}

	}

	@Override
	public void removeAllAttachments(BodyInfo bodyinfo) {
		// TODO Auto-generated method stub
		List<Attachment> list = attachmentDao.getBodyInfo_attachment(bodyinfo);
		attachmentDao.removeBodyInfo_attachment(bodyinfo);
		
		for (int i = 0; i < list.size(); i++) {
			
			attachmentDao.removeAttachment(list.get(i));
		}

	}

//	@Override
//	public void removeAttachment(Qna qna, Attachment attachment) {
//		// TODO Auto-generated method stub
//		
//
//	}
//
//	@Override
//	public void removeAttachment(QnaAnswer qnaAnswer, Attachment attachment) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void removeAttachment(BodyInfo bodyinfo, Attachment attachment) {
//		// TODO Auto-generated method stub
//
//	}

	@Override
	public Attachment updateAttachment(Attachment attachment, MultipartFile file) {
		// TODO Auto-generated method stub
		

		logger.info("context " + context);
		logger.info("context.getRealPath(\"upload\") : " + context.getRealPath("upload"));

//		파일이 저장될 경로
		String storedPath = context.getRealPath("upload");

		// 랜덤 UID 생성
		UUID uuid = UUID.randomUUID();

		// 12자리 uid 얻기
		String u = uuid.toString().split("-")[4];

		// 저장될 파일 이름
		String filname = u + "_" + file.getOriginalFilename();

		// 저장될 파일 객체
		File dest = new File(storedPath, filname);

		// DB 에 저장

		attachment.setAttachment_origin_name(file.getOriginalFilename());
		attachment.setAttachment_stored_name(filname);
		attachment.setAttachment_size(file.getSize());

		if (filname.substring(filname.indexOf(".") + 1).equals("zip")) {
			attachment.setMime_no(1);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("mpeg")) {
			attachment.setMime_no(2);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("x-wav")) {
			attachment.setMime_no(3);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("gif")) {
			attachment.setMime_no(4);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("jpeg")) {
			attachment.setMime_no(5);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("png")) {
			System.out.println(attachment);
			attachment.setMime_no(6);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("mpg")) {
			attachment.setMime_no(7);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("mp4")) {
			attachment.setMime_no(8);
			attachmentDao.upload(attachment);
		} else if (filname.substring(filname.indexOf(".") + 1).equals("jpg")) {
			attachment.setMime_no(9);
			attachmentDao.upload(attachment);
		} else {
			logger.info("확장자 없음");
			return null;
		}

//		System.out.println(filname.substring(filname.indexOf(".")+1));

		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		logger.info("업로드성공");
//		logger.info(Integer.toString(attachment.getAttachment_no()));
//		System.out.println(attachment);

		return attachment;

	}

	/**
	 * 트레이너의 프로필 사진을 삭제 단, 해당컬럼은 NOT NULL 이므로 파일만 삭제하고, 컬럼에는 기본값 사진 주소로 업데이트 한다.
	 * 
	 * @param trainer trainer_no를 포함하는 객체
	 */
	@Override
	public void removeAttachment(Trainer trainer) {
		// TODO Auto-generated method stub
		attachmentDao.removeTrainer(trainer);
	}

	@Override
	public void removeAttachment(TrainingMemo trainingMemo) {
		// TODO Auto-generated method stub
		attachmentDao.removeTrainingMemo(trainingMemo);

	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;

	}

	/**
	 * 연결된 업로드 파일 조회 Qna_no를 기준으로 조회
	 * 
	 * @param 게시글 번호가 포함된 qna dto
	 * @return 업로드 파일 리스트 반환. 조회 결과가 없다면, 비어있는 리스트를 반환한다.
	 */
	@Override
	public List<Attachment> getAttachments(Qna qna) {
		// TODO Auto-generated method stub

		return attachmentDao.getQna_attachment(qna);
	}

	/**
	 * 연결된 업로드 파일 조회 QnaAnswer_no를 기준으로 조회
	 * 
	 * @param 게시글 번호가 포함된 qnaAnswer dto
	 * @return 업로드 파일 리스트 반환. 조회 결과가 없다면, 비어있는 리스트를 반환한다.
	 */
	@Override
	public List<Attachment> getAttachments(QnaAnswer qnaAnswer) {
		// TODO Auto-generated method stub
		return attachmentDao.getQnaAnswer_attachment(qnaAnswer);
	}

	/**
	 * 연결된 업로드 파일 조회 bodyinfo_no를 기준으로 조회
	 * 
	 * 
	 * @param 고유 번호가 포함된 BodyInfo dto
	 * @return 업로드 파일 리스트 반환. 조회 결과가 없다면, 비어있는 리스트를 반환한다.
	 */
	@Override
	public List<Attachment> getAttachments(BodyInfo bodyinfo) {
		// TODO Auto-generated method stub
		return attachmentDao.getBodyInfo_attachment(bodyinfo);
	}

	@Override
	public List<Attachment> fileUpload(MultipartFile[] files, Qna qna) {
		// TODO Auto-generated method stub
		System.out.println(2);

		List<Attachment> list = new ArrayList<>();

		logger.info("context " + context);
		logger.info("context.getRealPath(\"upload\") : " + context.getRealPath("upload"));

//		파일이 저장될 경로
		String storedPath = context.getRealPath("upload");

		// 랜덤 UID 생성
		UUID uuid = UUID.randomUUID();

		// 12자리 uid 얻기
		String u = uuid.toString().split("-")[4];

		System.out.println(3);

		for (MultipartFile file : files) {

			System.out.println(4);
			Attachment attachment = new Attachment();

			// 저장될 파일 이름
			String filname = u + "_" + file.getOriginalFilename();

			// 저장될 파일 객체
			File dest = new File(storedPath, filname);

			// DB 에 저장

			attachment.setAttachment_no(getNextAttachmentNo());
			attachment.setAttachment_origin_name(file.getOriginalFilename());
			attachment.setAttachment_stored_name(filname);
			attachment.setAttachment_size(file.getSize());

			if (filname.substring(filname.indexOf(".") + 1).equals("zip")) {
				attachment.setMime_no(1);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("mpeg")) {
				attachment.setMime_no(2);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("x-wav")) {
				attachment.setMime_no(3);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("gif")) {
				attachment.setMime_no(4);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("jpeg")) {
				attachment.setMime_no(5);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("png")) {
				System.out.println(attachment);
				attachment.setMime_no(6);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("mpg")) {
				attachment.setMime_no(7);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("mp4")) {
				attachment.setMime_no(8);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("jpg")) {
				attachment.setMime_no(9);
				attachmentDao.upload(attachment);
			} else {
				logger.info("확장자 없음");
				return null;
			}

//			System.out.println(filname.substring(filname.indexOf(".")+1));

			try {
				file.transferTo(dest);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			logger.info("업로드성공");
//			logger.info(Integer.toString(attachment.getAttachment_no()));
//			System.out.println(attachment);

			Qna_attachment qna_attachment = new Qna_attachment();
			qna_attachment.setQna_no(qna.getQna_no());
			qna_attachment.setAttachment_no(attachment.getAttachment_no());
			
			attachmentDao.setQna_attachment(qna_attachment);

			list.add(attachment);

		}

		return list;
	}

	@Override
	public List<Attachment> fileUpload(MultipartFile[] files, QnaAnswer qnaAnswer) {
		// TODO Auto-generated method stub
		System.out.println(2);

		List<Attachment> list = new ArrayList<>();

		logger.info("context " + context);
		logger.info("context.getRealPath(\"upload\") : " + context.getRealPath("upload"));

//		파일이 저장될 경로
		String storedPath = context.getRealPath("upload");

		// 랜덤 UID 생성
		UUID uuid = UUID.randomUUID();

		// 12자리 uid 얻기
		String u = uuid.toString().split("-")[4];

		System.out.println(3);

		for (MultipartFile file : files) {

			System.out.println(4);
			Attachment attachment = new Attachment();

			// 저장될 파일 이름
			String filname = u + "_" + file.getOriginalFilename();

			// 저장될 파일 객체
			File dest = new File(storedPath, filname);

			// DB 에 저장

			attachment.setAttachment_no(getNextAttachmentNo());
			attachment.setAttachment_origin_name(file.getOriginalFilename());
			attachment.setAttachment_stored_name(filname);
			attachment.setAttachment_size(file.getSize());

			if (filname.substring(filname.indexOf(".") + 1).equals("zip")) {
				attachment.setMime_no(1);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("mpeg")) {
				attachment.setMime_no(2);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("x-wav")) {
				attachment.setMime_no(3);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("gif")) {
				attachment.setMime_no(4);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("jpeg")) {
				attachment.setMime_no(5);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("png")) {
				System.out.println(attachment);
				attachment.setMime_no(6);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("mpg")) {
				attachment.setMime_no(7);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("mp4")) {
				attachment.setMime_no(8);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("jpg")) {
				attachment.setMime_no(9);
				attachmentDao.upload(attachment);
			} else {
				logger.info("확장자 없음");
				return null;
			}

//			System.out.println(filname.substring(filname.indexOf(".")+1));

			try {
				file.transferTo(dest);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			logger.info("업로드성공");
//			logger.info(Integer.toString(attachment.getAttachment_no()));
//			System.out.println(attachment);

			Qna_answer_attachment answer_attachment = new Qna_answer_attachment();
			answer_attachment.setQna_answer_no(qnaAnswer.getQna_answer_no());
			answer_attachment.setAttachment_no(attachment.getAttachment_no());
			
			
			attachmentDao.setQna_answer_attachment(answer_attachment);

			list.add(attachment);

		}

		return list;
	}

	@Override
	public List<Attachment> fileUpload(MultipartFile[] files, BodyInfo bodyInfo) {
		// TODO Auto-generated method stub
		System.out.println(2);

		List<Attachment> list = new ArrayList<>();

		logger.info("context " + context);
		logger.info("context.getRealPath(\"upload\") : " + context.getRealPath("upload"));

//		파일이 저장될 경로
		String storedPath = context.getRealPath("upload");

		// 랜덤 UID 생성
		UUID uuid = UUID.randomUUID();

		// 12자리 uid 얻기
		String u = uuid.toString().split("-")[4];

		System.out.println(3);

		for (MultipartFile file : files) {

			System.out.println(4);
			Attachment attachment = new Attachment();

			// 저장될 파일 이름
			String filname = u + "_" + file.getOriginalFilename();

			// 저장될 파일 객체
			File dest = new File(storedPath, filname);

			// DB 에 저장

			attachment.setAttachment_no(getNextAttachmentNo());
			attachment.setAttachment_origin_name(file.getOriginalFilename());
			attachment.setAttachment_stored_name(filname);
			attachment.setAttachment_size(file.getSize());

			if (filname.substring(filname.indexOf(".") + 1).equals("zip")) {
				attachment.setMime_no(1);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("mpeg")) {
				attachment.setMime_no(2);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("x-wav")) {
				attachment.setMime_no(3);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("gif")) {
				attachment.setMime_no(4);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("jpeg")) {
				attachment.setMime_no(5);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("png")) {
				System.out.println(attachment);
				attachment.setMime_no(6);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("mpg")) {
				attachment.setMime_no(7);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("mp4")) {
				attachment.setMime_no(8);
				attachmentDao.upload(attachment);
			} else if (filname.substring(filname.indexOf(".") + 1).equals("jpg")) {
				attachment.setMime_no(9);
				attachmentDao.upload(attachment);
			} else {
				logger.info("확장자 없음");
				return null;
			}

//			System.out.println(filname.substring(filname.indexOf(".")+1));

			try {
				file.transferTo(dest);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			logger.info("업로드성공");
//			logger.info(Integer.toString(attachment.getAttachment_no()));
//			System.out.println(attachment);

			Bodyinfo_attachment bodyinfo_attachment = new Bodyinfo_attachment();
			bodyinfo_attachment.setBodyinfo_no(bodyInfo.getBodyinfo_no());
			bodyinfo_attachment.setAttachment_no(attachment.getAttachment_no());
			
			attachmentDao.setBodyinfo_attachment(bodyinfo_attachment);

			list.add(attachment);

		}

		return list;
	}

}
