<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>工单延时日期申请信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>工单编号</th>
				<th>希望延长时间</th>
				<th>延长原因描述</th>
				<th>责任人号</th>
				<th>责任人</th>
				<th>申请状态</th>
				<th>审批人</th>	
				<th>审批状态</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty OrderDeferreds }">
				<c:forEach items="${OrderDeferreds}" var="o" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${o.orderDeferredId}"/>${s.count}</td>
						<td>${o.order.workOrderId}</td>			
						<td>${o.cemTotalTime}</td>
						<td>${o.descText}</td>
						<td>${o.ownerNum}</td>						
						<td>${o.ownerName}</td>
						<td>
							<c:choose>
                                <c:when test="${o.evtStatCd==0}">
                                   	 申请状态	
                                </c:when>
       							<c:when test="${o.evtStatCd==1}">
                                   	 申请状态1
                                </c:when>
                                <c:when test="${o.evtStatCd==2}">
                                   	申请状态2
                                </c:when>
                            </c:choose>
						</td>
					 	<td>${o.approverName}</td>
					 	<td>
					 		<c:choose>
                                <c:when test="${o.approverStatCd==0}">
                                   	同意	
                                </c:when>
       							<c:when test="${o.approverStatCd==1}">
                                   	 拒绝
                                </c:when>
                                <c:when test="${o.approverStatCd==2}">
                                   	打回
                                </c:when>
                             </c:choose>
					 	</td>
						<td><a href="javascript:updateOrderDeferred(${o.orderDeferredId})">修改</a></td>
						<td><a href="javascript:deleteOrderDeferred(${o.orderDeferredId})">删除</a></td>
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
			<a href="javascript:addOrderDeferred()" class="myBtn"><em>新增</em></a>
		</div>
		${orderDeferred.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteOrderDeferred(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/OrderDeferred/deleteOrderDeferred.do";
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
		
		function addOrderDeferred(){
			var dg = new $.dialog({
				title:'新增工单延时日期申请信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'OrderDeferred/getOrderDeferred.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateOrderDeferred(id){
			var dg = new $.dialog({
				title:'修改工单延时日期申请信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'OrderDeferred/getOrderDeferred.do?id='+id
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>