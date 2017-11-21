<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>宗地信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>用地类型</th>
				<th>开发类型</th>
				<th>交易方式</th>
				<th>开发期限起</th>
				<th>开发期限止</th>
				<th>土地价格</th>
				<th>土地性质</th>	
				<th>独立项目</th>
				<th>土地条件</th>
				<th>总用地面积</th>
				<th>总建筑面积</th>
				<th>计容建筑面积</th>
				<th>容积率</th>
				<th>土地亩价</th>
				<th>折合楼面价</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty parcelinfos }">
				<c:forEach items="${parcelinfos}" var="p" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${p.parcelNumber}"/>${s.count}</td>
						<td>${p.landKind}</td>			
						<td>${p.developKind}</td>
						<td>${p.tradeWay}</td>
						<td><fmt:formatDate value="${p.developTimeStart}" pattern="yyyy-MM-dd"/></td>						
						<td><fmt:formatDate value="${p.developTimeEnd}" pattern="yyyy-MM-dd"/></td>
						<td>${p.landPrice}</td>
						<td>${p.landNature}</td>
						<td>${p.independentProject}</td>
						<td>${p.landCondition}</td>
						<td>${p.totalLandArea}</td>
						<td>${p.totalBuildArea}</td>
					 	<td>${p.capacityBuildingArea}</td>
					 	<td>${p.volumeRate}</td>
					 	<td>${p.landUnitPrice}</td>
					 	<td>${p.atFloorPrice}</td>
						<td><a href="javascript:updateParcelinfo(${p.parcelNumber})">修改</a></td>
						<td><a href="javascript:deleteParcelinfo(${p.parcelNumber})">删除</a></td>
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
			<a href="javascript:addParcelinfo()" class="myBtn"><em>新增</em></a>
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
		
		function deleteParcelinfo(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Parcelinfo/deleteParcelinfo.do";
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
		
		function addParcelinfo(){
			var dg = new $.dialog({
				title:'新增宗地信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Parcelinfo/getParcelinfo.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateParcelinfo(homeid){
			var dg = new $.dialog({
				title:'修改宗地信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Parcelinfo/getParcelinfo.do?id='+homeid
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>