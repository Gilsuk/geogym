package com.geogym.www;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.geogym.trainer.dto.Trainer;
import com.geogym.trainer.dto.T_reputation;
import com.geogym.trainer.service.TrainerService;


@Controller
public class TrainerController {
	
	@Autowired TrainerService trainerService;
	
	private static final Logger logger = LoggerFactory.getLogger(TrainerController.class);
	
	//트레이너 리스트 받아오기
	@RequestMapping(value = "/trainer/list", method = RequestMethod.GET)
	private void TrainerList(Model model) {
		logger.info("TrainerList");
		
		List<Trainer> tlist = trainerService.viewTrainerList();
		System.out.println(tlist);
		
		model.addAttribute("tlist", tlist);
		
	}
	
	//트레이너 정보 받아오기
	@RequestMapping(value = "/trainer/select", method = RequestMethod.GET)
	private void TrainerSelect(Model model, Trainer trainer) {
		logger.info("TrainerSelect");
		trainer.setTrainer_no(1);
		
		trainer = trainerService.getTrainer(trainer);
		System.out.println(trainer);
		
		model.addAttribute("trainer", trainer);
		
	}
	
	//트레이너 생성
	@RequestMapping(value = "/trainer/insert", method = RequestMethod.GET)
	private void insertTrainer(Trainer trainer, MultipartFile multipartFile) {
		logger.info("insertTrainer");
		
		trainerService.insertTrainer(trainer, multipartFile);

	}
	
	
	//트레이너 테이블 수정
	@RequestMapping(value = "/trainer/update", method = RequestMethod.GET)
	private void updateTrainer(Trainer trainer, MultipartFile file) {
		logger.info("updateTrainer");
		
		
		// 이부분은 테스트용
		Trainer trainer2 = new Trainer();
		trainer2.setTrainer_no(1);
		trainer2.setUser_no(1);
		trainer2.setTrainer_address("addredd");
		trainer2.setTrainer_price(1);
		trainer2.setTrainer_profile("profile");
		
		
		trainerService.updateTrainer(trainer2);
		
		System.out.println(trainer2);
		logger.info("성공");

	}
	
	//트레이너 정보 제거하기
	@RequestMapping(value = "/trainer/delete", method = RequestMethod.POST)
	private void TrainerDelete(Trainer trainer, MultipartFile file) {
		logger.info("Delete");
		
		trainerService.deleteTraner(trainer, file);

		
	}
	// 트레이너 평점 조회
	@RequestMapping(value = "/trainer/reputation", method = RequestMethod.GET)
	private void TrainerReputation(Model model, Trainer trainer) {
		logger.info("reputation");
		
		// 테스트용 구문
		trainer.setTrainer_no(1);
		
		model.addAttribute("reputation", trainerService.getReputation(trainer));

		
	}
	
	// 트레이너 평점 등록
	@RequestMapping(value = "/trainer/reputate", method = RequestMethod.GET)
	private void TrainerReputate(T_reputation reputation) {
		
		logger.info("reputate");
		// 테스트용 구문
		T_reputation reputation2 = new T_reputation();
		reputation2.setTrainer_no(1);
		reputation2.setUser_no(2);
		reputation2.setTrainer_reputation_score(7);
		reputation2.setTrainer_reputation_msg("ㅌㅅㅌ");
		
		System.out.println(reputation2);

		
		trainerService.reputate(reputation2);
			
	}
	
	

}
