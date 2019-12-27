package com.geogym.www.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.geogym.common.dto.Paging;
import com.geogym.qna.dto.Qna;
import com.geogym.qna.service.face.QnaService;

@Controller
public class QnaController {
	
	@Autowired private QnaService qnaService;
	
	//시퀀스를 사용하기 위해 미리 준비해놓는 서비스 객체 
//	@Autowired SequenceService sequenceService;
	
	@RequestMapping(value = "/qna/list")
	public void list(
			@RequestParam(defaultValue = "1", required = false) int p, Model model) {

		//페이징 계산,
		Paging paging = qnaService.getPaging(p);
		model.addAttribute("paging", paging);

		//게시글 목록
		List<Qna> list = qnaService.getListAll(paging);
		model.addAttribute("list", list);
		
		
		
		//시퀀스 넥스트벨 가져오기 
//		int no = sequenceService.getNextVal(Table.QNA);
	}
	
	//질문글 작성(유저) 
	@RequestMapping(value="/qna/write", method=RequestMethod.GET)
	public void write() { }
	
	//질문글 작성(트레이너) 
	@RequestMapping(value="/qna/writeAnswer", method=RequestMethod.GET)
	public void writeAnswer() { }

	
}
