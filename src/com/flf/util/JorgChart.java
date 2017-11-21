//package com.flf.util;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import net.sf.json.JSONArray;
//import sun.org.mozilla.javascript.internal.json.JsonParser;
//
//
//public class JorgChart extends HttpServlet{
//
//	private static final long serialVersionUID = -4581992467517640035L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		    request.setCharacterEncoding("UTF-8");  
//	        response.setContentType("text/html; charset=UTF-8");  
//	        PrintWriter out = response.getWriter();  
//		// ��ȡ�����ݽ���б�   
//		  @SuppressWarnings("unchecked")
//		List<Map<String,String>> dataList = VirtualDataGenerator.getVirtualResult();    
//		    
//		  // �ڵ��б?ɢ�б?������ʱ�洢�ڵ����  
//		  HashMap<String,Tree> nodeList = new HashMap<String,Tree>();  
//		  // ��ڵ�  
//		  Tree root = null;  
//		  // ��ݽ����ڵ��б?����ɢ�б?  
//		  for (Iterator<Map<String,String>>it = dataList.iterator(); it.hasNext();) {  
//		   Map<String,String> dataRecord = (Map<String,String>) it.next(); 
//		   Tree t = new Tree();
//		   t.setId((String) dataRecord.get("id"));
//		   t.setName((String) dataRecord.get("name"));
//		   t.setPid((String) dataRecord.get("parentId"));
//		   nodeList.put(t.getId(), t);
//		  }  
//		  // ��������Ķ����  
//		  Set<Map.Entry<String,Tree>> entrySet = nodeList.entrySet();  
//		  for (Iterator<Map.Entry<String,Tree>> it = entrySet.iterator(); it.hasNext();) {  
//			  Tree t1 = (Tree) ((Map.Entry<String,Tree>) it.next()).getValue();
//			  if(t1.getPid() == null || t1.getPid().equals("")){
//				  root = t1;
//			  }else{
//				  nodeList.get(t1.getPid()).gettList().add(t1);
//			  }
//		  }
//		  System.out.println(root); 
////		  JSONArray data =JSONArray.fromObject("["+root+"]");
////
////		  // �����������β˵���JSON�ַ�  
////		  System.out.println(data);  
//////		  out.print(root);
////		  out.print("{\"msg\":\""+data+"\"}");
////		  out.flush();
////		  out.close();
//	}
//}
