<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>宗地规划信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>宗地编号</th>
				<th>总占地面积</th>
				<th>容积率</th>
				<th>计容面积</th>
				<th>核增计容面积</th>
				<th>核增容积率</th>
				<th>建筑密度</th>	
				<th>商业建筑面积</th>
				<th>建筑高度</th>
				<th>总体指标平衡</th>
				<th>航空限高区间</th>
				<th>总建筑面积</th>
				<th>其他独立用地面积</th>
				<th>剩余建筑面积</th>
				<th>退红线要求</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty ParcePlannings }">
				<c:forEach items="${ParcePlannings}" var="p" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${p.parcePlanningId}"/>${s.count}</td>
						<td>${p.parce.parceId}</td>			
						<td>${p.occupationArea}</td>
						<td>${p.plotRatio}</td>
						<td>${p.calArea}</td>						
						<td>${p.accountCalArea}</td>
						<td>${p.accountPlotRatio}</td>
						<td>${p.buildingDensity}</td>
						<td>${p.businessBuildArea}</td>
					 	<td>${p.buildingHeight}</td>
					 	<td>${p.totalTargetBalance}</td>
					 	<td>${p.absoluteLevel}</td>
					 	<td>${p.totalBuildArea}</td>
					 	<td>${p.otherIndependentLandArea}</td>
					 	<td>${p.remainBuildArea}</td>
					 	<td>${p.backLineRequirement}</td>
						<td><a href="javascript:updateParcePlanning(${p.parcePlanningId})">修改</a></td>
						<td><a href="javascript:deleteParcePlanning(${p.parcePlanningId})">删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="23">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addParcePlanning()" class="myBtn"><em>新增</em></a>
		</div>
		${parcePlanning.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteParcePlanning(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/ParcePlanning/deleteParcePlanning.do";
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
		
		function addParcePlanning(){
			var dg = new $.dialog({
				title:'新增宗地规划信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'ParcePlanning/getParcePlanning.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateParcePlanning(id){
			var dg = new $.dialog({
				title:'修改宗地规划信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'ParcePlanning/getParcePlanning.do?id='+id
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>