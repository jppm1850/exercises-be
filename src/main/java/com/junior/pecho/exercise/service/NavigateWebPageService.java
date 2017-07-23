package com.junior.pecho.exercise.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.junior.pecho.exercise.dto.LookRequest;

public interface NavigateWebPageService {
	
	 public void lookPattern(LookRequest lookRequest) throws FileNotFoundException, IOException, InterruptedException;
	

}
