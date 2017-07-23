package com.junior.pecho.exercise.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PatternUtil {
	
	public static List<String> findPattern(BufferedReader bufferedReader,String pattern) throws IOException {
		
		String line = "";
		Pattern MY_PATTERN = Pattern.compile(pattern);
		List<String> listPatternFound=new ArrayList<String>();
		
		while((line = bufferedReader.readLine())!=null){
			Matcher mat = MY_PATTERN.matcher(line);
			while (mat.find()) {
				listPatternFound.add(mat.group(1));
			}
		}
		
		return listPatternFound;

	}
	
	public static void patternFileName() {
		
		
		
	}

}
