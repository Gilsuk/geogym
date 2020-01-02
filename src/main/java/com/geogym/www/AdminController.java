package com.geogym.www;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.attachment.service.AttachmentService;
import com.geogym.trainer.service.TrainerService;
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
		private void TrainerList(Model model) {
			logger.info("/admin/main");

			

		}

}
