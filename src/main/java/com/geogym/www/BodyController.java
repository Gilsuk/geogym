package com.geogym.www;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.geogym.body.dto.BodyComment;
import com.geogym.body.dto.BodyInfo;
import com.geogym.body.service.face.BodyInfoService;
import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class BodyController {
	
	@Autowired BodyInfoService bodyInfoService;
	@Autowired UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(BodyController.class);

	@RequestMapping(value="/info/bodyinfo", method=RequestMethod.GET)
	public void bodyInfo(
			@RequestParam(defaultValue = "week") String select,
			Model model) {
		
		//userno 임의 지정 ( 추후 삭제 예정 )
		User user1 = new User();
		user1.setUser_no(1);
		
		//가장 최근에 입력한 신체정보 불러오기
		BodyInfo bodyInfo = bodyInfoService.getRecentBodyInfo(user1);
		
		//가장 최근에 입력한 특이사항 불러오기
		BodyComment bodyComment = bodyInfoService.getCommentary(user1);
		
		//user_no로 user_name 불러오기
		try {
			User user = userService.getUserByUserno(user1);
			model.addAttribute("user", user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
//		logger.info(bodyComment.toString());
		
		model.addAttribute("bodyInfo", bodyInfo);
		model.addAttribute("bodycomment", bodyComment);
		
//		1주일 단위로 불러오기
		if(select.equals("week")) {
			List<BodyInfo> bodyInfoByWeek = bodyInfoService.getBodyInfosByWeek(user1);
//			logger.info(bodyInfoByWeek.toString());
			
			model.addAttribute("list",bodyInfoByWeek);
			return;
		}
		
//		30일 단위로 불러오기
		if(select.equals("month")) {
			
			List<BodyInfo> bodyInfoByMonth = bodyInfoService.getBodyInfosByMonth(user1);
//			logger.info(bodyInfoByMonth.toString());
			
			model.addAttribute("list", bodyInfoByMonth);
			return;
		}		
		
	}
	
	@RequestMapping(value="/info/inputBodyInfo", method=RequestMethod.GET)
	public void inputBodyInfo(Model model) {
		
//		logger.info("신체정보입력 접근");
		
		//userno 임의 지정 ( 추후 삭제 예정 )
		User user1 = new User();
		user1.setUser_no(1);
		
		BodyComment bodyComment = bodyInfoService.getCommentary(user1);
		
		model.addAttribute("bodyComment", bodyComment);
		try {
			User user = userService.getUserByUserno(user1);
			logger.info(user.toString());
			model.addAttribute("user", user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/info/inputBodyInfo", method=RequestMethod.POST)
	public String inputBodyInfoProc(BodyInfo bodyinfo, BodyComment commentary) {
		
//		logger.info("신체정보입력 절차 접근");
		

		
		try {
			bodyInfoService.setBodyInfo(bodyinfo);
			bodyInfoService.setBodyCommentary(commentary);
		} catch (ParamIncorrectException e) {
			e.printStackTrace();
		}
		
		return "redirect:/info/bodyinfo";
	}
	
	@RequestMapping(value="/info/delete")
	public String deleteInfo(BodyInfo bodyInfo) {
		
		logger.info("데이터삭제접근");
		logger.info(bodyInfo.toString());
		
		bodyInfoService.deleteBodyInfo(bodyInfo);
		bodyInfoService.deleteBodyCommentary(bodyInfo);
		
		return "redirect:/info/bodyinfo";
	}
	
}
