<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>车辆理赔信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>车辆理赔id</th>
				<th>车辆id</th>
				<th>保险单号</th>
				<th>出险日期</th>
				<th>理赔类型</th>
				<th>理赔险种</th>
				<th>保险公司</th>
				<th>理赔金额</th>	
				<th>收益人</th>
				<th>联系地址</th>
				<th>联系电话</th>
				<th>证件号码</th>
				<th>理赔状态</th>
				<th>完成日期</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty Carclaiminfos }">
				<c:forEach items="${Carclaiminfos}" var="e" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${e.carClaimid}"/>${s.count}</td>
						<td>${e.carInfo.carId}</td>			
						<td>${e.insuranceOrder}</td>
						<td><fmt:formatDate value="${e.dangerDate}" pattern="yyyy-MM-dd"/></td>
						<td>${e.claimType}</td>
						<td>${e.claimKind}</td>						
						<td>${e.insuranceCompany}</td>
						<td>${e.claimAmount}</td>
						<td>${e.beneficiary}</td>
						<td>${e.contactAddress}</td>
						<td>${e.contactTelephone}</td>
						<td>${e.cardNum}</td>
						<td>${e.claimState}</td>
						<td>${e.finishDate}</td>
						<td><a href="javascript:updateCarclaiminfo(${e.carClaimid})">修改</a></td>
						<td><a href="javascript:deleteCarclaiminfoById(${e.carClaimid})">删除</a></td>
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
			<a href="javascript:addCarclaiminfo()" class="myBtn"><em>新增</em></a>
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
		
		function deleteCarclaiminfoById(carClaimid)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Carclaiminfo/deleteCarclaiminfoById.do";
				$.post(url,{carClaimid:carClaimid},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");
					}
				});
			}
		}
		
		function addCarclaiminfo(){
			var dg = new $.dialog({
				title:'新增车辆理赔信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Carclaiminfo/getCarclaiminfo.do?carClaimid=0'
				});
    		dg.ShowDialog();
		}
		
		function updateCarclaiminfo(carClaimid){
			var dg = new $.dialog({
				title:'修改车辆理赔信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Carclaiminfo/getCarclaiminfo.do?carClaimid='+carClaimid
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>