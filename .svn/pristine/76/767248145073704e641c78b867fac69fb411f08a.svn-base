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
	<form action="/Home/SurroundingInfo/AddorUpdateSurroundingInfo.do" name="InfoForm" id="InfoForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">		
		
		<tr class="info">
			<th>项目id:</th>
			<td><input type="text" name="projectId" value="${surroundingInfo.projectId}" class="input_txt"/>
			<input type="hidden" name="id" value="${surroundingInfo.id}">
			</td>
			
		</tr>
		<tr class="info">
			<th>类型:</th>
			<td><input type="text" name="style" value="${surroundingInfo.style}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>名称:</th>
			<td><input type="text" name="name" value="${surroundingInfo.name}" class="input_txt"/></td>
		</tr>
		
		<tr class="info">
			<th>地址:</th>
			<td><input type="text" name="address" value="${surroundingInfo.address}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>联系方式:</th>
			<td><input type="text" name="contactInformation" value="${surroundingInfo.contactInformation}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>照片:</th>
			<td><input type="text" name="phonto" value="${surroundingInfo.phonto}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>网站地址:</th>
			<td><input type="text" name="website" value="${surroundingInfo.website}" class="input_txt"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#InfoForm").submit();
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