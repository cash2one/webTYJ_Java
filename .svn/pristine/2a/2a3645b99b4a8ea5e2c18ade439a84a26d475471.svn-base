<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>工单信息</title>
</head>
<form id="orderFrom" action="/Home/Order.do" method="post">
<div class="search_div">
		工单号：<input type="text" name="workOrderId" value="${order.workOrderId }"/>
		工单类型：<select name="todoCd" id="todoCd" style="vertical-align: middle;">
			<option value="">请选择</option>
			<c:forEach items="${orderTypes}" var="o">
			<%-- <c:if test="${o.orderTypeId==order.todoCd}">selected</c:if> --%>
			<option value="${o.orderTypeId}" >${o.orderTypeType }</option>
			</c:forEach>
		</select>
		<a href="javascript:search();" class="myBtn"><em>查询</em></a>
	</div>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>客户名称</th>
				<th>房屋名称</th>
				<th>任务描述</th>
				<th>状态</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty orders }">
				<c:forEach items="${orders}" var="f" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${f.workOrderId}"/>${s.count}</td>								
						<td>${f.lastName}</td>
						<td>${f.houseName}</td>
						<td>${f.commentsLong}</td>
						<td>${f.evtStatCd}</td>
						<td><a href="javascript:AddOrderTurns(${f.workOrderId})">转单</a></td>
						<td><a href="javascript:AddOrderDeferred(${f.workOrderId})">申请延时</a></td>
						<td><a href="javascript:AddOrderAppointment(${f.workOrderId})">预约时间</a></td>
						<td><a href="javascript:AddAddwo(${f.workOrderId})">追加工单</a></td>

						<td><a href="javascript:AddChan(${f.workOrderId})">派单</a></td>
						<td><a href="javascript:Change(${f.workOrderId})">批量转单</a></td>
						<td><a href="javascript:School(${f.workOrderId})">派班</a></td>
						<td><a href="javascript:Chan(${f.workOrderId})">交接班</a></td>

						<td><a href="javascript:updateOrder(${f.workOrderId})">修改</a></td>
						<td><a href="javascript:addListur(${f.workOrderId})">催办</a></td>
						<td><a href="javascript:addDesignate(${f.workOrderId})">指派</a></td>
						<td><a href="javascript:addemailrecip(${f.workOrderId})">录音附件</a></td>
						<td><a href="javascript:deleteOrder(${f.workOrderId})" id="delete">删除</a></td>
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
			<a href="javascript:addOrder()" class="myBtn"><em>新增</em></a>
		</div>
		${Order.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteOrder(workOrderId)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Order/deleteOrder.do";
				$.post(url,{workOrderId:workOrderId},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");	
					}
				});
			}
		}
		
		function addOrder(){
			var dg = new $.dialog({
				title:'新增工单信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Order/getOrder.do?workOrderId=0'
				});
    		dg.ShowDialog();
		}
		
		function AddOrderDeferred(workOrderId){
			var dg = new $.dialog({
				title:'新增延时申请',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'OrderDeferred/getOrder.do?workOrderId='+workOrderId
				});
    		dg.ShowDialog();
		}
		
		function AddOrderAppointment(workOrderId){
			var dg = new $.dialog({
				title:'新增预约时间',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'OrderAppointment/getOrder.do?workOrderId='+workOrderId
				});
    		dg.ShowDialog();
		}
		
		function AddAddwo(workOrderId){
			var dg = new $.dialog({
				title:'新增追加工单',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Addwo/getOrder.do?workOrderId='+workOrderId
				});
    		dg.ShowDialog();
		}
		function AddOrderTurns(workOrderId){
			var dg = new $.dialog({
				title:'转单',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'OrderTurns/getOrder.do?workOrderId='+workOrderId
				});
    		dg.ShowDialog();
		}
		
		function updateOrder(workOrderId){
			var dg = new $.dialog({
				title:'修改工单信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Order/getOrder.do?workOrderId='+workOrderId
				});
    		dg.ShowDialog();
		}
		

		function Change(workOrderId){
			var dg = new $.dialog({
				title:'批量转单',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Change/getOrder.do?workOrderId='+workOrderId
				});
    		dg.ShowDialog();
		}
		
		function Chan(workOrderId){
			var dg = new $.dialog({
				title:'交接班',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Chan/getOrder.do?workOrderId='+workOrderId
				});
    		dg.ShowDialog();
		}
		
		function School(workOrderId){
			var dg = new $.dialog({
				title:'派班',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'School/getOrder.do?workOrderId='+workOrderId
				});
    		dg.ShowDialog();
		}
		

		function addListur(workOrderId){
			var dg = new $.dialog({
				title:'催办',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'listur/getOrder.do?workOrderId='+workOrderId
				});
    		dg.ShowDialog();
    		
		}
		
		function addDesignate(workOrderId){
			var dg = new $.dialog({
				title:'指派',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'designate/getOrder.do?workOrderId='+workOrderId
				});
    		dg.ShowDialog();
    		
		}
		function addemailrecip(workOrderId){
			var dg = new $.dialog({
				title:'添加录音',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'emailrecipClaim/getOrder.do?workOrderId='+workOrderId
				});
    		dg.ShowDialog();
    		
		}
		
		

		function search()
		{
			$("#orderFrom").submit();
		}
		</script>

</body>
</form>
</html>