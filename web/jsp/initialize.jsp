<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="/Home/css/main.css"/>
<script type="text/javascript" src="/Home/js/lib/jquery/jquery-1.5.1.min.js"></script>
<title>排班初始化</title>
</head>
<body>
<form action="/Home/initialize/init.do" method="post">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head" id="division" name="not">
			<th>部门：</th>
			<td colspan="2">
				<select name="divisionId" onchange="onchangeDivision(this.value)">
						<option value="">请选择</option>
					<c:forEach var="d" items="${divisions}">
						<option value="${d.id}">${d.divisionName}</option>
					</c:forEach>
				</select> 
			</td>
			<td><input type="submit" value="初始化"/></td>
		</tr>
	</table>
</form>	
	<script type="text/javascript">
		$(document).ready(function(){
			console.log("dom加载完成!"); 
		});
		
		function onchangeDivision(id)
		{
			$('.main_table tr').not('tr[name=not]').remove();
			var index=0;
			var index2=0;
			var index3=0;
			$.get("/Home/initialize/getPostsByDivisionId.do",{divisionId:id},function(data){
				var json=eval(data);
				console.log(data);  
				$.each(json['posts'],function(key,values){  
				    $("#division").after("<tr class='main_head' name='postType'><th colspan='6'><a href='javascript:postTypeClick("+index+")'>"+key+"</a></th></tr><tr id='postType"+index+"' style='display: none;' name='post"+index+"'><td>岗位名称</td><td colspan='2'>岗位位置</td><td>岗位优先级</td><td colspan='3'>操作</td></tr>");
				    var index1=0;
				    for(var i=values.length-1;i>=0;i--)
				    {
				    	var post = "<tr style='display: none;' class='main_head'  id='post"+index1+"' name='post"+index+"'><td>"+values[i]['postName']+"<input type='hidden' name='posts["+index3+"].id' value='"+values[i]['id']+"'/></td><td colspan='2'>"+values[i]['position']+"</td>";
				    	if(parseInt(values[i]['postPriority'])==3)
				    	{
				    		post+="<td><select name='posts["+index3+"].postPriority'><option value='0'>请选择</option><option value='3' selected='selected'>高</option><option value='2' >中</option><option value='1' >低</option></select></td>";
				    	}else if(parseInt(values[i]['postPriority'])==2)
				    	{
				    		post+="<td><select name='posts["+index3+"].postPriority'><option value='0'>请选择</option><option value='3'>高</option><option value='2' selected='selected' >中</option><option value='1' >低</option></select></td>";
				    	}else if(parseInt(values[i]['postPriority'])==1)
				    	{
				    		post+="<td><select name='posts["+index3+"].postPriority'><option value='0'>请选择</option><option value='3'>高</option><option value='2'>中</option><option value='1'selected='selected'>低</option></select></td>";
				    	}else
				    	{
				    		post+="<td><select name='posts["+index3+"].postPriority'><option value='0' selected='selected'>请选择</option><option value='3'>高</option><option value='2'>中</option><option value='1' >低</option></select></td>";
				    	}
				    	post+="<td colspan='2'><a href='javascript:setClasses("+index+","+index1+")'>设置班次</a></td></tr><tr style='display: none;' id='classesType"+index+""+index1+"' class='main_head' name='classesType"+index+""+index1+"'><td>班次类型</td><td>班次名称</td><td>开始时间</td><td>结束时间</td><td>人数</td><td>是否可用</td></tr>";
				    	$("#postType"+index+"").after(post);  				    	
				    	if(values[i]['classes'].length>0)
				    	{
				    		for(var g=values[i]['classes'].length-1;g>=0;g--)
						    {
				    			 var classes="<tr style='display: none;' class='main_head' name='classesType"+index+""+index1+"'><td>"+values[i]['classes'][g]['classesTypeName']+"<input type='hidden' name='classes["+index2+"].id' value='"+values[i]['classes'][g]['id']+"'/><input type='hidden' name='classes["+index2+"].classesTypeId' value='"+values[i]['classes'][g]['classesTypeId']+"'/><input type='hidden' name='classes["+index2+"].classesTypeName' value='"+values[i]['classes'][g]['classesTypeName']+"'/><input type='hidden' name='classes["+index2+"].postId' value='"+values[i]['classes'][g]['postId']+"'/></td><td><input name='classes["+index2+"].classesName' type='text' value='"+values[i]['classes'][g]['classesName']+"'/></td><td><input name='classes["+index2+"].startTime' type='text' value='"+values[i]['classes'][g]['startTime']+"'/></td><td><input name='classes["+index2+"].endTime' type='text' value='"+values[i]['classes'][g]['endTime']+"'/></td><td><input name='classes["+index2+"].headcount' type='text' value='"+values[i]['classes'][g]['headcount']+"'/></td>";
				    			 if(parseInt(values[i]['classes'][g]['usable'])==1)
				    			 {
				    				 classes+="<td><input type='checkbox' checked='checked' name='classes["+index2+"].usable' value='1'/></td></tr>";
				    			 }else
				    			 {
				    				 classes+="<td><input type='checkbox'  name='classes["+index2+"].usable' value='1'/></td></tr>";
				    			 }
						    	 $("#classesType"+index+""+index1+"").after(classes);
						    	 index2++;
						    }
				    	}else
				    	{
				    		for(var j=json['classesTypes'].length-1;j>=0;j--)
						    {
				    			 var classes="<tr style='display: none;' class='main_head' name='classesType"+index+""+index1+"'><td>"+json['classesTypes'][j]['classesTypeName']+"<input type='hidden' name='classes["+index2+"].classesTypeId' value='"+json['classesTypes'][j]['classesTypeId']+"'/><input type='hidden' name='classes["+index2+"].classesTypeName' value='"+json['classesTypes'][j]['classesTypeName']+"'/><input type='hidden' name='classes["+index2+"].postId' value='"+values[i]['id']+"'/></td><td><input name='classes["+index2+"].classesName' type='text'/></td><td><input name='classes["+index2+"].startTime' type='text'/></td><td><input name='classes["+index2+"].endTime' type='text'/></td><td><input name='classes["+index2+"].headcount' type='text'/></td>";
				    			 if(parseInt(json['classesTypes'][j]['usable'])==1)
				    			 {
				    				 classes+="<td><input type='checkbox' checked='checked' name='classes["+index2+"].usable' value='1'/></td></tr>";
				    			 }else
				    			 {
				    				 classes+="<td><input type='checkbox' name='classes["+index2+"].usable' value='1'/></td></tr>";
				    			 }
				    			 $("#classesType"+index+""+index1+"").after(classes);
						    	 index2++;
						    }	
				    	}
				    	index1++;
				    	index3++;
				    }
				    index++;
				});  
			});
		}  
		
		function postTypeClick(index){
			if($("tr[name='post"+index+"']").css("display")=='none')
			{
				$("tr[name='post"+index+"']").css("display","");
			}else
			{
				$("tr[name='post"+index+"']").css("display","none");
			}
		}
		
		function setClasses(index,index1){ 
			if($("tr[name='classesType"+index+""+index1+"']").css("display")=='none')
			{
				$("tr[name='classesType"+index+""+index1+"']").css("display","");
			}else
			{
				$("tr[name='classesType"+index+""+index1+"']").css("display","none");
			}
		}
	</script>
</body>
</html>