package com.geogym.www;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.body.dto.BodyInfo;
import com.geogym.body.service.face.BodyInfoService;
import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.user.dto.User;
import com.google.gson.Gson;

@Controller
public class BodyController {
	
	@Autowired BodyInfoService bodyInfoService;
	
	private static final Logger logger = LoggerFactory.getLogger(BodyController.class);

	@RequestMapping(value="/info/bodyinfo", method=RequestMethod.GET)
	public void bodyInfo(User user, Model model) {
		
//		logger.info("신체정보접근");
		
		//user_no 임의 설정
		User user1 = new User();
		user1.setUser_no(1);
		
		//최근 신체정보 불러오기
		BodyInfo bodyInfo = bodyInfoService.getRecentBodyInfo(user1);
		
//		logger.info(bodyInfo.toString());
		
		model.addAttribute("bodyInfo", bodyInfo);
		
		
		//1주일 단위로 불러오기
		List<BodyInfo> weightInfo = bodyInfoService.getBodyInfosByWeek(user1);
		//1개월 단위로 불러오기
		
		logger.info(weightInfo.toString());
		
		
		model.addAttribute("list", weightInfo);

		
	}
	
	@RequestMapping(value="/info/inputBodyInfo", method=RequestMethod.GET)
	public void inputBodyInfo() {
		
		logger.info("신체정보입력 접근");
		
	}
	
	@RequestMapping(value="/info/inputBodyInfo", method=RequestMethod.POST)
	public String inputBodyInfoProc(BodyInfo bodyinfo) {
		
		logger.info("신체정보입력 절차 접근");
//		logger.info(bodyinfo.toString());
		
		try {
			bodyInfoService.setBodyInfo(bodyinfo);
		} catch (ParamIncorrectException e) {
			e.printStackTrace();
		}
		
		return "redirect:/info/bodyinfo";
	}
}
