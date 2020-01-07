package com.geogym.www;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.geogym.attachment.service.AttachmentService;
import com.geogym.body.dto.BodyComment;
import com.geogym.body.dto.BodyInfo;
import com.geogym.body.service.face.BodyInfoService;
import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.pt.dto.PT;
import com.geogym.pt.service.MatchingService;
import com.geogym.schedule.service.ScheduleService;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class BodyController {
	
	@Autowired BodyInfoService bodyInfoService;
	@Autowired UserService userService;
	@Autowired AttachmentService attachmentService;
	@Autowired MatchingService mathcingService;
	@Autowired ScheduleService scheduleService;
	
	private static final Logger logger = LoggerFactory.getLogger(BodyController.class);

	@RequestMapping(value="/info/bodyinfo", method=RequestMethod.GET)
	public void bodyInfo(
			@RequestParam(defaultValue = "week") String select,
			Model model) {
		
		User loggedInUser = null;
		try {
			loggedInUser = userService.getLoggedInUser();

		} catch (UserNotFoundException e1) {
			e1.printStackTrace();
			logger.info("와우 널포인트 익셉션 로그인이 안됨");
		}
		

		

		//userno 임의 지정 ( 추후 삭제 예정 )
//		User user1 = new User();
//		user1.setUser_no(1);
		
		//가장 최근에 입력한 신체정보 불러오기
		BodyInfo bodyInfo = bodyInfoService.getRecentBodyInfo(loggedInUser);
		
		//가장 최근에 입력한 특이사항 불러오기
		BodyComment bodyComment = bodyInfoService.getCommentary(loggedInUser);
		
		//user_no로 user_name 불러오기
		try {
			User user = userService.getUserByUserno(loggedInUser);
			model.addAttribute("user", user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
//		logger.info(bodyComment.toString());
		
		model.addAttribute("bodyInfo", bodyInfo);
		model.addAttribute("bodycomment", bodyComment);
		
//		1주일 단위로 불러오기
		if(select.equals("week")) {
			List<BodyInfo> bodyInfoByWeek = bodyInfoService.getBodyInfosByWeek(loggedInUser);
			List<BodyInfo> weightInfoByWeek = bodyInfoService.getWeightByWeek(loggedInUser);
			List<BodyInfo> heightInfoByWeek = bodyInfoService.getHeightByWeek(loggedInUser);

//			logger.info(bodyInfoByWeek.toString());
			
			model.addAttribute("list",bodyInfoByWeek);
			model.addAttribute("weightInfo", weightInfoByWeek);
			model.addAttribute("heightInfo", heightInfoByWeek);
			return;
		}
		
//		30일 단위로 불러오기
		if(select.equals("month")) {
			
			List<BodyInfo> bodyInfoByMonth = bodyInfoService.getBodyInfosByMonth(loggedInUser);
			List<BodyInfo> weightInfoByMonth = bodyInfoService.getWeightByMonth(loggedInUser);
			List<BodyInfo> heightInfoByMonth = bodyInfoService.getHeightByMonth(loggedInUser);
//			logger.info(bodyInfoByMonth.toString());
			
			model.addAttribute("list", bodyInfoByMonth);
			model.addAttribute("weightInfo", weightInfoByMonth);
			model.addAttribute("heightInfo", heightInfoByMonth);
			return;
		}		
		
	}
	
	@RequestMapping(value="/info/inputBodyInfo", method=RequestMethod.GET)
	public void inputBodyInfo(Model model) {
		
//		logger.info("신체정보입력 접근");
		
		User loggedInUser = null;
		try {
			loggedInUser = userService.getLoggedInUser();

		} catch (UserNotFoundException e1) {
			e1.printStackTrace();
			logger.info("와우 널포인트 익셉션 로그인이 안됨");
		}
		
		BodyComment bodyComment = bodyInfoService.getCommentary(loggedInUser);
		
		model.addAttribute("bodyComment", bodyComment);
		try {
			User user = userService.getUserByUserno(loggedInUser);
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
	
	@RequestMapping(value="/info/uploadProfile")
	public void uploadProfile() {
		
		logger.info("파일 업로드 접근");
		
	}
	
	@RequestMapping(value="info/fileUploadProc", method=RequestMethod.GET)
	public String uploadProfile(BodyInfo bodyinfo, MultipartFile[] files) {
		
		logger.info("파일 업로드 절차 접근");
		bodyinfo.getBodyinfo_no();
		logger.info(bodyinfo.toString());
		
		attachmentService.fileUpload(files, bodyinfo);
		
		return "redirect:/info/bodyinfo";
	}
	
	@RequestMapping(value="/info/uploadBMI")
	public void uploadBMI(BodyInfo bodyinfo, Model model) {
		
		logger.info("BMI 사진 첨부 접근");

		model.addAttribute("bodyinfo_no", bodyinfo.getBodyinfo_no());
		
	}
	
	@RequestMapping(value="/info/uploadBMIProc", method=RequestMethod.POST)
	public String uploadBMI(BodyInfo bodyinfoAttachment, MultipartFile file) {
		
		logger.info("BMI 사진 첨부 절차 접근");
		bodyinfoAttachment.setBodyinfo_no(bodyinfoAttachment.getBodyinfo_no());
		logger.info(bodyinfoAttachment.toString());
		
		MultipartFile[] files = new MultipartFile[1];
		files[0] = file;
		attachmentService.fileUpload(files, bodyinfoAttachment);
		
		return "redirect:/info/bodyinfo";
	}
	
	@RequestMapping(value="/info/bodyinfo_user", method=RequestMethod.GET)
	public void bodyinfo_user(
			@RequestParam(defaultValue = "week") String select,
			Model model) {
		
		logger.info("바디인포유저");
		
		User loggedInUser = null;
		try {
			loggedInUser = userService.getLoggedInUser();

		} catch (UserNotFoundException e1) {
			e1.printStackTrace();
			logger.info("와우 널포인트 익셉션 로그인이 안됨");
		}
		
		
		logger.info("스케쥴리스트당");
		List<PT> scheduleList = scheduleService.getPTScheduleByMonth(loggedInUser, LocalDate.now());
		logger.info(scheduleList.toString());

		//userno 임의 지정 ( 추후 삭제 예정 )
//		User user1 = new User();
//		user1.setUser_no(1);
		
		//가장 최근에 입력한 신체정보 불러오기
		BodyInfo bodyInfo = bodyInfoService.getRecentBodyInfo(loggedInUser);
		
		//가장 최근에 입력한 특이사항 불러오기
		BodyComment bodyComment = bodyInfoService.getCommentary(loggedInUser);
		
		//user_no로 user_name 불러오기
		try {
			User user = userService.getUserByUserno(loggedInUser);
			model.addAttribute("user", user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
//		logger.info(bodyComment.toString());
		
		model.addAttribute("bodyInfo", bodyInfo);
		model.addAttribute("bodycomment", bodyComment);
		
//		1주일 단위로 불러오기
		if(select.equals("week")) {
			List<BodyInfo> bodyInfoByWeek = bodyInfoService.getBodyInfosByWeek(loggedInUser);
			List<BodyInfo> weightInfoByWeek = bodyInfoService.getWeightByWeek(loggedInUser);
			List<BodyInfo> heightInfoByWeek = bodyInfoService.getHeightByWeek(loggedInUser);

//			logger.info(bodyInfoByWeek.toString());
			
			model.addAttribute("list",bodyInfoByWeek);
			model.addAttribute("weightInfo", weightInfoByWeek);
			model.addAttribute("heightInfo", heightInfoByWeek);
			return;
		}
		
//		30일 단위로 불러오기
		if(select.equals("month")) {
			
			List<BodyInfo> bodyInfoByMonth = bodyInfoService.getBodyInfosByMonth(loggedInUser);
			List<BodyInfo> weightInfoByMonth = bodyInfoService.getWeightByMonth(loggedInUser);
			List<BodyInfo> heightInfoByMonth = bodyInfoService.getHeightByMonth(loggedInUser);
//			logger.info(bodyInfoByMonth.toString());
			
			model.addAttribute("list", bodyInfoByMonth);
			model.addAttribute("weightInfo", weightInfoByMonth);
			model.addAttribute("heightInfo", heightInfoByMonth);
			return;
		}
		
	}
}
