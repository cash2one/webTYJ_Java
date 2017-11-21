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
			<td>
				<select name="workOrderId">
					<option value="0">请选择</option>
					<c:forEach var="o" items="${Orders}">
						<option <c:if test="${o.workOrderId==OrderDeferred.order.workOrderId}">selected="selected"</c:if> value="${o.workOrderId}">${o.workOrderId}</option>
					</c:forEach>
				</select>
				<input type="hidden" name="orderDeferredId" value="${OrderDeferred.orderDeferredId}">
			</td>
		</tr>
		<tr class="info">
			<th>希望延长时间:</th>
			<td><input type="text" name="cemTotalTime" value="${OrderDeferred.cemTotalTime}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>延长原因描述:</th>
			<td><input type="text" name="descText" value="${OrderDeferred.descText}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>责任人号:</th>
			<td><input type="text" name="ownerNum" value="${OrderDeferred.ownerNum}"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>责任人:</th>
			<td><input type="text" name="ownerName" value="${OrderDeferred.ownerName}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>申请状态:</th>
			<td>
				<select name="evtStatCd">
					<option <c:if test="${OrderDeferred.evtStatCd==0}">selected="selected"</c:if> value="0">申请状态</option>
					<option <c:if test="${OrderDeferred.evtStatCd==1}">selected="selected"</c:if> value="1">申请状态1</option>
					<option <c:if test="${OrderDeferred.evtStatCd==2}">selected="selected"</c:if> value="2">申请状态2</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>审批人:</th>
			<td><input type="text" name="approverName" class="input_txt" value="${OrderDeferred.approverName }"/></td>
		</tr>
		<tr class="info">
			<th>审批状态:</th>
			<td>
				<select name="approverStatCd">
					<option <c:if test="${OrderDeferred.approverStatCd==0}">selected="selected"</c:if> value="0">同意</option>
					<option <c:if test="${OrderDeferred.approverStatCd==1}">selected="selected"</c:if> value="1">拒绝</option>
					<option <c:if test="${OrderDeferred.approverStatCd==2}">selected="selected"</c:if> value="2">打回</option>
				</select>
			</td>
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