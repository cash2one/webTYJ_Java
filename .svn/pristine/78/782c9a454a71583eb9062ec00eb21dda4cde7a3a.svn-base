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
	<form action="/Home/Project/AddOrUpdateProject.do" name="ProjectForm" id="ProjectForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>项目编号:</th>
			<td>
			<input type="hidden" name="projectId" id="projectId" value="${Project.projectId}"/>
			<input type="text" name="projectNumber" class="input_txt" value="${Project.projectNumber }"/></td>
		</tr>
		<tr class="info">
			<th>项目名称:</th>
			<td><input type="text" name="projectName" class="input_txt" value="${Project.projectName }"/></td>
		</tr>
		<tr class="info">
			<th>公司:</th>
			<td><input type="text" name="company" class="input_txt" value="${Project.company }"/></td>
		</tr>
		<tr class="info">
			<th>概要:</th>
			<td><input type="text" name="outline" class="input_txt" value="${Project.outline }"/></td>
		</tr>
		<tr class="info">
			<th>联系电话:</th>
			<td><input type="text" name="phone" class="input_txt" value="${Project.phone }"/></td>
		</tr>
		<tr class="info">
			<th>全地址:</th>
			<td><input type="text" name="address" class="input_txt" value="${Project.address }"/></td>
		</tr>
		<tr class="info">
			<th>宗地信息:</th>
			<td><input type="text" name="parcel" class="input_txt" value="${Project.parcel }"/></td>
		</tr>
		<tr class="info">
			<th>规划信息:</th>
			<td><input type="text" name="planning" class="input_txt" value="${Project.planning }"/></td>
		</tr>
		<tr class="info">
			<th>车位总数:</th>
			<td><input type="text" name="privateStallnum" class="input_txt" value="${Project.privateStallnum }"/></td>
		</tr>
		<tr class="info">
			<th>住宅总户数:</th>
			<td><input type="text" name="houseTotalnum" class="input_txt" value="${Project.houseTotalnum }"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#ProjectForm").submit();
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