package com.junior.pecho.exercise.controller;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junior.pecho.exercise.constants.Constant;
import com.junior.pecho.exercise.dto.LookRequest;
import com.junior.pecho.exercise.dto.LookResponse;
import com.junior.pecho.exercise.service.NavigateWebPageService;

@RestController
@RequestMapping("/looking")
public class LookingController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LookingController.class);
	
	 @Autowired
	 private NavigateWebPageService searchPrefixService;


	    @RequestMapping(method = RequestMethod.POST)
	    public LookResponse getUsers(@RequestBody LookRequest lookRequest) throws InterruptedException{
	    	LookResponse lookResponse=new LookResponse();
	    	
	        try {
	        	LOGGER.info("Initiating process of looking for patterns...");
				searchPrefixService.lookPattern(lookRequest);
				lookResponse.setResponse(Constant.SUCCESS);
				
			} catch (FileNotFoundException e) {
				lookResponse.setResponse(Constant.ERROR);
				e.printStackTrace();
			} catch (IOException e) {
				lookResponse.setResponse(Constant.ERROR);
				e.printStackTrace();
			};
	        
	        return lookResponse;
	    }
	

}
