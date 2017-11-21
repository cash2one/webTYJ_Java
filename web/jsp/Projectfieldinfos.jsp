<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>项目字段信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>项目名称</th>
				<th>项目编号</th>
				<th>项目总占地面积</th>
				<th>容积率</th>
				<th>核增容积率</th>
				<th>绿化率</th>
				<th>总建筑面积</th>	
				<th>计容面积</th>
				<th>核增计容面积</th>
				<th>车位配比</th>
				<th>地下室面积</th>
				<th>地下车位总数</th>
				<th>地面车位总数</th>
				<th>全地址</th>
				<th>邮编</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty projectfieldinfos }">
				<c:forEach items="${projectfieldinfos}" var="p" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${p.projectId}"/>${s.count}</td>
						<td>${p.projectName}</td>			
						<td>${p.projectNumber}</td>
						<td>${p.projectTotalArea}</td>
						<td>${p.plotRatio}</td>						
						<td>${p.addPlotRatio}</td>
						<td>${p.greeningRate}</td>
						<td>${p.totalBuildArea}</td>
						<td>${p.capacitanceArea}</td>
						<td>${p.addCapacitanceArea}</td>
						<td>${p.basementArea}</td>
						<td>${p.stallMatching}</td>
					 	<td>${p.undergroundParkingSpacesTotal}</td>
					 	<td>${p.groundParkingSpaceTotal}</td>
					 	<td>${p.fullAddress}</td>
					 	<td>${p.postcode}</td>
						<td><a href="javascript:updateProjectfieldinfo(${p.projectId})">修改</a></td>
						<td><a href="javascript:deleteProjectfieldinfo(${p.projectId})">删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="18">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addProjectfieldinfo()" class="myBtn"><em>新增</em></a>
		</div>
		${projectfieldinfo.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteProjectfieldinfo(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Projectfieldinfo/deleteProjectfieldinfo.do";
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
		
		function addProjectfieldinfo(){
			var dg = new $.dialog({
				title:'新增项目字段信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Projectfieldinfo/getProjectfieldinfo.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateProjectfieldinfo(homeid){
			var dg = new $.dialog({
				title:'修改项目字段信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Projectfieldinfo/getProjectfieldinfo.do?id='+homeid
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>