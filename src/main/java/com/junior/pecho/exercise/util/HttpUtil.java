package com.junior.pecho.exercise.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public final class HttpUtil {
	
	public static BufferedReader readHpp(String pathUrl) throws MalformedURLException ,IOException {
		
		URL url =new URL(pathUrl);
		URLConnection conexion = url.openConnection();
        conexion.connect();
        
        InputStream inputStream = conexion.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		
		return bufferedReader;
		
		
	}

}
