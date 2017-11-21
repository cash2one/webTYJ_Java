<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>门禁、车辆卡信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>门禁、车辆卡id</th>
				<th>绑定住宅id</th>
				<th>卡类型</th>
				<th>ID卡号</th>
				<th>办卡日期</th>
				<th>卡状态</th>
				<th>启用日期</th>
				<th>截止日期</th>	
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty Caraccesscard }">
				<c:forEach items="${Caraccesscard}" var="e" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${e.cardId}"/>${s.count}</td>
						<td>${e.house.id}</td>			
						<td>${e.cardKind}</td>
						<td>${e.idcardNum}</td>
						<td><fmt:formatDate value="${e.doCarddate}" pattern="yyyy-MM-dd"/></td>	
						<td>${e.cardState}</td>
						<td><fmt:formatDate value="${e.startDate}" pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value="${e.endDate}" pattern="yyyy-MM-dd"/></td>					
						<td><a href="javascript:updateCaraccesscard(${e.cardId})">修改</a></td>
						<td><a href="javascript:deleteCaraccesscardById(${e.cardId})">删除</a></td>
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
			<a href="javascript:addCaraccesscard()" class="myBtn"><em>新增</em></a>
		</div>
		${caraccesscard.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteCaraccesscardById(cardId)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Caraccesscard/deleteCaraccesscardById.do";
				$.post(url,{cardId:cardId},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");
					}
				});
			}
		}
		
		function addCaraccesscard(){
			var dg = new $.dialog({
				title:'新增门禁、车辆卡信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Caraccesscard/getCaraccesscard.do?cardId=0'
				});
    		dg.ShowDialog();
		}
		
		function updateCaraccesscard(cardId){
			var dg = new $.dialog({
				title:'修改门禁、车辆卡信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Caraccesscard/getCaraccesscard.do?cardId='+cardId
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>