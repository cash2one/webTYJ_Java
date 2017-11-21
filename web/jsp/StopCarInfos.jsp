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
	<form action="stopCarInfo.do" method="post" name="stopCarInfoForm" id="stopCarInfoForm">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>停车信息id</th>
			<th>车牌号码</th>
			<th>车位id</th>
			<th>车位类型</th>
			<th>停车状态</th>
			<th>开始日期</th>
			<th>结束日期</th>			
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty StopCarInfos}">
				<c:forEach items="${StopCarInfos}" var="stop" varStatus="vs">
				<tr class="main_info">
				<td>${stop.stopCarId}</td>
				<td>${stop.carId}</td>
				<td>${stop.stallId}</td>
				<td>${stop.stallStyle}</td>
				<td>${stop.stopState}</td>
				<td><fmt:formatDate value="${stop.startDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${stop.endDate}" pattern="yyyy-MM-dd"/></td>
				
				<td><a href="javascript:editStopCarInfo(${stop.stopCarId});">修改</a> | <a href="javascript:delStopCarInfo(${stop.stopCarId});">删除</a></td>
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
			<a href="javascript:addStopCarInfo();" class="myBtn"><em>新增</em></a>
		</div>
		${stop.page.pageStr }
	</div>
	</form>
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function addStopCarInfo(){
			//$(".shadow").show();
			var dg = new $.dialog({
				title:'新增猪仔信息',
				id:'house_new',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'StopCarInfo/getStopCarInfo.do?stopCarId=0'
				});
    		dg.ShowDialog();
		}
		
		function editStopCarInfo(stopCarId){
			var dg = new $.dialog({
				title:'修改住宅信息',
				id:'house_edit',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				resize:false,
				page:'StopCarInfo/getStopCarInfo.do?stopCarId='+stopCarId
				});
    		dg.ShowDialog();
		}
		
		function delStopCarInfo(stopCarId){
			if(confirm("确定要删除该记录？")){
				var url = "/Home/StopCarInfo/deleteStopCarInfo.do?";
				$.post(url,{stopCarId:stopCarId},function(data){
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