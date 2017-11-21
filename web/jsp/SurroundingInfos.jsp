<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Test</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
</head>
<body>
	<form action="surroundinginfo.do" method="post" name="surroundinginfoForm" id="surroundinginfoForm">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>序号</th>
			<th>项目id</th>
			<th>类型</th>
			<th>名称</th>
			<th>地址</th>
			<th>联系方式</th>
			<th>照片</th>
			<th>网站地址</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty SurroundingInfos}">
				<c:forEach items="${SurroundingInfos}" var="info" varStatus="vs">
				<tr class="main_info">
				<td>${info.id}</td>
				<td>${info.projectId}</td>
				<td>${info.style}</td>
				<td>${info.name}</td>
				<td>${info.address}</td>
				<td>${info.contactInformation}</td>
				<td>${info.phonto}</td>
				<td>${info.website}</td>
				<td><a href="javascript:editTraffic(${info.id});">修改</a> | <a href="javascript:delTraffic(${info.id});">删除</a></td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="7">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addTraffic();" class="myBtn"><em>新增</em></a>
		</div>
		${traffic.page.pageStr }
	</div>
	</form>
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function addTraffic(){
			//$(".shadow").show();
			var dg = new $.dialog({
				title:'新增周围信息',
				id:'house_new',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'SurroundingInfo/getSurroundingInfo.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function editTraffic(id){
			var dg = new $.dialog({
				title:'修改住宅信息',
				id:'house_edit',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				resize:false,
				page:'SurroundingInfo/getSurroundingInfo.do?id='+id
				});
    		dg.ShowDialog();
		}
		
		function delTraffic(id){
			if(confirm("确定要删除该记录？")){
				var url = "/Home/SurroundingInfo/deleteSurroundingInfo.do?";
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
		
	</script>
</body>
</html>