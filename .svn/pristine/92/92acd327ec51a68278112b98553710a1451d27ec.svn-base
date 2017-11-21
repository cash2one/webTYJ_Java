<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工单延迟日期申请信息</title>
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
	<form action="/Home/OrderDeferred/AddOrUpdateOrderDeferred.do" name="OrderDeferredForm" id="OrderDeferredForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>工单：</th>
			<td>${Order.workOrderId}
				<input type="hidden" name="workOrderId" value="${Order.workOrderId}"/>
				<input type="hidden" name="ownerName" value="${Order.processerName}"/>
				<input type="hidden" name="ownerNum" value="${Order.processerNum}"/>
			</td>
		</tr>
		<tr class="info">
			<th>工单状态：</th>
			<td>${Order.evtStatCd}</td>
		</tr>
		<tr class="info">
			<th>工单类型：</th>
			<td>${Order.orderType.orderTypeType}</td>
		</tr>
		<tr class="info">
			<th>分类：</th>
			<td>${Order.classify}</td>
		</tr>
		<tr class="info">
			<th>专业：</th>
			<td>${Order.calTypeCd}</td>
		</tr>
		<tr class="info">
			<th>任务描述：</th>
			<td>${Order.commentsLong}</td>
		</tr>
		<tr class="info">
			<th>希望延长时间:</th>
			<td><input type="text" name="cemTotalTime" value="${OrderDeferred.cemTotalTime}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>延长原因描述:</th>
			<td><input type="text" name="descText" value="${OrderDeferred.descText}" class="input_txt"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#OrderDeferredForm").submit();
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