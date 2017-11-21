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
	<form action="/Home/Leave/AddOrUpdateLeave.do" name="LeaveForm" id="LeaveForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>请假人:</th>
			<td>
			<input type="hidden" name="id" id="id" value="${Leave.id}"/>
			<input type="text" name="leaveName" class="input_txt" value="${Leave.leaveName }"/></td>
		</tr>
		<tr class="info">
			<th>类型:</th>
			<td>
				<select name="leaveType">
					<option <c:if test="${Leave.leaveType==0}">selected="selected"</c:if>  value="0">迟到</option>
					<option <c:if test="${Leave.leaveType==1}">selected="selected"</c:if> value="1">早退</option>
					<option <c:if test="${Leave.leaveType==2}">selected="selected"</c:if> value="1">休假</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>原因:</th>
			<td>
				<select name="reason">
					<option <c:if test="${Leave.reason==0}">selected="selected"</c:if>  value="0">病假</option>
					<option <c:if test="${Leave.reason==1}">selected="selected"</c:if> value="1">事假</option>
					<option <c:if test="${Leave.reason==2}">selected="selected"</c:if> value="1">休假</option>
					<option <c:if test="${Leave.reason==2}">selected="selected"</c:if> value="1">其他</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>开始时间:</th>
			<td><input type="text" name="startDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${Leave.startDate}" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>结束时间:</th>
			<td><input type="text" name="endDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${Leave.endDate}" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>描述:</th>
			<td><input type="text" name="descri" class="input_txt" value="${Leave.descri }"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#LeaveForm").submit();
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