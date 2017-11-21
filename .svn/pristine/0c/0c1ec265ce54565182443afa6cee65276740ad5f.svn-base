package com.flf.util;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.util.NodeIDComparator;
/** 
* 孩子列表类 
*/  
@XmlRootElement(name = "Children")
public class Children {
	 private List<Node> list = new ArrayList<Node>();  
	   
	 public int getSize() {  
	  return list.size();  
	 }  
	   
	 public void addChild(Node node) {  
	  list.add(node);  
	 }  
	   
	 // 拼接孩子节点的JSON字符串  
	 public String toString() {  
	  String result = "[";    
	  for (Iterator<Node> it = list.iterator(); it.hasNext();) {  
	   result += ((Node) it.next()).toString();  
	   result += ",";  
	  }  
	  result = result.substring(0, result.length() - 1);  
	  result += "]";  
	  return result;  
	 }  
	   
	 public void setList(List<Node> list) {
		this.list = list;
	}

	public List<Node> getList() {
		return list;
	}
/*
	// 孩子节点排序  
	 @SuppressWarnings("unchecked")
	public void sortChildren() {  
	  // 对本层节点进行排序  
	  // 可根据不同的排序属性，传入不同的比较器，这里传入ID比较器  
	  Collections.sort(list, new NodeIDComparator());  
	  // 对每个节点的下一层节点进行排序  
	  for (Iterator<Node> it = list.iterator(); it.hasNext();) {  
	   ((Node) it.next()).sortChildren();  
	  }  
	 }  */
}  
