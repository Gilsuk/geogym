package com.geogym.www.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.geogym.attachment.dto.Attachment;
import com.geogym.attachment.service.AttachmentService;
import com.geogym.common.enumeration.Table;
import com.geogym.common.service.SequenceService;
import com.geogym.qna.dto.Paging;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;
import com.geogym.qna.service.face.QnaAnswerService;
import com.geogym.qna.service.face.QnaService;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class QnaController {

	@Autowired
	private QnaService qnaService;
	@Autowired
	private QnaAnswerService qnaAnswerService;
	@Autowired
	private AttachmentService fileService;
	@Autowired
	private UserService userService;

	// 시퀀스를 사용하기 위해 미리 준비해놓는 서비스 객체
	@Autowired
	SequenceService sequenceService;

	@RequestMapping(value = "/qna/list")
	public void list(Paging param, Model model) {

		// 페이징 계산,
		Paging paging = qnaService.getPaging(param);
		model.addAttribute("paging", paging);

		// 게시글 목록
		List<Qna> list = qnaService.getListAll(paging);
		model.addAttribute("list", list);

		// 시퀀스 넥스트벨 가져오기
//		int no = sequenceService.getNextVal(Table.QNA);
	}

	// 질문글 작성(유저)
	@RequestMapping(value = "/qna/write", method = RequestMethod.GET)
	public String write() {
		try {
			userService.getLoggedInUser();
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			return "redirect:/user/login";
		}
		return null;
	}

	@RequestMapping(value = "/qna/write", method = RequestMethod.POST)
	public String write(@RequestParam("file") MultipartFile[] files, Qna qna, boolean qna_isprivate) {
		qna.setQna_isprivate(qna_isprivate);

		User user = new User();
		// 작성자 추가하기 (추가할 부분)
		try {
			user = userService.getLoggedInUser();
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			return "redirect:/user/login";
		}
		

		// 시퀀스 넥스트벨 가져오기
		int no = sequenceService.getNextVal(Table.QNA);

		qna.setQna_no(no);
		qna.setUser(user);
		System.out.println("qna : " + qna);


		qnaService.write(qna);

		fileService.fileUpload(files, qna);

		return "redirect:/qna/view?qna_no=" + qna.getQna_no();
	}

	// 질문글 작성(트레이너)
	@RequestMapping(value = "/qna/writeAnswer", method = RequestMethod.GET)
	public String writeAnswer() {
		try {
			User user = userService.getLoggedInUser();
			if (userService.isTrainer(user)) {
				return null;

			}else {
				return "redirect:/";

			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			return "redirect:/user/login";
		}		
	}

	@RequestMapping(value = "/qna/view", method = RequestMethod.GET)
	public String view(Qna viewBoard, Model model, User user) {

		// 게시글 번호가 1보다 작으면 목록으로 보내기
		if (viewBoard.getQna_no() < 1) {
			return "redirect:/qna/list";
		}

		// 게시글 상세 정보 전달
		viewBoard = qnaService.view(viewBoard);

		List<Attachment> fileList = fileService.getAttachments(viewBoard);
		QnaAnswer answer = qnaAnswerService.viewAnswer(viewBoard);

		model.addAttribute("fileList", fileList);
		model.addAttribute("answerFileList", fileService.getAttachments(answer));
		model.addAttribute("view", viewBoard);
		model.addAttribute("answer", answer);

		return "/qna/view";
	}

	public void view() {

	}

	@RequestMapping(value = "/qna/update", method = RequestMethod.GET)
	public void update(Model model, Qna qna) {
		model.addAttribute("view", qnaService.view(qna));
	}

	@RequestMapping(value = "/qna/update", method = RequestMethod.POST)
	public String update(Qna qna) {
		qnaService.modify(qna);

//		fileService.updateAttachment(fileService.getAttachments(qna).get(0), file);

		return "redirect:/qna/view?qna_no=" + qna.getQna_no();
	}

	@RequestMapping(value = "/qna/delete", method = RequestMethod.GET)
	public void delete(Qna qna, HttpServletResponse response) {
		qnaService.delete(qna);

		PrintWriter out;
		try {
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			out.println("<script>alert('삭제되었습니다.'); location.href='/qna/list';</script>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/answer/write", method = RequestMethod.POST)
	public String answerWrite(QnaAnswer qnaAnswer, MultipartFile file) {
		qnaAnswer.setQna_answer_no(sequenceService.getNextVal(Table.QNA_ANSWER));

		qnaAnswerService.writeAnswer(qnaAnswer);
		
		MultipartFile[] files = new MultipartFile[1];
		files[0] = file;
		
		fileService.fileUpload(files, qnaAnswer);

		return "redirect:/qna/view?qna_no=" + qnaAnswer.getQna_no();
	}

	@RequestMapping(value = "/qna/file/download")
	public ModelAndView download(Qna qna, // 파일번호 파라미터
			ModelAndView mav) {

		// 파일번호에 해당하는 파일 정보 가져오기
		List<Attachment> file = fileService.getAttachments(qna);

		// 파일정보를 MODEL 값으로 지정하기
		mav.addObject("downFile", file);

		// viewName 지정하기
		mav.setViewName("down");

		return mav;
	}
	
	@RequestMapping(value = "/answer/file/download")
	public ModelAndView download(QnaAnswer qnaAnswer, // 파일번호 파라미터
			ModelAndView mav) {

		// 파일번호에 해당하는 파일 정보 가져오기
		List<Attachment> file = fileService.getAttachments(qnaAnswer);

		// 파일정보를 MODEL 값으로 지정하기
		mav.addObject("downFile", file);

		// viewName 지정하기
		mav.setViewName("down");

		return mav;
	}

}
