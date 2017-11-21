<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>内部服务请求</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>序号</th>
			<th>内部服务请求编号</th>
			<th>服务类型</th>
			<th>分类</th>
			<th>专业</th>
			<th>描述</th>
			<th>请求状态</th>
			<th>来源</th>
			<th>优先级</th>
			<th>重要程度</th>
			<th>房屋id</th>
			<th>房屋名称</th>
			<th>公共位置服务请求</th>
			<th>客户id</th>
			<th>客户名称</th>
			<th>企业id</th>
			<th>企业名称</th>
			<th>管理处id</th>
			<th>项目</th>
			<th>提交时间</th>
			<th>业务受理/原工单id</th>
			<th>接待对象</th>
			<th>是否保内</th>
			<th>投诉对象id</th>
			<th>投诉对象</th>
			<th>投诉工号</th>
			<th>投诉部门id</th>
			<th>投诉部门</th>
			<th>受理id</th>
			<th>受理人</th>
			<th>客户id</th>
			<th>受理人工号</th>
			<th>操作<th>
		</tr>
		<c:choose>
			<c:when test="${not empty interiorServeList}">
				<c:forEach items="${logistiList}" var="interiorServe" varStatus="vs">
				<tr class="main_info">
				<td>${vs.index+1}</td> 
				<td>${interiorServe.interiorServeId}</td>
				<td><fmt:formatDate value="${interiorServe.serveType}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${interiorServe.reqestType}" pattern="yyyy-MM-dd"/></td>
				<td>${interiorServe.cla}</td>
				<td>${interiorServe.specialty}</td>
				<td>${interiorServe.describe}</td>
				<td>${interiorServe.requestState}</td>
				<td>${interiorServe.source}</td>
				<td><fmt:formatDate value="${interiorServe.priority}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${interiorServe.level}" pattern="yyyy-MM-dd"/></td>
				<td>${interiorServe.houseId}</td>
				<td>${interiorServe.houseName}</td>
				<td>${interiorServe.publicServeReq}</td>
				<td>${interiorServe.custId}</td>
				<td>${interiorServe.custName}</td>
				<td><fmt:formatDate value="${interiorServe.prConOrgId}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${interiorServe.enterpriseName}" pattern="yyyy-MM-dd"/></td>
				<td>${interiorServe.buId}</td>
				<td>${interiorServe.buName}</td>
				<td>${interiorServe.actOpenDt}</td>
				<td>${interiorServe.actId}</td>
				<td>${interiorServe.altContactName}</td>
				<td>${interiorServe.undMfgWrntyFlg}</td>
				<td>${interiorServe.toTellerId}</td>
				<td>${interiorServe.compTargetName}</td>
				<td><fmt:formatDate value="${interiorServe.compTargetNum}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${interiorServe.xTargetBuId}" pattern="yyyy-MM-dd"/></td>
				<td>${interiorServe.compBuName}</td>
				<td>${interiorServe.ownerEmpId}</td>
				<td>${interiorServe.ownerName}</td>
				<td>${interiorServe.ownerNum}</td>
			    	<td><a href="javascript:editLogisti(${interiorServe.interiorServeId});">修改</a> | <a href="javascript:delLogisti(${interiorServe.interiorServeId});">删除</a> </td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
				<td colspan="3">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addLogisti();" class="myBtn"><em>新增</em></a>
		</div>
		${logisti.page.pageStr }
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	

</body>
</html>