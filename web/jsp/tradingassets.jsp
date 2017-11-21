<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>资产交易信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>车位ID</th>
				<th>合同ID</th>
				<th>房产证号</th>
				<th>认购日期</th>
				<th>签约日期</th>
				<th>登记价</th>
				<th>房屋折后价</th>
				<th>建筑面积单价</th>
				<th>套内面积单价</th>
				<th>交易类型</th>
				<th>付款方式</th>
				<th>首付</th>
				<th>按揭</th>
				<th>产权类型</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty tradingassetss }">
				<c:forEach items="${tradingassetss}" var="f" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${f.tradingAssetsId}"/>${s.count}</td>				
						<td>${f.stall.stallId}</td>					
						<td>${f.contractId}</td>
						<td>${f.houseCredentialsNum}</td>
						<td><fmt:formatDate value="${f.subscribeDate}" pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value="${f.signContractDate}" pattern="yyyy-MM-dd"/></td>
						<td>${f.registrationPrice}</td>
						<td>${f.houseFoldingPrice}</td>
						<td>${f.coveredAreaUnitprice}</td>
						<td>${f.unitAreaPrice}</td>
						<td>${f.businessType}</td>
						<td>${f.paymentType}</td>
						<td>${f.firstPaymentMoney}</td>
						<td>${f.mortgageMoney}</td>
						<td>${f.propertyRightType}</td>
						<td><a href="javascript:updateTradingassets(${f.tradingAssetsId})">修改</a></td>
						<td><a href="javascript:deleteTradingassets(${f.tradingAssetsId})" id="delete">删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="9">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addTradingassets()" class="myBtn"><em>新增</em></a>
		</div>
		${Account.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteTradingassets(tradingAssetsId)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Tradingassets/deleteTradingassets.do";
				$.post(url,{tradingAssetsId:tradingAssetsId},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");	
					}
				});
			}
		}
		
		function addTradingassets(){
			var dg = new $.dialog({
				title:'新增资产信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Tradingassets/getTradingassets.do?tradingAssetsId=0'
				});
    		dg.ShowDialog();
		}
		
		function updateTradingassets(tradingAssetsId){
			var dg = new $.dialog({
				title:'修改资产信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Tradingassets/getTradingassets.do?tradingAssetsId='+tradingAssetsId
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>