package com.junior.pecho.exercise.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class  FileUtil {
	
	
	public static List<String> readFile(String pathFile) throws FileNotFoundException, IOException {
		
		List<String> listUrl=new ArrayList<String>();
		
		String url;
        FileReader f = new FileReader(pathFile);
        BufferedReader b = new BufferedReader(f);
        
        while((url = b.readLine())!=null) {
        	listUrl.add(url);
        }
        
        b.close();
		
		return listUrl; 
	}
	
	
	public static void writeFile(String pathFile,List<String> listContent) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathFile))) {
			
			StringBuffer strContent=new StringBuffer();
			
			for(String contents:listContent) {
				strContent.append(contents+"\n");
			}

			bw.write(strContent.toString());


		} catch (IOException e) {

			e.printStackTrace();

		}
		
	}
	
	public static String cleanFileName(String fileName) {
		
		return fileName.replace("http", "")
				.replace("https", "")
				.replace("://", "")
				.replace("www", "")
				.replace(".com", "")
				.replace(".", "")
				.replace("/", "");
		
	}

}
