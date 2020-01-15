package com.geogym.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticController {

	@RequestMapping(value = "/page/participation", method = RequestMethod.GET)
	public void participation() {
		
	}
	
	@RequestMapping(value = "/page/conditions", method = RequestMethod.GET)
	public void conditions() {
		
	}
	
}
