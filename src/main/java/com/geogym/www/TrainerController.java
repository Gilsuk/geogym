package com.geogym.www;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.geogym.trainer.dto.Trainer;
import com.geogym.attachment.service.AttachmentService;
import com.geogym.trainer.dto.T_reputation;
import com.geogym.trainer.service.TrainerService;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class TrainerController {

	@Autowired
	TrainerService trainerService;
	
	@Autowired UserService userService;
	@Autowired AttachmentService attachmentService;

	private static final Logger logger = LoggerFactory.getLogger(TrainerController.class);

	// 트레이너 리스트 받아오기
	@RequestMapping(value = "/trainer/list", method = RequestMethod.GET)
	private void TrainerList(Model model) {
		logger.info("TrainerList");

		List<Trainer> list = trainerService.viewTrainerList();
		System.out.println(list);

		model.addAttribute("list", list);

	}

	// 트레이너 정보 받아오기
	@RequestMapping(value = "/trainer/select", method = RequestMethod.GET)
	private void TrainerSelect(Model model, Trainer trainer) {
		logger.info("TrainerSelect");
		trainer.setTrainer_no(1);

		trainer = trainerService.getTrainer(trainer);
		System.out.println(trainer);

		model.addAttribute("trainer", trainer);

	}

	// 트레이너 생성
	@RequestMapping(value = "/trainer/insert", method = RequestMethod.GET)
	private String insertTrainer() {
		logger.info("insertTrainer");
		
		try {
			User loggedInUser = userService.getLoggedInUser();
			if (userService.isTrainer(loggedInUser)) {
				return "redirect:/";
			}else {
				return null;
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			return "redirect:/";
		}
//		return null;

	}

	// 트레이너 생성
	@RequestMapping(value = "/trainer/insert", method = RequestMethod.POST)
	private void insertTrainer(Trainer trainer, MultipartFile file) {
		logger.info("insertTrainer2");
		
		
//		trainer.setAttachment(attachmentService.upload(file));		
//		
//		System.out.println(trainer);
//		try {
//			User loggedInUser = userService.getLoggedInUser();			
//			trainer.setUser_no(loggedInUser.getUser_no());
//			
//			
//			trainerService.insertTrainer(trainer, multipartFile);
//		} catch (UserNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		trainerService.insertTrainer(trainer, file);



	}

	// 트레이너 테이블 수정
	@RequestMapping(value = "/trainer/update", method = RequestMethod.GET)
		private String updateTrainer() {
		
//		try {
//			User loggedInUser = userService.getLoggedInUser();
//			if (userService.isTrainer(loggedInUser)) {
				return null;
//			}else {
//				return "redirect:/user/main";
//			}
//		} catch (UserNotFoundException e) {
//			// TODO Auto-generated catch block
//			return "redirect:/user/main";
//		}
		
	}

	// 트레이너 테이블 수정
	@RequestMapping(value = "/trainer/update", method = RequestMethod.POST)
	private void updateTrainer(Trainer trainer, MultipartFile file) {
		logger.info("updateTrainer");

		// 이부분은 테스트용
//		Trainer trainer2 = new Trainer();
//		trainer2.setTrainer_no(2);
//		trainer2.setUser_no(2);
//		trainer2.setTrainer_address("addredd");
//		trainer2.setTrainer_price(1);
//		trainer2.setTrainer_profile("profile");

		trainerService.updateTrainer(trainer, file);

//		System.out.println(trainer2);
		logger.info("성공");

	}

	// 트레이너 정보 제거하기
	@RequestMapping(value = "/trainer/delete", method = RequestMethod.POST)
	private void TrainerDelete(Trainer trainer, MultipartFile file) {
		logger.info("Delete");

		// 테스트용, RequestMethod 를 GET 으로 바꿔야함
		trainer.setTrainer_no(1);

		trainerService.deleteTrainer(trainer, file);

	}

	// 트레이너 평점 조회
	@RequestMapping(value = "/trainer/reputation", method = RequestMethod.GET)
	private void TrainerReputation(Model model, Trainer trainer) {
		logger.info("reputation");

		// 테스트용 구문
//		trainer.setTrainer_no(1);
		
		// 차후 정식 버전에서는
		// 트레이너 넘버를 jsp 에서 받아와야 함

		double getAllReputation = trainerService.getAllReputation();
		double getReputation = trainerService.getReputation(trainer);
		
		model.addAttribute("average", getAllReputation);
		model.addAttribute("reputation", getReputation);
		
		System.out.println("average :" + getAllReputation);
		System.out.println("reputation :" + getReputation);
		

	}

	@RequestMapping(value = "/trainer/reputate", method = RequestMethod.GET)
	private void TrainerReputate() {
		
	}
	
	// 트레이너 평점 등록
	@RequestMapping(value = "/trainer/reputate", method = RequestMethod.POST)
	private void TrainerReputate(T_reputation reputation
//			, HttpSession session 
			) {

		logger.info("reputate");
		// 테스트용 구문
//		T_reputation reputation2 = new T_reputation();
//		reputation2.setTrainer_no(1);
//		reputation2.setUser_no(2);
//		reputation2.setTrainer_reputation_score(7);
//		reputation2.setTrainer_reputation_msg("ㅌㅅㅌ");
		
		// 차후 정식 버전에서는 
		// 유저 넘버 : 세션 이용
		// 트레이너넘버 : jsp 의 form 내부에 hidden 을 이용해서 얻어올 예정

		System.out.println(reputation);

		trainerService.reputate(reputation
//				, session
				);

	}

}
