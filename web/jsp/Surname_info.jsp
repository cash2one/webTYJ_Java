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
	<form action="/Home/Surname/AddorUpdateSurname.do" name="SurnameForm" id="SurnameForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">		
		
		<tr class="info">
			<th>宗地id:</th>
			<td><input type="text" name="parceId" value="${surname.parceId}" class="input_txt"/>
			<input type="hidden" name="surnameInformationId" value="${surname.surnameInformationId}">
			</td>
			
		</tr>
		<tr class="info">
			<th>类型:</th>
			<td><input type="text" name="kind" value="${surname.kind}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>名称:</th>
			<td><input type="text" name="name" value="${surname.name}" class="input_txt"/></td>
		</tr>
		
		<tr class="info">
			<th>公建建筑面积:</th>
			<td><input type="text" name="surnameBuildErea" value="${surname.surnameBuildErea}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>临时建筑:</th>
			<td><input type="text" name="tempBuild" value="${surname.tempBuild}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>配套费用总额:</th>
			<td><input type="text" name="inclusiveFee" value="${surname.inclusiveFee}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>公建用地面积:</th>
			<td><input type="text" name="surnameLandErea" value="${surname.surnameLandErea}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>移交对象:</th>
			<td><input type="text" name="transferObject" value="${surname.transferObject}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>移交对象名称:</th>
			<td><input type="text" name="transferObjectName" value="${surname.transferObjectName}" class="input_txt"/></td>
		</tr>
		
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#SurnameForm").submit();
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