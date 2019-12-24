package com.geogym.www;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.trainer.dto.Trainer;
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
	
	
	//트레이너 테이블 수정
	@RequestMapping(value = "/trainer/update", method = RequestMethod.POST)
	private void updateTrainer(Trainer trainer) {
		logger.info("updateTrainer");
		
		
		// 이부분은 테스트용
//		Trainer trainer2 = new Trainer();
//		trainer2.setTrainer_no(1);
//		trainer2.setUser_no(1);
//		trainer2.setTrainer_address("addredd");
//		trainer2.setTrainer_price(1);
//		trainer2.setTrainer_profile("profile");
//		trainer2.setAttachment_no(1);
		
		trainerService.updateTrainer(trainer);
		
		System.out.println(trainer);
		logger.info("성공");

	}
	
	//트레이너 정보 제거하기
	@RequestMapping(value = "/trainer/delete", method = RequestMethod.GET)
	private void TrainerDelete(Trainer trainer) {
		logger.info("Delete");
		
		trainerService.deleteTraner(trainer);

		
	}
	
	

}
