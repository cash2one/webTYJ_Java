package com.flf.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.flf.request.Info;



/**
 * json工具类
 * @author huanghuanlai
 *
 */
public class JsonUtil {
	
	private static class JsonHolder{
		private static ObjectMapper mapper = new ObjectMapper();
	}

	/**
	 * 返回成功执行的操作json
	 * @param info
	 * @return
	 */
	public static String success(Object info,boolean addStr){
		if(addStr){
			Info lo=new Info();
			lo.setInfo(info);
			lo.setState("success");	
			return toJson(lo);
		}else{
			
			Info lo=new Info();
			lo.setInfo(info);
			lo.setState("success");
			return toJson(lo);
		}
	}

	/**
	 * 返回成功执行的操作json
	 * @param info
	 * @return
	 */
//	public static String infologo(String issucc,String info,String userid){
//		Login lo=new Login();
//		lo.setInfo(info);
//		lo.setState(issucc);
//		lo.setUserid(userid);
//		net.sf.json.JSONArray jsonarray = net.sf.json.JSONArray.fromObject(lo); 
//		return jsonarray.toString();
//		
//			//return "[{\"state\":"+issucc+",\"uesrid\":"+userid+",\"info\":"+info.trim()+"}]";
//		
//	}
//	
	/**
	 * 返回失败执行的操作json
	 * @param info
	 * @return
	 */
	public static String failure(String info,boolean addStr){
		if(addStr){
			Info lo=new Info();
			lo.setInfo(info);
			lo.setState("failure");
			return toJson(lo);
		}else{
			Info lo=new Info();
			lo.setInfo(info);
			lo.setState("failure");
			return toJson(lo);
		}
	}
	
	/**
	 * 将一个对象解析成Json数据格式
	 * @param object
	 * @return
	 */
	public static String toJson(Object object){
		try {
			return JSONObject.fromObject(object).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
		
	}
	
	/**
	 * 构建对象json数据
	 * @param values 数据集合
	 * @param excludes 忽略的列
	 * @return
	 */
	public static String buildList(Object total,Collection<?> list,String excludes){
		StringBuilder sb = new StringBuilder();
		//StringBuffer sb = new StringBuffer();
		sb.append("{\"total\":\""+total.toString()+"\",\"rows\":[");
		JsonConfig cfg = new JsonConfig();
		String[] excluds = null;
		if(excludes!=null&&!excludes.equals("")){
			excluds = excludes.split(",");
			if(excludes.length()>0){
				cfg.setExcludes(excluds);
			}
		}
		cfg.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		for(Object object : list){
			//声明json配置对象
			//设置循环策略为忽略、避免死循环
			JSONObject jsonObject = JSONObject.fromObject(object,cfg);
			sb.append(jsonObject.toString()+",");
		}
		if(list.size()>0){
			sb.deleteCharAt(sb.length()-1);
		}
		sb.append("]}");
		return sb.toString();
	}
	
	/** 
     * 从一个JSON 对象字符格式中得到一个java对象 
     *  
     * @param jsonString 
     * @param pojoCalss 
     * @return 
     */  
    public static Object getObject4JsonString(String jsonString, Class pojoCalss) {  
        Object pojo;  
        JSONObject jsonObject = JSONObject.fromObject(jsonString);  
        pojo = JSONObject.toBean(jsonObject, pojoCalss);  
        return pojo;  
    }  
  
    /** 
     * 从json HASH表达式中获取一个map，改map支持嵌套功能 
     *  
     * @param jsonString 
     * @return 
     */  
    public static Map getMap4Json(String jsonString) {  
        JSONObject jsonObject = JSONObject.fromObject(jsonString);  
        Iterator keyIter = jsonObject.keys();  
        String key;  
        Object value;  
        Map valueMap = new HashMap();  
  
        while (keyIter.hasNext()) {  
            key = (String) keyIter.next();  
            value = jsonObject.get(key).toString();  
            valueMap.put(key, value);  
        }  
  
        return valueMap;  
    }  
  
    /** 
     * 从json数组中得到相应java数组 
     *  
     * @param jsonString 
     * @return 
     */  
    public static Object[] getObjectArray4Json(String jsonString) {  
        JSONArray jsonArray = JSONArray.fromObject(jsonString);  
        return jsonArray.toArray();  
  
    }  
  
    /** 
     * 从json对象集合表达式中得到一个java对象列表 
     *  
     * @param jsonString 
     * @param pojoClass 
     * @return 
     */  
    public static List getList4Json(String jsonString, Class pojoClass) {  
  
        JSONArray jsonArray = JSONArray.fromObject(jsonString);  
        JSONObject jsonObject;  
        Object pojoValue;  
  
        List list = new ArrayList();  
        for (int i = 0; i < jsonArray.size(); i++) {  
  
            jsonObject = jsonArray.getJSONObject(i);  
            pojoValue = JSONObject.toBean(jsonObject, pojoClass);  
            list.add(pojoValue);  
  
        }  
        return list;  
  
    }  
  
    /** 
     * 从json数组中解析出java字符串数组 
     *  
     * @param jsonString 
     * @return 
     */  
    public static String[] getStringArray4Json(String jsonString) {  
  
        JSONArray jsonArray = JSONArray.fromObject(jsonString);  
        String[] stringArray = new String[jsonArray.size()];  
        for (int i = 0; i < jsonArray.size(); i++) {  
            stringArray[i] = jsonArray.getString(i);  
  
        }  
  
        return stringArray;  
    }  
  
    /** 
     * 从json数组中解析出javaLong型对象数组 
     *  
     * @param jsonString 
     * @return 
     */  
    public static Long[] getLongArray4Json(String jsonString) {  
  
        JSONArray jsonArray = JSONArray.fromObject(jsonString);  
        Long[] longArray = new Long[jsonArray.size()];  
        for (int i = 0; i < jsonArray.size(); i++) {  
            longArray[i] = jsonArray.getLong(i);  
  
        }  
        return longArray;  
    }  
  
    /** 
     * 从json数组中解析出java Integer型对象数组 
     *  
     * @param jsonString 
     * @return 
     */  
    public static Integer[] getIntegerArray4Json(String jsonString) {  
  
        JSONArray jsonArray = JSONArray.fromObject(jsonString);  
        Integer[] integerArray = new Integer[jsonArray.size()];  
        for (int i = 0; i < jsonArray.size(); i++) {  
            integerArray[i] = jsonArray.getInt(i);  
  
        }  
        return integerArray;  
    }  
  
  
    /** 
     * 从json数组中解析出java Integer型对象数组 
     *  
     * @param jsonString 
     * @return 
     */  
    public static Double[] getDoubleArray4Json(String jsonString) {  
  
        JSONArray jsonArray = JSONArray.fromObject(jsonString);  
        Double[] doubleArray = new Double[jsonArray.size()];  
        for (int i = 0; i < jsonArray.size(); i++) {  
            doubleArray[i] = jsonArray.getDouble(i);  
  
        }  
        return doubleArray;  
    }  
  
    /** 
     * 将java对象转换成json字符串 
     *  
     * @param javaObj 
     * @return 
     */  
    public static String getJsonString4JavaPOJO(Object javaObj) {  
  
        JSONObject json;  
        json = JSONObject.fromObject(javaObj);  
        return json.toString();  
  
    }  
    
    public static String result(Object info,String code,boolean state){
    	Info i = new Info();
    	if(state){
    		i.setCode(code);
    		i.setState("success");
    		i.setInfo(info);
    		return toJson(i);
    	}else{
    		i.setCode(code);
    		i.setState("failure");
    		i.setInfo(info);
    		return toJson(i);
    	}
    }
}
