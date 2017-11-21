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
	<form action="house.do" method="post" name="houseForm" id="houseForm">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>序号</th>
			<th>项目id</th>
			<th>客户id</th>
			<th>房屋编号</th>
			<th>商铺编号</th>
			<th>小区期号</th>
			<th>小区区号</th>
			<th>栋号</th>
			<th>座号</th>
			<th>单元</th>
			<th>楼层</th>
			<th>楼层区</th>
			<th>房号</th>
			<th>门牌号</th>
			<th>入伙日期</th>
			<th>入伙状态</th>
			<th>销售状态</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty Houses}">
				<c:forEach items="${Houses}" var="house" varStatus="vs">
				<tr class="main_info">
				<td>${house.id}</td>
				<td>${house.projectId}</td>
				<td>${house.custId}</td>
				<td>${house.houseId}</td>
				<td>${house.shopId}</td>
				<td>${house.estateIssue}</td>
				<td>${house.estateAreacode}</td>
				<td>${house.ridgeNum}</td>
				<td>${house.seatNum}</td>
				<td>${house.unit}</td>
				<td>${house.floor}</td>
				<td>${house.floorarea}</td>
				<td>${house.roomNum}</td>
				<td>${house.gateNum}</td>
				<td><fmt:formatDate value="${house.joinDate}" pattern="yyyy-MM-dd"/></td>
				<td>${house.joinState}</td>
				<td>${house.marketState}</td>
				<td><a href="javascript:editHouse(${house.id});">修改</a> | <a href="javascript:delHouse(${house.id});">删除</a></td>
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
			<a href="javascript:addHouse();" class="myBtn"><em>新增</em></a>
		</div>
		${house.page.pageStr }
	</div>
	</form>
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function addHouse(){
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
				page:'House/getHouse.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function editHouse(id){
			var dg = new $.dialog({
				title:'修改住宅信息',
				id:'house_edit',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				resize:false,
				page:'House/getHouse.do?id='+id
				});
    		dg.ShowDialog();
		}
		
		function delHouse(id){
			if(confirm("确定要删除该记录？")){
				var url = "/Home/House/deleteHouse.do?";
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