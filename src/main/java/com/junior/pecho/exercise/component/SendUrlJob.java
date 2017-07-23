package com.junior.pecho.exercise.component;

import java.io.IOException;
import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.junior.pecho.exercise.enumeration.PatternEnum;
import com.junior.pecho.exercise.service.LookPatternService;

@Component
public class SendUrlJob {
	
		private static final Logger LOGGER = LoggerFactory.getLogger(SendUrlJob.class);
		
		@Autowired
		private LookPatternService lookPatternService;
	
	 	@Async
	    public void evaluateUrl(String pathUrl,PatternEnum patternEnum)  {
	 		
	 		
	 		
	 		try {
	 			LOGGER.info("Looking url["+pathUrl+"]");
				lookPatternService.findPattern(pathUrl,patternEnum);
				LOGGER.info("Looking url["+pathUrl+"] completed");
			} catch (MalformedURLException e) {
				LOGGER.error("An error occurred while processing the following path url["+pathUrl+"] ");
				e.printStackTrace();
			} catch (IOException e) {
				LOGGER.error("An error occurred while processing the following path url["+pathUrl+"] ");
				e.printStackTrace();
			}
	 		
	 		
	 		

	    }

}
