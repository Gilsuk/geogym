package com.geogym.www;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.geogym.attachment.dto.Attachment;
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
	
	@RequestMapping(value = "/attachment/upload2", method = RequestMethod.GET)
	private void upload2() {
		logger.info("upload");
		// 테스트용 컨트롤러
		
	}
	@RequestMapping(value = "/attachment/upload2", method = RequestMethod.POST)
	private void upload2(List<MultipartFile> files) {
		logger.info("upload-post");
		
		logger.info("file : " + files);


		List<Attachment> list = new ArrayList<>();
		list = attachmentService.upload2(files);
		
	}



}
