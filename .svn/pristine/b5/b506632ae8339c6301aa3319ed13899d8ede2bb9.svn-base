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
	<form action="/Home/Staff/AddorUpdateStaff.do" name="StaffForm" id="StaffForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">		
		<tr class="info">
			<th>公司id:</th>
			<td><input type="text" name="companyId" value="${staff.companyId}" class="input_txt"/></td>
			<td><input type="hidden" name="staffId" value="${staff.staffId}" class="input_txt"/>
		</tr>
		<tr class="info">
			<th>员工号:</th>
			<td><input type="text" name="staffNumber" value="${staff.staffNumber}" class="input_txt"/></td>
		</tr>
		
		<tr class="info">
			<th>姓氏:</th>
			<td><input type="text" name="firstName" value="${staff.firstName}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>名字:</th>
			<td><input type="text" name="lastName" value="${staff.lastName}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>姓氏拼音:</th>
			<td><input type="text" name="firstNameSpell" value="${staff.firstNameSpell}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>性别:</th>
			<td><input type="text" name="sex" value="${staff.sex}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>籍贯:</th>
			<td><input type="text" name="nativePlace" value="${staff.nativePlace}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>婚否:</th>
			<td><input type="text" name="married" value="${staff.married}" class="input_txt"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#StaffForm").submit();
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