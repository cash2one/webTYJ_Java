package com.flf.util;
import java.util.ArrayList;
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.List;  
import java.util.Map;  
import java.util.Set;  

import net.sf.json.JSONArray;

import com.flf.util.Node;

/** 
 * 多叉树类 
*/  
@SuppressWarnings("all")
public class BinaryTree {  
 public static List<Node> BinaryTree(List<Map<String, String>> map){  
  // 读取层次数据结果集列表   
  List<Map<String,String>> dataList = map;    
    
  // 节点列表（散列表，用于临时存储节点对象）  
  HashMap<String,Node> nodeList = new HashMap<String,Node>();  
  // 根节点  
  List<Node> root = new ArrayList<Node>();  
  // 根据结果集构造节点列表（存入散列表）  
  List<Node> ListB =new ArrayList<Node>();
  for (Iterator<Map<String,String>>it = dataList.iterator(); it.hasNext();) {  
   Map<String,String> dataRecord = (Map<String,String>) it.next();  
   Node node = new Node();  
   node.setId((String) dataRecord.get("id"));
   node.setNodeName((String) dataRecord.get("nodeName"));
   node.setParentId((String) dataRecord.get("parentId"));
   node.setFullName((String) dataRecord.get("fullName"));
   node.setNames((String) dataRecord.get("names"));
   node.setCardTypes((String) dataRecord.get("cardTypes"));
   node.setCardNums((String) dataRecord.get("cardNums"));
   node.setBuildingType((String) dataRecord.get("buildingType"));
   node.setProjectId((String) dataRecord.get("projectId"));
   node.setBuildingCertificate((String) dataRecord.get("buildingCertificate")); 
   node.setIsParent((String) dataRecord.get("isParent")); 
   String s= dataRecord.get("buildingArea");
   node.setBuildingArea(s);
   nodeList.put(node.getId(), node);
  }  
  // 构造无序的多叉树  
  Set<Map.Entry<String,Node>> entrySet = nodeList.entrySet();  
  for (Iterator<Map.Entry<String,Node>> it = entrySet.iterator(); it.hasNext();) {  
   Node node1 = (Node) ((Map.Entry<String,Node>) it.next()).getValue();  
   if (node1.getParentId() == null || node1.getParentId().equals("")||node1.getParentId().equals(node1.getProjectId())) {  
    root.add(node1);  
   } else {  
	   if(nodeList.get(node1.getParentId())!=null){
		   nodeList.get(node1.getParentId()).getChildren().add(node1);
	   }  
   }  
  }  

  // 对多叉树进行横向排序  
//  root.sortChildren();  
//  // 输出有序的树形菜单的JSON字符串  
//  System.out.println(root.toString());   
    
  	
  	
  return root;
 }  
     
}  