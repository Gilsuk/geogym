package com.geogym.www;

import java.time.LocalDate;
import java.util.HashMap;
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

import com.geogym.attachment.dto.Attachment;
import com.geogym.attachment.service.AttachmentService;
import com.geogym.body.dto.BodyComment;
import com.geogym.body.dto.BodyInfo;
import com.geogym.body.service.face.BodyInfoService;
import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.pt.service.MatchingService;
import com.geogym.schedule.service.ScheduleService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.trainer.exception.UserNotTrainerException;
import com.geogym.trainer.service.TrainerService;
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
	@Autowired TrainerService trainerService;
	
	private static final Logger logger = LoggerFactory.getLogger(BodyController.class);

	@RequestMapping(value="/info/bodyinfo", method=RequestMethod.GET)
	public String bodyInfo(
			@RequestParam(defaultValue = "week") String select,
			Model model) {
		
		User loggedInUser = null;
		try {
			loggedInUser = userService.getLoggedInUser();

		} catch (UserNotFoundException e1) {
			e1.printStackTrace();
			logger.info("와우 널포인트 익셉션 로그인이 안됨");
			
			return "redirect:/user/login";
		}
		
		boolean isTrainer = userService.isTrainer(loggedInUser);
		boolean isManager = userService.isManager(loggedInUser);
		List<Attachment> profile = bodyInfoService.getProfile(loggedInUser);

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
		
		HashMap<String,Object> list = new HashMap<>();
		list.put("user_no", loggedInUser.getUser_no());
		list.put("bodyinfo_date", LocalDate.now());
		
		int isbodyinfo = bodyInfoService.getCountBodyinfo(list);
		
//		logger.info(bodyComment.toString());
		model.addAttribute("profile", profile);
		model.addAttribute("bodyInfo", bodyInfo);
		model.addAttribute("bodycomment", bodyComment);
		model.addAttribute("isbodyinfo", isbodyinfo);
		model.addAttribute("isTrainer", isTrainer);
		model.addAttribute("isManager", isManager);
		
//		1주일 단위로 불러오기
		if(select.equals("week")) {
			List<BodyInfo> bodyInfoByWeek = bodyInfoService.getBodyInfosByWeek(loggedInUser);
			List<BodyInfo> weightInfoByWeek = bodyInfoService.getWeightByWeek(loggedInUser);
			List<BodyInfo> heightInfoByWeek = bodyInfoService.getHeightByWeek(loggedInUser);

//			logger.info(bodyInfoByWeek.toString());
			
			model.addAttribute("list",bodyInfoByWeek);
			model.addAttribute("weightInfo", weightInfoByWeek);
			model.addAttribute("heightInfo", heightInfoByWeek);
			return "/info/bodyinfo";
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
			return "/info/bodyinfo";
		}		
		return "/info/bodyinfo";
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
			Trainer trainer = trainerService.getTrainerByUserno(loggedInUser);
			logger.info(trainer.toString());
			model.addAttribute("trainer", trainer);
		} catch (UserNotTrainerException e1) {
			e1.printStackTrace();
		}
		
		try {
			User user = userService.getUserByUserno(loggedInUser);
			logger.info(user.toString());
			model.addAttribute("user", user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@RequestMapping(value="/info/inputBodyInfo", method=RequestMethod.POST)
	public String inputBodyInfoProc(BodyInfo bodyinfo, BodyComment commentary, Trainer trainer, User user) {
		
//		logger.info("신체정보입력 절차 접근");
		logger.info(user.toString());
		
		try {
			bodyInfoService.setBodyInfo(bodyinfo);
			bodyInfoService.setBodyCommentary(commentary, trainer, bodyinfo);
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
	public void uploadProfile(User user, Model model) {
		
		logger.info("파일 업로드 접근");
		
		model.addAttribute("user_no", user.getUser_no());
		
	}
	
	@RequestMapping(value="info/fileUploadProc", method=RequestMethod.POST)
	public String uploadProfile(User user, MultipartFile file) {
		
		user.setUser_no(user.getUser_no());
		
		MultipartFile[] files = new MultipartFile[1];
		files[0] = file;
		attachmentService.fileUpload(files, user);
		
		return "redirect:/info/bodyinfo";
	}
	
	@RequestMapping(value="/info/uploadinbody")
	public void uploadinbody(BodyInfo bodyinfo, Model model) {
		
		logger.info("inbody 사진 첨부 접근");

		model.addAttribute("bodyinfo_no", bodyinfo.getBodyinfo_no());
		
	}
	
	@RequestMapping(value="/info/uploadinbodyProc", method=RequestMethod.POST)
	public String uploadinbody(BodyInfo bodyinfoAttachment, MultipartFile file) {
		
		logger.info("인바디 사진 첨부 절차 접근");
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
		
		
		User loggedInUser = null;
		try {
			loggedInUser = userService.getLoggedInUser();

		} catch (UserNotFoundException e1) {
			e1.printStackTrace();
			logger.info("와우 널포인트 익셉션 로그인이 안됨");
		}
		
		boolean isTrainer = userService.isTrainer(loggedInUser);
		boolean isManager = userService.isManager(loggedInUser);
		List<Attachment> profile = bodyInfoService.getProfile(loggedInUser);
		
		
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
		
		model.addAttribute("profile", profile);
		model.addAttribute("bodyInfo", bodyInfo);
		model.addAttribute("bodycomment", bodyComment);
		model.addAttribute("isTrainer", isTrainer);
		model.addAttribute("isManager", isManager);
		
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
	
	@RequestMapping(value="/info/inbody", method=RequestMethod.GET)
	public void inbody(BodyInfo bodyinfo, Model model) {
		
		logger.info("inbody 정보 보기");
		logger.info(bodyinfo.toString());
		
		List<Attachment> inbody = attachmentService.getAttachments(bodyinfo);
		logger.info(inbody.toString());
		
		model.addAttribute("inbody", inbody);
		
	}
}
