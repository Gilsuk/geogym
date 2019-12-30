package com.geogym.www.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.common.enumeration.Table;
import com.geogym.common.service.SequenceService;
import com.geogym.qna.dto.Paging;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.dto.QnaAnswer;
import com.geogym.qna.service.face.QnaAnswerService;
import com.geogym.qna.service.face.QnaService;
import com.geogym.user.dto.User;

@Controller
public class QnaController {

	@Autowired
	private QnaService qnaService;
	@Autowired
	private QnaAnswerService qnaAnswerService;
	

	// 시퀀스를 사용하기 위해 미리 준비해놓는 서비스 객체
	@Autowired SequenceService sequenceService;

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
	public void write() {
	}
	@RequestMapping(value = "/qna/write", method = RequestMethod.POST)
	public String write(Qna qna, boolean qna_isprivate) {
		qna.setQna_isprivate(qna_isprivate);
		
		// 작성자 추가하기 (추가할 부분)
		
		// 시퀀스 넥스트벨 가져오기
		int no = sequenceService.getNextVal(Table.QNA);
		
		qna.setQna_no(no);
		
		qnaService.write(qna);
		
		return "redirect:/qna/view?qna_no=" + qna.getQna_no();
	}

	// 질문글 작성(트레이너)
	@RequestMapping(value = "/qna/writeAnswer", method = RequestMethod.GET)
	public void writeAnswer() {
	}

	@RequestMapping(value = "/qna/view", method = RequestMethod.GET)
	public String view(Qna viewBoard, Model model, User user) {

		// 게시글 번호가 1보다 작으면 목록으로 보내기
		if (viewBoard.getQna_no() < 1) {
			return "redirect:/qna/list";
		}

		// 게시글 상세 정보 전달
		viewBoard = qnaService.view(viewBoard);
		model.addAttribute("view", viewBoard);
		model.addAttribute("answer", qnaAnswerService.viewAnswer(viewBoard));

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

		return "redirect:/qna/view?qna_no=" + qna.getQna_no();
	}
	
	@RequestMapping(value = "/qna/delete", method = RequestMethod.GET)
	public String delete(Qna qna) {
		qnaService.delete(qna);
		return "redirect:/qna/list";
	}
	
	@RequestMapping(value = "/answer/write", method = RequestMethod.POST)
	public String answerWrite(QnaAnswer qnaAnswer) {
		qnaAnswer.setQna_answer_no(sequenceService.getNextVal(Table.QNA_ANSWER));
		
		qnaAnswerService.writeAnswer(qnaAnswer);
		
		return "redirect:/qna/view?qna_no=" + qnaAnswer.getQna_no();
	}

}
