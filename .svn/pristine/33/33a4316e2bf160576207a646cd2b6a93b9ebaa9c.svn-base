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
	<form action="/Home/Enterprise/AddorUpdateEnterprise.do" name="EnterpriseForm" id="EnterpriseForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">		
		
		<tr class="info">
			<th>客户编号:</th>
			<td><input type="text" name="custcode" value="${Enterprise.custcode}" class="input_txt"/>
			<input type="hidden" name="entrustId" value="${Enterprise.enterpriseId}">
			</td>
			
		</tr>
		<tr class="info">
			<th>单位名称:</th>
			<td><input type="text" name="unitName" value="${Enterprise.unitName}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>单位属性:</th>
			<td><input type="text" name="unitAttribute" value="${Enterprise.unitAttribute}" class="input_txt"/></td>
		</tr>
		
		<tr class="info">
			<th>注册日期:</th>
			<td><input type="text" name="registTime" onclick="WdatePicker()" value="<fmt:formatDate value="${Enterprise.registTime }"/>"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>注册地址:</th>
			<td><input type="text" name="registAddress" value="${Enterprise.registAddress}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>营业执照:</th>
			<td><input type="text" name="businessLicense" value="${Enterprise.businessLicense}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>委法人代表:</th>
			<td><input type="text" name="represent" class="input_txt" value="${Enterprise.represent }"/></td>
		</tr>
		<tr class="info">
			<th>证件类型:</th>
			<td>
				<select name="cardType">
					<option <c:if test="${Enterprise.cardType==1}">selected="selected"</c:if> value="1">身份证</option>
					<option <c:if test="${Enterprise.cardType==2}">selected="selected"</c:if> value="2">护照</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>证件号码:</th>
			<td><input type="text" name="cardNum" class="input_txt" value="${Enterprise.cardNum }"/></td>
		</tr>
		<tr class="info">
			<th>单位地址:</th>
			<td><input type="text" name="unitAddress" class="input_txt" value="${Enterprise.unitAddress }"/></td>
		</tr>
		<tr class="info">
			<th>企业类型:</th>
			<td>
			<select name="enterpriseType">
				<option <c:if test="${Enterprise.enterpriseType==1}">selected="selected"</c:if> value="1">国企</option>
				<option <c:if test="${Enterprise.enterpriseType==2}">selected="selected"</c:if> value="2">私企</option>
			</select></td>
		</tr>
		<tr class="info">
			<th>单位委托人:</th>
			<td><input type="text" name="unitPrincipal" class="input_txt" value="${Enterprise.unitPrincipal }"/></td>
		</tr>
	
		<tr class="info">
			<th>经营类型:</th>
			<td>
			<select name="businessType">
				<option <c:if test="${Enterprise.businessType==1}">selected="selected"</c:if> value="1">医药</option>
				<option <c:if test="${Enterprise.businessType==2}">selected="selected"</c:if> value="2">软件</option>
			</select></td>
		</tr>
		<tr class="info">
			<th>税务登记号:</th>
			<td><input type="text" name="taxReg" class="input_txt" value="${Enterprise.taxReg }"/></td>
		</tr>
		
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#EnterpriseForm").submit();
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