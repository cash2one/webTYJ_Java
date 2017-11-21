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
	<form action="buinessfieldinfo.do" method="post" name="buinessfieldinfoForm" id="buinessfieldinfoForm">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>序号</th>
			<th>项目编号</th>
			<th>是否计费</th>
			<th>管理费单价</th>
			<th>专项资金</th>
			<th>区号</th>
			<th>期号</th>
			<th>座</th>
			<th>栋号</th>
			<th>单元</th>
			<th>楼层</th>
			<th>楼层区</th>
			<th>商铺号</th>
			<th>商铺地址</th>
			<th>销售状态</th>
			<th>经营信息</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty buinessfieldinfoList}">
				<c:forEach items="${buinessfieldinfoList}" var="buiness" varStatus="vs">
				<tr class="main_info">
				<td><input type="hidden" value="${buiness.shopId}"/>${vs.count}</td>
				<td>${buiness.projectNumber }</td>
				<td>${buiness.charging }</td>
				<td>${buiness.maintenancePrice}</td>
				<td>${buiness.specialMoney}</td>
				<td>${buiness.areaCode }</td>
				<td>${buiness.number }</td>
				<td>${buiness.seat }</td>
				<td>${buiness.ridgepole }</td>
				<td>${buiness.unit }</td>
				<td>${buiness.floor }</td>
				<td>${buiness.floorArea }</td>
				<td>${buiness.shopNumber }</td>
				<td>${buiness.shopAddress }</td>
				<td>${buiness.salesState }</td>
				<td>${buiness.operateMessage }</td>
				<td><a href="javascript:editBuiness(${buiness.shopId });">修改</a> | <a href="javascript:delBuiness(${buiness.shopId });">删除</a></td>
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
			<a href="javascript:addBuiness();" class="myBtn"><em>新增</em></a>
		</div>
		${buiness.page.pageStr }
	</div>
	</form>
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function addBuiness(){
			//$(".shadow").show();
			var dg = new $.dialog({
				title:'新增商业字段信息',
				id:'buinessfieldinfo_new',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Buinessfieldinfo/getBuinessfieldinfo.do?shopId=0'
				});
    		dg.ShowDialog();
		}
		
		function editBuiness(shopId){
			var dg = new $.dialog({
				title:'修改用户',
				id:'buinessfieldinfo_edit',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				resize:false,
				page:'Buinessfieldinfo/getBuinessfieldinfo.do?shopId='+shopId
				});
    		dg.ShowDialog();
		}
		
		function delBuiness(shopId){
			if(confirm("确定要删除该记录？")){
				var url = "Buinessfieldinfo/delete.do?shopId="+shopId;
				$.get(url,function(data){
					if(data=="success"){
						document.location.reload();
					}
				});
			}
		}
		
	</script>
</body>
</html>