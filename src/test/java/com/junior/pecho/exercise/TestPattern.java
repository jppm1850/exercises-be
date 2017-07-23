package com.junior.pecho.exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestPattern {
	
	
	@Test
	public void testPatternHashTag() {
		
		
		String str = "Array is the most #important thing in any programming #language";
		Pattern MY_PATTERN = Pattern.compile("(#\\w+)");
		Matcher mat = MY_PATTERN.matcher(str);
		while (mat.find()) {
		        System.out.println(mat.group(1));
		}
		
	}
	
	
	@Test
	public void testPatternUrl() {
		
		
		String str = "http://www.usatoday.com";
		Pattern MY_PATTERN = Pattern.compile("(//www. || http://www.)(\\w+)");
		Matcher mat = MY_PATTERN.matcher(str);
		while (mat.find()) {
		        System.out.println(mat.group(1));
		}
		
	}
	
	
	
	
	
	@Test
	public void testPatternTwitter() {
		
		String urlAddreess="<a class=\"circle\" target=\"_blank\" rel=\"noopener noreferrer\" href=\"http://twitter.com/zdnet\" data-omniture-track=\"moduleClick\" data-omniture-track-data=\"{&quot;moduleInfo&quot;: &quot;Footer-ConnectWithZDNet&quot;, &quot;pageType&quot;: &quot;front_door&quot;}\" itemprop=\"sameAs\">\r\n" + 
				"                               <svg class=\" twitter\"><use xmlns:xlink=\"http://www.w3.org/1999/xlink\" xlink:href=\"#twitter\"></use></svg></a>";
		
		Pattern p = Pattern.compile("(http(s)?://(.*\\.)?twitter\\.com\\/[A-z 0-9 _]+\\/?)");
		Matcher mat;
		mat=p.matcher(urlAddreess);
		while (mat.find()) {
	        System.out.println(mat.group(1));
		}
	}
	
	@Test
	public void testPatternFacebook() {
		
		String urlAddreess="<a href=\"https://www.facebook.com/ectnews\" target=\"_blank\"><img src=\"/images/2015/navicon-facebook_32x32.png\" width=\"32 height=\" 32\"=\"\" border=\"0\" alt=\"Facebook\"></a>";
		
		Pattern p = Pattern.compile("(https?:\\/\\/www.facebook.com\\/([\\w]+)?(\\/[\\w]+))");
		Matcher mat;
		mat=p.matcher(urlAddreess);
		while (mat.find()) {
	        System.out.println(mat.group(1));
		}
	}

}
