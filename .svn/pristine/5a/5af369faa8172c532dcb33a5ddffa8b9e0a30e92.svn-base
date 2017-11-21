<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>车位信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>管理费单价</th>
				<th>车库编号</th>
				<th>个人客户id</th>
				<th>楼层号</th>
				<th>所在区</th>
				<th>车位号</th>	
				<th>是否机械车位</th>
				<th>车位位置</th>
				<th>车位属性</th>
				<th>是否固定车位</th>
				<th>竣工日期</th>
				<th>入伙日期</th>
				<th>销售状态</th>
				<th>入伙状态</th>
				<th>租赁状态</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty stalls }">
				<c:forEach items="${stalls}" var="p" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${p.stallId}"/>${s.count}</td>			
						<td>${p.maintenancePrice}</td>
						<td>${p.garagefield.garageId}</td>
						<td>${p.personCust.custId}</td>						
						<td>${p.floorNumber}</td>
						<td>${p.bairro}</td>
						<td>${p.stallNumber}</td>
						<td>${p.isMechanicalStall}</td>
						<td>${p.stallPosition}</td>
						<td>${p.stallProperty}</td>
						<td>${p.fixedParking}</td>
					 	<td><fmt:formatDate value="${p.completionDate}" pattern="yyyy-MM-dd"/></td>
					 	<td><fmt:formatDate value="${p.intakeDate}" pattern="yyyy-MM-dd"/></td>
					 	<td>${p.salesState}</td>
					 	<td>${p.intakeState}</td>
					 	<td>${p.rentState}</td>
						<td><a href="javascript:updateStall(${p.stallId})">修改</a></td>
						<td><a href="javascript:deleteStall(${p.stallId})">删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="21">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addStall()" class="myBtn"><em>新增</em></a>
		</div>
		${stall.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteStall(stallId)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Stall/deleteStall.do";
				$.post(url,{stallId:stallId},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");
					}
				});
			}
		}
		
		function addStall(){
			var dg = new $.dialog({
				title:'新增车位信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Stall/getStall.do?stallId=0'
				});
    		dg.ShowDialog();
		}
		
		function updateStall(stallId){
			var dg = new $.dialog({
				title:'修改车位信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Stall/getStall.do?stallId='+stallId
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>