<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保修处理</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<link rel="stylesheet" type="text/css" href="../js/lib/EasyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../js/lib/EasyUI/themes/icon.css">
<style type="text/css">
body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:180px;color: #4f4f4f;padding-top:40px;font-size: 13px;}
.info td{text-align:left;padding-right: 60px;padding-top:40px;}
</style>
<script type="text/javascript" src="../js/lib/jquery/jquery-1.5.1.min.js"></script>
</head>
<body>
	<form action="/Home/Repairprocess/AddRepairprocess.do" name="OrderTypeForm" id="OrderTypeForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<td>资产编号</td>
			<td><input type="text" name="assetNumber"/> </td>
		</tr>
		<tr class="info">
			<td>位置编号</td>
			<td><input type="text" name="assetNumber"/></td>
		</tr>
		<tr class="info">
			<td>服务合同</td>
			<td><input type="text" name="serviceContract"/></td>
		</tr>
		<tr class="info">
			<td>是否保内</td>
			<td>
				<select name="paoneOrNot">
					<option value="0">是</option>
					<option value="1">否</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<td>是否专项</td>
			<td>
				<select name="specialOrNot">
					<option value="0">是</option>
					<option value="1">否</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<td>缺损描述</td>
			<td><input type="text" name="defectDescription"/></td>
		</tr>
		<tr class="info">
			<td>备注</td>
			<td><input type="text" name="remark"/></td>
		</tr>
		<tr class="info">
			<td colspan="2"><input type="submit" value="提交"/> </td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
</body>
</html>