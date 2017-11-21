<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Test</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<style type="text/css">
body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:80px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;}
</style>
</head>
<body>
	<form action="/Home/Tradingassets/AddorUpdateTradingassets.do" name="tradingassetsForm" id="Form" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">							
		<tr class="info">
			<th>车位ID:</th>
			<td>
			<input type="hidden" name="tradingAssetsId" value="${tradingassets.tradingAssetsId}">
			<select name="stallId" id="stall.stallId" class="input_txt">
						<option value="">请选择</option>
						<c:forEach items="${stalls}" var="p">
							<option <c:if test="${p.stallId==tradingassets.stall.stallId}">selected="selected"</c:if> value="${p.stallId }">${p.stallId }</option>
						</c:forEach>
				</select>
		</td>
		</tr>
		<tr class="info">
			<th>合同ID:</th>
			<td><input type="text" name="contractId" id="contractId" class="input_txt" value="${tradingassets.contractId }"/></td>
		</tr>
		<tr class="info">
			<th>房产证号:</th>
			<td><input type="text" name="houseCredentialsNum" id="houseCredentialsNum" class="input_txt" value="${tradingassets.houseCredentialsNum }"/></td>
		</tr>
		<tr class="info">
			<th>认购日期:</th>
			<td><input type="text" name="subscribeDate" id="subscribeDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${tradingassets.subscribeDate}" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>签约日期:</th>
			<td><input type="text" name="signContractDate" id="signContractDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${tradingassets.signContractDate}" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>登记价:</th>
			<td><input type="text" name="registrationPrice" id="registrationPrice" class="input_txt" value="${tradingassets.registrationPrice }"/></td>
		</tr>
		<tr class="info">
			<th>房屋折后实价:</th>
			<td><input type="text" name="houseFoldingPrice" id="houseFoldingPrice" class="input_txt" value="${tradingassets.houseFoldingPrice }"/></td>
		</tr>
		<tr class="info">
			<th>建筑面积单价:</th>
			<td><input type="text" name="coveredAreaUnitprice" id="coveredAreaUnitprice" class="input_txt" value="${tradingassets.coveredAreaUnitprice }"/></td>
		</tr>
		<tr class="info">
			<th>套内面积单价:</th>
			<td><input type="text" name="unitAreaPrice" id="unitAreaPrice" class="input_txt" value="${tradingassets.unitAreaPrice }"/></td>
		</tr>
		<tr class="info">
			<th>交易类型:</th>
			<td><input type="text" name="businessType" id="businessType" class="input_txt" value="${tradingassets.businessType }"/></td>
		</tr>
		<tr class="info">
			<th>付款方式:</th>
			<td><input type="text" name="paymentType" id="paymentType" class="input_txt" value="${tradingassets.paymentType }"/></td>
		</tr>
		<tr class="info">
			<th>首付金额:</th>
			<td><input type="text" name="firstPaymentMoney" id="firstPaymentMoney" class="input_txt" value="${tradingassets.firstPaymentMoney }"/></td>
		</tr>
		<tr class="info">
			<th>按揭金额:</th>
			<td><input type="text" name="mortgageMoney" id="mortgageMoney" class="input_txt" value="${tradingassets.mortgageMoney }"/></td>
		</tr>
		<tr class="info">
			<th>产权类型:</th>
			<td><input type="text" name="propertyRightType" id="propertyRightType" class="input_txt" value="${tradingassets.propertyRightType }"/></td>
		</tr>
	</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		var dg;
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				
				$("#Form").submit();
			});
		});
		
		function success(){
			if(dg.curWin.document.forms[0]){
				dg.curWin.document.forms[0].action = dg.curWin.location+"";
				dg.curWin.document.forms[0].submit();
			}else{
				dg.curWin.location.reload();
			}
			dg.cancel();
		}
		
		function failed(){
			alert("新增失败");
		}
	</script>
</body>
</html>