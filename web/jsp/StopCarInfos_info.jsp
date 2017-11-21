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
	<form action="/Home/StopCarInfo/AddorUpdateStopCarInfo.do" name="StopCarInfoForm" id="StopCarInfoForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">		
		
		<tr class="info">
			<th>车牌号码:</th>
			<td><input type="text" name="carId" value="${stopcarinfo.carId}" class="input_txt"/>
			<input type="hidden" name="stopCarId" value="${stopcarinfo.stopCarId}">
			</td>
			
		</tr>
		<tr class="info">
			<th>车位id:</th>
			<td><input type="text" name="stallId" value="${stopcarinfo.stallId}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>车位类型:</th>
			<td><input type="text" name="stallStyle" value="${stopcarinfo.stallStyle}" class="input_txt"/></td>
		</tr>
		
		<tr class="info">
			<th>停车状态:</th>
			<td>
				<select name="stopState">
					<option <c:if test="${stopcarinfo.stopState==1}">selected="selected"</c:if> value="1">已占有</option>
					<option <c:if test="${stopcarinfo.stopState==2}">selected="selected"</c:if> value="2">未占有</option>
				</select>
			</td>
			</tr>		
		<tr class="info">
			<th>开始日期:</th>
			<td><input type="text" name="startDate" onclick="WdatePicker()" value="<fmt:formatDate value="${stopcarinfo.startDate}"/>"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>结束日期:</th>
			<td><input type="text" name="endDate" onclick="WdatePicker()" value="<fmt:formatDate value="${stopcarinfo.endDate}"/>"  class="input_txt"/></td>
		</tr>
		
				
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#StopCarInfoForm").submit();
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