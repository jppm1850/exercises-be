package com.junior.pecho.exercise.service;

import java.io.IOException;
import java.net.MalformedURLException;

import com.junior.pecho.exercise.enumeration.PatternEnum;

public interface LookPatternService {
	
	public void findPattern(String pathUrl,PatternEnum patternEnum) throws MalformedURLException, IOException;

}
