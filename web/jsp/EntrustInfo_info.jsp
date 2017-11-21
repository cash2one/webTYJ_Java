<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>委托信息</title>
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
	<form action="/Home/EntrustInfo/AddOrUpdateEntrustInfo.do" name="EntrustInfoForm" id="EntrustInfoForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>资产装修信息：</th>
			<td>
				<select name="assetsDecorateId">
					<option value="0">请选择</option>
					<c:forEach var="a" items="${assetdecorates}">
						<option <c:if test="${a.assetsDecorateId==EntrustInfo.assetdecorate.assetsDecorateId}">selected="selected"</c:if> value="${a.assetsDecorateId}">${a.assetsDecorateId}</option>
					</c:forEach>
				</select>
				<input type="hidden" name="entrustId" value="${EntrustInfo.entrustId}">
			</td>
		</tr>
		<tr class="info">
			<th>客户信息</th>
			<td>
				<select name="custId">
					<option value="0">请选择</option>
					<c:forEach var="c" items="${personCusts}">
						<option <c:if test="${c.custId==EntrustInfo.personCust.custId}">selected="selected"</c:if> value="${c.custId}">${c.custCode}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>委托编号:</th>
			<td><input type="text" name="entrustNum" value="${EntrustInfo.entrustNum}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>委托日期:</th>
			<td><input type="text" name="entrustDate" onclick="WdatePicker()" value="<fmt:formatDate value="${EntrustInfo.entrustDate }"/>"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>委托人姓名:</th>
			<td><input type="text" name="entrusterName" value="${EntrustInfo.entrusterName}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>委托人电话:</th>
			<td><input type="text" name="entrusterTelephone" class="input_txt" value="${EntrustInfo.entrusterTelephone }"/></td>
		</tr>
		<tr class="info">
			<th>委托人证件类型:</th>
			<td>
				<select name="entrusterCardType">
					<option <c:if test="${EntrustInfo.entrusterCardType==1}">selected="selected"</c:if> value="0">身份证</option>
					<option <c:if test="${EntrustInfo.entrusterCardType==2}">selected="selected"</c:if> value="1">护照</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>委托人证件号码:</th>
			<td><input type="text" name="entrusterCardNum" class="input_txt" value="${EntrustInfo.entrusterCardNum }"/></td>
		</tr>
		<tr class="info">
			<th>业务类型:</th>
			<td>
			<select name="vocationalType">
				<option <c:if test="${EntrustInfo.vocationalType==1}">selected="selected"</c:if> value="0">装修业务</option>
				<option <c:if test="${EntrustInfo.vocationalType==2}">selected="selected"</c:if> value="1">装修业务1</option>
			</select></td>
		</tr>
		<tr class="info">
			<th>被委托人姓名:</th>
			<td><input type="text" name="entrustedName" class="input_txt" value="${EntrustInfo.entrustedName }"/></td>
		</tr>
		<tr class="info">
			<th>被委托人电话:</th>
			<td><input type="text" name="entrustEdTelephone" class="input_txt" value="${EntrustInfo.entrustEdTelephone }"/></td>
		</tr>
		<tr class="info">
			<th>被委托人证件类型:</th>
			<td>
			<select name="entrustedCardType">
				<option <c:if test="${EntrustInfo.entrustedCardType==1}">selected="selected"</c:if> value="0">身份证</option>
				<option <c:if test="${EntrustInfo.entrustedCardType==2}">selected="selected"</c:if> value="1">护照</option>
			</select></td>
		</tr>
		<tr class="info">
			<th>被委托人证件号码:</th>
			<td><input type="text" name="entrustedCardNum" class="input_txt" value="${EntrustInfo.entrustedCardNum }"/></td>
		</tr>
		<tr class="info">
			<th>证件描述（附件）:</th>
			<td><input type="text" name="cardDescribe" value="${EntrustInfo.cardDescribe }" class="input_txt"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#EntrustInfoForm").submit();
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
			alert("操作失败");
		}
	</script>
</body>
</html>