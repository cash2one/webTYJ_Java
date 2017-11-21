<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加维修</title>
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
	<form action="/Home/Maintain/addMaintain.do" name="AddwoForm" id="AddwoForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>原设备号：</th>
			<td>
				<input type="text" class="input_txt" name="primaryEquipmentId"/>
			</td>
		</tr>
		<tr class="info">
			<th>原设备读数：</th>
			<td>
				<input type="text" class="input_txt" name="primaryReading"/>
			</td>
		</tr>
		<tr class="info">
			<th>新设备号:</th>
			<td><input type="text" name="newEquipmentId"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>新设备读数:</th>
			<td><input type="text" name="newReading" value="${Addwo.todoCd}" class="input_txt"/></td>
		</tr>

		<tr>
			<th>现场情况：</th>
			<td>
				<select name="sceneCondition">
					<option value="良好">良好</option>
					<option value="一般">一般</option>
				</select>
			</td>
		</tr>
		
			<tr>
			<th>服务描述：</th>
			<td><input type="text" name="serveDescribe"  class="input_txt"/></td>
		</tr>
		</table>
	<input  type="submit" value="提交"/>
	
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#AddwoForm").submit();
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