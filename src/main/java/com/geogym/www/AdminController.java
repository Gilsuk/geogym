package com.geogym.www;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.attachment.service.AttachmentService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.trainer.service.TrainerService;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class AdminController {

	@Autowired
	TrainerService trainerService;
	
	@Autowired UserService userService;
	@Autowired AttachmentService attachmentService;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	// 트레이너 리스트 받아오기
		@RequestMapping(value = "/admin/main", method = RequestMethod.GET)
		private String TrainerList(Model model) {
			logger.info("/admin/main");
			try {			
				if (userService.isTrainer(userService.getLoggedInUser())) {
					Trainer trainer = new Trainer();
					User user = userService.getLoggedInUser();
					trainer.setUser_no(user.getUser_no());
					Trainer trainer2 = trainerService.getTrainertoUser(trainer);
					model.addAttribute("trainer", trainer2);
					model.addAttribute("user", user);
					return null;
				}else {
					return "redirect:/";
				}
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				return "redirect:/";
			}

		}

}
