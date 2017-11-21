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
	<form action="/Home/Communicationinfo/AddOrUpdateCommunicationinfo.do" name="CommunicationinfoForm" id="CommunicationinfoForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>个人客户id:</th>
			<td>
			<input type="hidden" name="contactId" value="${Communicationinfo.contactId}">
			<select name="personId" id="personCust.custId" class="input_txt">
						<option value="">请选择</option>
						<c:forEach items="${personCusts}" var="p">
							<option <c:if test="${p.custId==Communicationinfo.personCust.custId}">selected="selected"</c:if> value="${p.custId }">${p.custId }</option>
						</c:forEach>
				</select>
		</td>
		</tr>
		<tr class="info">
			<th>国家编号:</th>
			<td><input type="text" name="countryCode" value="${Communicationinfo.countryCode}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>城市编号:</th>
			<td><input type="text" name="cityCode" value="${Communicationinfo.cityCode}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>手机号码:</th>
			<td><input type="text" name="telephoneNum" value="${Communicationinfo.telephoneNum}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>固定电话:</th>
			<td><input type="text" name="landlineNum" class="input_txt" value="${Communicationinfo.landlineNum }"/></td>
		</tr>
		<tr class="info">
			<th>分机号:</th>
			<td><input type="text" name="extensionNum" class="input_txt" value="${Communicationinfo.extensionNum }"/></td>
		</tr>
		<tr class="info">
			<th>QQ:</th>
			<td><input type="text" name="QQ" class="input_txt" value="${Communicationinfo.QQ }"/></td>
		</tr>
		<tr class="info">
			<th>电子邮箱:</th>
			<td><input type="text" name="email" class="input_txt" value="${Communicationinfo.email }"/></td>
		</tr>
		<tr class="info">
			<th>备注:</th>
			<td><input type="text" name="remark" class="input_txt" value="${Communicationinfo.remark }"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#CommunicationinfoForm").submit();
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