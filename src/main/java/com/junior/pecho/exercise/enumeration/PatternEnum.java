package com.junior.pecho.exercise.enumeration;

public enum PatternEnum {
	
	HASH_TAG("HASH_TAG","(#\\w+)"),
	TWITER_ACCOUNT("TWITER","(http(s)?://(.*\\.)?twitter\\.com\\/[A-z 0-9 _]+\\/?)"),
	FACEBOOK_ACCOUNT("FACEBOOK","(https?:\\/\\/www.facebook.com\\/[\\w]+)");
	
	private String pattern;
	private String key;


	PatternEnum(String key,String pattern) {
		this.pattern = pattern;
		this.key=key;
	}
	

	public String getPattern() {
		return pattern;
	}


	public String getKey() {
		return key;
	}


	public static PatternEnum findByKey(String key) {
		 for(PatternEnum v : values()){
		        if( v.getKey().equals(key)){
		            return v;
		        }
		    }
		    return null;
	}
	


}
