<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>工单类型</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>类型编号</th>
				<th>类型名称</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty OrderTypes}">
				<c:forEach items="${OrderTypes}" var="o" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${o.orderTypeId}"/>${s.count}</td>
						<td>${o.orderTypeId}</td>			
						<td>${o.orderTypeType}</td>
						<td><a href="javascript:updateOrderType(${o.orderTypeId})">修改</a></td>
						<td><a href="javascript:deleteOrderType(${o.orderTypeId})">删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="5">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addOrderType()" class="myBtn"><em>新增</em></a>
		</div>
		${orderType.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteOrderType(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/OrderType/deleteOrderType.do";
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
		
		function addOrderType(){
			var dg = new $.dialog({
				title:'新增工单类型',
				id:'user_new',
				width:350,
				height:200,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'OrderType/getOrderType.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateOrderType(id){
			var dg = new $.dialog({
				title:'修改工单类型',
				id:'user_new',
				width:350,
				height:200,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'OrderType/getOrderType.do?id='+id
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>