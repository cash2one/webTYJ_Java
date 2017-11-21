<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>资产租赁信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>出租人id</th>
				<th>承租人id</th>
				<th>出租开始日期</th>
				<th>出租结束日期</th>
				<th>合同号</th>
				<th>出租价格</th>
				<th>是否递增</th>
				<th>递增类型</th>
				<th>计费日期</th>
				<th>交费截止日期</th>
				<th>收账账号</th>
				<th>免租开始时间</th>
				<th>免租结束时间</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty assetrents }">
				<c:forEach items="${assetrents}" var="f" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${f.capitalLeaseId}"/>${s.count}</td>				
						<td>${f.hireId}</td>
						<td>${f.lesseeId}</td>
						<td><fmt:formatDate value="${f.hireStartDate}" pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value="${f.hireFinishDate}" pattern="yyyy-MM-dd"/></td>
						<td>${f.contractNumber}</td>
						<td>${f.hirePrice}</td>
						<td>${f.increaseed}</td>
						<td>${f.increaseType}</td>
						<td><fmt:formatDate value="${f.chargingDate}" pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value="${f.paymentCloseDate}" pattern="yyyy-MM-dd"/></td>
						<td>${f.receiveAccount}</td>
						<td><fmt:formatDate value="${f.freeHireStartDate}" pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value="${f.freeFinishEndDate}" pattern="yyyy-MM-dd"/></td>
						<td><a href="javascript:updateAssetrent(${f.capitalLeaseId})">修改</a></td>
						<td><a href="javascript:deleteAssetrent(${f.capitalLeaseId})" id="delete">删除</a></td>
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
			<a href="javascript:addAssetrent()" class="myBtn"><em>新增</em></a>
		</div>
		${Assetrent.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteAssetrent(capitalLeaseId)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Assetrent/deleteAssetrent.do";
				$.post(url,{capitalLeaseId:capitalLeaseId},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");	
					}
				});
			}
		}
		
		function addAssetrent(){
			var dg = new $.dialog({
				title:'新增资产租赁信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Assetrent/getAssetrent.do?capitalLeaseId=0'
				});
    		dg.ShowDialog();
		}
		
		function updateAssetrent(capitalLeaseId){
			var dg = new $.dialog({
				title:'修改资产租赁信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Assetrent/getAssetrent.do?capitalLeaseId='+capitalLeaseId
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>