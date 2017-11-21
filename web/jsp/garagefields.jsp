<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>车库id</th>
				<th>项目id</th>
				<th>车库编码</th>
				<th>车库识别码</th>
				<th>显示名称</th>
				<th>位置描述</th>
				<th>车位类型</th>
				<th>车位数</th>
				<th>车库入口数</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty garagefields }">
				<c:forEach items="${garagefields}" var="g" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${g.garageId}"/>${s.count}</td>
						<td>${g.project.projectId}</td> 
						<td>${g.garageNumber}</td> 
						<td>${g.garageCdkey}</td>
						<td>${g.name}</td>
						<td>${g.position}</td>
						<td>${g.stallKind}</td>
						<td>${g.projectNumber}</td>
						<td>${g.garageEntnum}</td>
						<td><a href="javascript:updateGaragefield(${g.garageId})">修改</a></td>
						<td><a href="javascript:deleteGaragefieldById(${g.garageId})" id="delete">删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="9">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addGaragefield()" class="myBtn"><em>新增</em></a>
		</div>
		${garagefield.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteGaragefieldById(garageId)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/garagefield/deleteGaragefieldById.do";
				$.post(url,{garageId:garageId},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");	
					}
				});
			}
		}
		
		function addGaragefield(){
			var dg = new $.dialog({
				title:'新增清单信息',
				id:'user_new',
				width:400,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'garagefield/getGaragefield.do?garageId=0'
				});
    		dg.ShowDialog();
		}
		
		function updateGaragefield(garageId){
			var dg = new $.dialog({
				title:'修改清单信息',
				id:'user_new',
				width:400,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'garagefield/getGaragefield.do?garageId='+garageId
				});
    		dg.ShowDialog();
		}
		
	</script>
</body>
</html>