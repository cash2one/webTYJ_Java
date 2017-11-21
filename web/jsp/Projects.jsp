<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>项目字段表</title>
</head>
<form id="ProjectFrom" action="/Home/Project.do" method="post">
<div class="search_div">
		项目id号：<input type="text" name="projectId" value="${Project.projectId}"/>
		<a href="javascript:search();" class="myBtn"><em>查询</em></a>
	</div>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>项目id</th>
				<th>项目编号</th>
				<th>项目名称</th>
				<th>公司</th>
				<th>概要</th>
				<th>联系电话</th>
				<th>全地址</th>
				<th>宗地信息</th>
				<th>规划信息</th>
				<th>车位总数</th>
				<th>住宅总户数</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty Projects }">
				<c:forEach items="${Projects}" var="e" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${e.projectId}"/>${s.count}</td>				
						<td>${e.projectNumber}</td>
						<td>${e.projectName}</td>
						<td>${e.company}</td>
						<td>${e.outline}</td>
						<td>${e.phone}</td>
						<td>${e.address}</td>
						<td>${e.parcel}</td>
						<td>${e.planning}</td>
						<td>${e.privateStallnum}</td>
						<td>${e.houseTotalnum}</td>
						<td><a href="javascript:updateProject(${e.projectId})">修改</a></td>
						<td><a href="javascript:deleteProjectById(${e.projectId})">删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="17">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addProject()" class="myBtn"><em>新增</em></a>
		</div>
		${project.page.pageStr}
	</div>
	</form>
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteProjectById(projectId)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Project/deleteProjectById.do";
				$.post(url,{projectId:projectId},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");
					}
				});
			}
		}
		
		function addProject(){
			var dg = new $.dialog({
				title:'新增项目信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Project/getProject.do?projectId=0'
				});
    		dg.ShowDialog();
		}
		
		function updateProject(projectId){
			var dg = new $.dialog({
				title:'修改项目信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Project/getProject.do?projectId='+projectId
				});
    		dg.ShowDialog();
		}
		function search(){
			$("#ProjectFrom").submit();
		}
		</script>

</body>
</form>
</html>