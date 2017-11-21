<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Test</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<link rel="stylesheet" type="text/css" href="../js/lib/EasyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../js/lib/EasyUI/themes/icon.css">
<style type="text/css">
body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:180px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;padding-left: 20px}
</style>
<script type="text/javascript" src="../js/lib/jquery/jquery-1.5.1.min.js"></script>
</head>
<body>
	<form action="/Home/Carclaiminfo/AddOrUpdateCarclaiminfo.do" name="CarclaiminfoForm" id="CarclaiminfoForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>车辆id:</th>
			<td>
			<input type="hidden" name="carClaimid" value="${Carclaiminfo.carClaimid}">
			<select name="carId" id="carInfo.carId" class="input_txt">
						<option value="">请选择</option>
						<c:forEach items="${carInfos}" var="p">
							<option <c:if test="${p.carId==Carclaiminfo.carInfo.carId}">selected="selected"</c:if> value="${p.carId }">${p.carId }</option>
						</c:forEach>
				</select>
		</td>
		</tr>
		<tr class="info">
			<th>保险单号:</th>
			<td><input type="text" name="insuranceOrder" value="${Carclaiminfo.insuranceOrder}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>出险日期:</th>
			<td><input type="text" name="dangerDate" onclick="WdatePicker()" value="<fmt:formatDate value="${Carclaiminfo.dangerDate }"/>"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>理赔类型:</th>
			<td>
				<select name="cardType">
					<option <c:if test="${Carclaiminfo.claimType==1}">selected="selected"</c:if> value="1">车损险</option>
					<option <c:if test="${Carclaiminfo.claimType==2}">selected="selected"</c:if> value="2">盗抢险</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>理赔险种:</th>
			<td>
				<select name="claimKind">
					<option <c:if test="${Carclaiminfo.claimKind==1}">selected="selected"</c:if> value="1">交强险</option>
					<option <c:if test="${Carclaiminfo.claimKind==2}">selected="selected"</c:if> value="2">商业险</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>保险公司:</th>
			<td><input type="text" name="insuranceCompany" class="input_txt" value="${Carclaiminfo.insuranceCompany }"/></td>
		</tr>
		<tr class="info">
			<th>理赔金额:</th>
			<td><input type="text" name="claimAmount" class="input_txt" value="${Carclaiminfo.claimAmount }"/></td>
		</tr>
		<tr class="info">
			<th>收益人:</th>
			<td><input type="text" name="beneficiary" class="input_txt" value="${Carclaiminfo.beneficiary }"/></td>
		</tr>
		<tr class="info">
			<th>联系地址:</th>
			<td><input type="text" name="contactAddress" class="input_txt" value="${Carclaiminfo.contactAddress }"/></td>
		</tr>
		<tr class="info">
			<th>联系电话:</th>
			<td><input type="text" name="contactTelephone" class="input_txt" value="${Carclaiminfo.contactTelephone }"/></td>
		</tr>
		<tr class="info">
			<th>证件号码:</th>
			<td><input type="text" name="cardNum" class="input_txt" value="${Carclaiminfo.cardNum }"/></td>
		</tr>
		<tr class="info">
			<th>理赔状态:</th>
			<td>
				<select name="claimState">
					<option <c:if test="${Carclaiminfo.claimState==1}">selected="selected"</c:if> value="1">已赔</option>
					<option <c:if test="${Carclaiminfo.claimState==2}">selected="selected"</c:if> value="2">未赔</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>完成日期:</th>
			<td><input type="text" name="finishDate" onclick="WdatePicker()" value="<fmt:formatDate value="${Carclaiminfo.finishDate }"/>"  class="input_txt"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#CarclaiminfoForm").submit();
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