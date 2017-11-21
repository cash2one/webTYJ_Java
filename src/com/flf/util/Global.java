package com.flf.util;

import java.util.HashMap;
import java.util.Map;

public class Global {
	
	public static Map<String, Object> sessionMap = new HashMap<String, Object>();

	public static Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public static void setSessionMap(Map<String, Object> sessionMap) {
		Global.sessionMap = sessionMap;
	}
}
