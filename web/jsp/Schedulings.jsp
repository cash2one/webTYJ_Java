<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>排班表</title>
</head>
<form id="SchedulingFrom" action="/Home/Scheduling.do" method="post">
<div class="search_div">
		员工号：<input type="text" name="staffId" value="${scheduling.staffId}"/>
		班次：<select name="classesId" style="width: 50px;">
			<option value="" selected="selected">全部</option>
			<option <c:if test="${scheduling.classesId==1}">selected="selected"</c:if> value="1">A班</option>
			<option <c:if test="${scheduling.classesId==2}">selected="selected"</c:if> value="2">B班</option>
			<option <c:if test="${scheduling.classesId==3}">selected="selected"</c:if> value="3">C班</option>
		</select>
		日期：<input type="text" name="currentDate" onclick="WdatePicker()" value="${scheduling.currentDate}">
		<a href="javascript:search();" class="myBtn"><em>查询</em></a>
	</div>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>排班编号</th>
				<th>员工</th>
				<th>班次</th>
				<th>备注</th>
				<th>日期</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty Schedulings }">
				<c:forEach items="${Schedulings}" var="e" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${e.id}"/>${s.count}</td>
						<td>${e.staff.firstName}${e.staff.lastName}</td>
						<td>${e.classes.classesname}</td>
						<td>${e.remark}</td>
						<td><fmt:formatDate value="${e.currentDate}" pattern="yyyy-MM-dd"/></td>
						<td>${e.currentDate}</td>
						<td><fmt:formatDate value="${e.currentDate}" pattern="yyyy-MM-dd"/></td>
						<td><a href="javascript:updateScheduling(${e.id})">修改</a></td>
						<td><a href="javascript:deleteScheduling(${e.id})">删除</a></td>
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
			<a href="javascript:addScheduling()" class="myBtn"><em>新增</em></a>
		</div>
		${scheduling.page.pageStr}
	</div>
	</form>
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteScheduling(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Scheduling/deleteScheduling.do";
				$.post(url,{id:id},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");
					}
				});
			}
		}
		
		function addScheduling(){
			var dg = new $.dialog({
				title:'新增排班',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Scheduling/getSchedulingbyId.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateScheduling(id){
			var dg = new $.dialog({
				title:'修改排班',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Scheduling/getSchedulingbyId.do?id='+id
				});
    		dg.ShowDialog();
		}
		function search(){
			$("#SchedulingFrom").submit();
		}
		</script>
		
</script>
</body>
</form>
</html>