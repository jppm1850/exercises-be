package com.junior.pecho.exercise.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.junior.pecho.exercise.enumeration.PatternEnum;
import com.junior.pecho.exercise.service.LookPatternService;
import com.junior.pecho.exercise.util.FileUtil;
import com.junior.pecho.exercise.util.HttpUtil;
import com.junior.pecho.exercise.util.PatternUtil;


@Service
public class LookPatternServiceImpl implements LookPatternService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NavigateWebPageServiceImpl.class);
	
	@Value("${output.file}")
	private String pathFileOutput;
	
	public void findPattern(String pathUrl,PatternEnum patternEnum) throws MalformedURLException, IOException {
		
		BufferedReader buReader=HttpUtil.readHpp(pathUrl);
		List<String> patternsFound=PatternUtil.findPattern(buReader, patternEnum.getPattern());
		writeResult(pathUrl,patternsFound);
		
	}
	
	
	public void writeResult(String pathUrl,List<String> patternsFound) {
		FileUtil.writeFile(pathFileOutput+File.separator+FileUtil.cleanFileName(pathUrl)+".txt", patternsFound);
	}




}
