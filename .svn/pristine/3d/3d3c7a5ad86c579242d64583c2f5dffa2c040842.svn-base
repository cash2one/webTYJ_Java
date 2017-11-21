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
	<form action="/Home/Assetrent/AddorUpdateAssetrent.do" name="assetrentForm" id="Form" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">							
		<tr class="info">
			<th>出租人id:</th>
			<td><input type="hidden" name="capitalLeaseId" value="${assetrent.capitalLeaseId}">
			<input type="text" name="hireId" id="hireId" class="applyDate"  value="${assetrent.hireId }" /></td>
		</tr>
		<tr class="info">
			<th>承租人id:</th>
			<td><input type="text" name="lesseeId" id="lesseeId" class="input_txt"  value="${assetrent.lesseeId }" /></td>
		</tr>
		<tr class="info">
			<th>出租开始日期:</th>
			<td><input type="text" name="hireStartDate" id="hireStartDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${assetrent.hireStartDate }" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>出租结束日期:</th>
			<td><input type="text" name="hireFinishDate" id="hireFinishDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${assetrent.hireFinishDate }" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>合同号:</th>
			<td><input type="text" name="contractNumber" id="contractNumber" class="input_txt" value="${assetrent.contractNumber }"/></td>
		</tr>
		<tr class="info">
			<th>出租价格:</th>
			<td><input type="text" name="hirePrice" id="hirePrice" class="input_txt" value="${assetrent.hirePrice}" /></td>
		</tr>
		<tr class="info">
			<th>是否递增:</th>
			<td><input type="text" name="increaseed" id="increaseed" class="input_txt"  value="${assetrent.increaseed}" /></td>
		</tr>
		<tr class="info">
			<th>递增类型:</th>
			<td><input type="text" name="increaseType" id="increaseType" class="input_txt" value="${assetrent.increaseType}" /></td>
		</tr>
		<tr class="info">
			<th>计费日期:</th>
			<td><input type="text" name="chargingDate" id="chargingDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${assetrent.chargingDate }" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>交费截止日期:</th>
			<td><input type="text" name="paymentCloseDate" id="paymentCloseDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${assetrent.paymentCloseDate }" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>收账账号:</th>
			<td><input type="text" name="receiveAccount" id="receiveAccount" class="input_txt"  value="${assetrent.receiveAccount}" /></td>
		</tr>
		<tr class="info">
			<th>免租开始时间:</th>
			<td><input type="text" name="freeHireStartDate" id="freeHireStartDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${assetrent.freeHireStartDate }" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>免租结束时间:</th>
			<td><input type="text" name="freeFinishEndDate" id="freeFinishEndDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${assetrent.freeFinishEndDate }" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
	</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/jquery-1.5.1.min.js"></script>
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