<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>委托信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>委托编号</th>
				<th>资产装修编号</th>
				<th>客户编号</th>
				<th>委托日期</th>
				<th>委托人姓名</th>
				<th>委托人电话</th>
				<th>委托人证件类型</th>	
				<th>委托人证件号码</th>
				<th>业务类型</th>
				<th>被委托人姓名</th>
				<th>被委托人电话</th>
				<th>被委托人证件类型</th>
				<th>被委托人证件号码</th>
				<th>证件描述</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty EntrustInfos }">
				<c:forEach items="${EntrustInfos}" var="e" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${e.entrustId}"/>${s.count}</td>
						<td>${e.entrustNum}</td>			
						<td>${e.assetdecorate.assetsDecorateId}</td>
						<td>${e.personCust.custCode}</td>
						<td><fmt:formatDate value="${e.entrustDate}" pattern="yyyy-MM-dd"/></td>						
						<td>${e.entrusterName}</td>
						<td>${e.entrusterTelephone}</td>
						<td>
							<c:if test="${e.entrusterCardType==0}">
								身份证
							</c:if>
							<c:if test="${e.entrusterCardType==1}">
								护照
							</c:if>
						</td>
						<td>${e.entrusterCardNum}</td>
						<td>
							<c:if test="${e.vocationalType==0}">
								装修业务1
							</c:if>
							<c:if test="${e.vocationalType==1}">
								装修业务2
							</c:if>
						</td>
						<td>${e.entrustedName}</td>
						<td>${e.entrustEdTelephone}</td>
					 	<td>
					 		<c:if test="${e.entrustedCardType==0}">
								身份证
							</c:if>
							<c:if test="${e.entrustedCardType==1}">
								护照
							</c:if>
						</td>
					 	<td>${e.entrustedCardNum}</td>
					 	<td>${e.cardDescribe}</td>
						<td><a href="javascript:updateEntrustInfo(${e.entrustId})">修改</a></td>
						<td><a href="javascript:deleteEntrustInfo(${e.entrustId})">删除</a></td>
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
			<a href="javascript:addEntrustInfo()" class="myBtn"><em>新增</em></a>
		</div>
		${entrustInfo.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteEntrustInfo(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/EntrustInfo/deleteEntrustInfo.do";
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
		
		function addEntrustInfo(){
			var dg = new $.dialog({
				title:'新增委托信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'EntrustInfo/getEntrustInfo.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateEntrustInfo(id){
			var dg = new $.dialog({
				title:'修改委托信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'EntrustInfo/getEntrustInfo.do?id='+id
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>