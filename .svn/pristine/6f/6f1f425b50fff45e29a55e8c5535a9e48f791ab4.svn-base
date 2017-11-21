<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>催办</title>
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
<script type="text/javascript" src="../js/lib/jquery-1.5.1.min.js"></script>
</head>
<body>
	<form action="/Home/listur/AddListurgeder.do" name="AddwoForm" id="AddwoForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>工单id：</th>
			<td>
				<input type="text" class="input_txt" value="${order.workOrderId}"  readonly="readonly"  name="workOrderId"/>
			</td>
		</tr>
		<tr class="info">
			<th>状态：</th>
			<td>
				<input type="text" class="input_txt"  readonly="readonly"   value="${order.evtStatCd}"/>
			</td>
		</tr>
		<tr class="info">
			<th>工单类型:</th>
			<td><input type="text"   value="${order.orderType.orderTypeType}" readonly="readonly"   class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>分类:</th>
			<td><input type="text"value="${orders.classify}" readonly="readonly"   class="input_txt"/></td>
		</tr>
		<tr>
			<th>专业：</th>
			<td><input type="text"   value="${orders.calTypeCd}" readonly="readonly"   class="input_txt"/></td>
		</tr>
		<tr>
			<th>任务描述：</th>
			<td><input type="text"  value="${orders.commentsLong}" readonly="readonly"   class="input_txt"/></td>
		</tr>
		<tr>
			<th>催办描述：</th>
			<td><input type="text" name="descText"  class="input_txt"/></td>
		</tr>
		</table>
	
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','提交',function(){
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