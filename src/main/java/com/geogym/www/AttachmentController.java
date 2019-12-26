package com.geogym.www;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.geogym.attachment.service.AttachmentService;

@Controller
public class AttachmentController {
	
	@Autowired AttachmentService attachmentService;
	
	private static final Logger logger = LoggerFactory.getLogger(AttachmentController.class);
	
	@RequestMapping(value = "/attachment/upload", method = RequestMethod.GET)
	private void upload() {
		logger.info("upload");
		// 테스트용 컨트롤러
		
	}
	@RequestMapping(value = "/attachment/upload", method = RequestMethod.POST)
	private void upload(
			@RequestParam(value ="file") MultipartFile multipartFile
			) {
		logger.info("upload-post");
		
		logger.info("file : " + multipartFile);
		logger.info("file : " + multipartFile.getOriginalFilename());
//		logger.info("context : " + context.getRealPath("upload"));


		
		attachmentService.upload(multipartFile);
		
	}
	



}
