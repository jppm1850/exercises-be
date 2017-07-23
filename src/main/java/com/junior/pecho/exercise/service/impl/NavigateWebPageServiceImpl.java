package com.junior.pecho.exercise.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junior.pecho.exercise.component.SendUrlJob;
import com.junior.pecho.exercise.dto.LookRequest;
import com.junior.pecho.exercise.enumeration.PatternEnum;
import com.junior.pecho.exercise.service.NavigateWebPageService;
import com.junior.pecho.exercise.util.FileUtil;



@Service
public class NavigateWebPageServiceImpl implements NavigateWebPageService {
	
	 	private static final Logger LOGGER = LoggerFactory.getLogger(NavigateWebPageServiceImpl.class);
	    
	    @Autowired
	    private SendUrlJob sendUrlJob;
	    

	    public void lookPattern(LookRequest lookRequest) throws FileNotFoundException, IOException, InterruptedException {
	    	
	    	List<String> listUrl=FileUtil.readFile(lookRequest.getPathUrl());
	    	PatternEnum patternEnum=PatternEnum.findByKey(lookRequest.getPatternKey());
	    	
	    	LOGGER.info("They were found "+listUrl.size() +" urls");
	    	
	    	for(String url:listUrl) {
	    		sendUrlJob.evaluateUrl(url,patternEnum);
	    	}
	    	
	    }
	    


}
