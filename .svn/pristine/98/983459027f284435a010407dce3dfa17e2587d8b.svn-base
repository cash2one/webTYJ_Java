<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>追加工单</title>
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
	<form action="/Home/Addwo/AddOrUpdateAddwo.do" name="AddwoForm" id="AddwoForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>服务请求编号：</th>
			<td>
				<select name="sraSrId">
					<option value="0">请选择</option>
					<c:forEach var="i" items="${InteriorServes}">
						<option <c:if test="${i.interiorServeId==Addwo.interiorServe.interiorServeId}">selected="selected"</c:if> value="${i.interiorServeId}">${i.interiorServeId}</option>
					</c:forEach>
				</select>
				<input type="hidden" name="addCdId" value="${Addwo.addCdId}">
			</td>
		</tr>
		<tr class="info">
			<th>原工单编号：</th>
			<td>
				<select name="custId">
					<option value="0">请选择</option>
					<c:forEach var="o" items="${Orders}">
						<option <c:if test="${o.workOrderId==Addwo.order.workOrderId}">selected="selected"</c:if> value="${o.workOrderId}">${o.workOrderId}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>工单来源:</th>
			<td><input type="text" name="wcTypeCd" value="${Addwo.wcTypeCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>工单类型:</th>
			<td><input type="text" name="todoCd" value="${Addwo.todoCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>分类:</th>
			<td><input type="text" name="subtypeCd" value="${Addwo.subtypeCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>专业/1级部件:</th>
			<td><input type="text" name="calTypeCd" value="${Addwo.calTypeCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>2级部件:</th>
			<td><input type="text" name="objectiveCd" value="${Addwo.objectiveCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>异常状态(现象):</th>
			<td><input type="text" name="prSymptomCd" value="${Addwo.prSymptomCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>是否保内:</th>
			<td><input type="text" name="billableFlg" value="${Addwo.billableFlg}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>负责人:</th>
			<td><input type="text" name="owner" value="${Addwo.owner}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>负责人工号:</th>
			<td><input type="text" name="ownerNum" value="${Addwo.ownerNum}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>任务描述:</th>
			<td><input type="text" name="commentsLong" value="${Addwo.commentsLong}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>服务描述/不接受工单描述:</th>
			<td><input type="text" name="emailBccLine" value="${Addwo.emailBccLine}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>派单时间:</th>
			<td><input type="text" name="created" value="${Addwo.created}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>工单状态:</th>
			<td><input type="text" name="evtStatCd" value="${Addwo.evtStatCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>优先级:</th>
			<td><input type="text" name="evtPriorityCd" value="${Addwo.evtPriorityCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>是否委外:</th>
			<td><input type="text" name="recreateRcptFlg" value="${Addwo.recreateRcptFlg}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>是否抢单:</th>
			<td><input type="text" name="recptReqFlg" value="${Addwo.recptReqFlg}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>客户满意度:</th>
			<td><input type="text" name="refNum" value="${Addwo.refNum}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>客户确认:</th>
			<td><input type="text" name="paperSignFlg" value="${Addwo.paperSignFlg}" class="input_txt"/></td>
		</tr><tr class="info">
			<th>结算总额:</th>
			<td><input type="text" name="ttlExpAmt" value="${Addwo.ttlExpAmt}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>处理人:</th>
			<td><input type="text" name="processerName" value="${Addwo.processerName}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>处理人工号:</th>
			<td><input type="text" name="processerNum" value="${Addwo.processerNum}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>备注:</th>
			<td><input type="text" name="emailToLine" value="${Addwo.emailToLine}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>开始时间/处理时间:</th>
			<td><input type="text" name="todoPlanStartDt" value="${Addwo.todoPlanStartDt}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>完成时间:</th>
			<td><input type="text" name="todoPlanEndDt" value="${Addwo.todoPlanEndDt}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>预约时间(指定处理时间):</th>
			<td><input type="text" name="todoDueDt" value="${Addwo.todoDueDt}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>完成标志:</th>
			<td><input type="text" name="doneFlg" value="${Addwo.doneFlg}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>二维码:</th>
			<td><input type="text" name="rplyPhNum" value="${Addwo.rplyPhNum}" class="input_txt"/></td>
		</tr><tr class="info">
			<th>重大事项标志:</th>
			<td><input type="text" name="mandatoryFlg" value="${Addwo.mandatoryFlg}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>相关工单号:</th>
			<td><input type="text" name="parEvtId" value="${Addwo.parEvtId}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>收费描述:</th>
			<td><input type="text" name="comments" value="${Addwo.comments}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>有效投诉:</th>
			<td><input type="text" name="creditActCd" value="${Addwo.creditActCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>投诉来源:</th>
			<td><input type="text" name="complainTypeCd" value="${Addwo.complainTypeCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>投诉类型:</th>
			<td><input type="text" name="complainSubtypeCd" value="${Addwo.complainSubtypeCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>投诉状态:</th>
			<td><input type="text" name="complainStatCd" value="${Addwo.complainStatCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>投诉事情:</th>
			<td><input type="text" name="complainCommentsLong" value="${Addwo.complainCommentsLong}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>投诉对象:</th>
			<td><input type="text" name="compTargetName" value="${Addwo.compTargetName}" class="input_txt"/></td>
		</tr><tr class="info">
			<th>投诉对象工号:</th>
			<td><input type="text" name="compTargetNum" value="${Addwo.compTargetNum}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>投诉时间:</th>
			<td><input type="text" name="compTodoPlanStartDt" value="${Addwo.compTodoPlanStartDt}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>处理时间:</th>
			<td><input type="text" name="compTodoPlanEndDt" value="${Addwo.compTodoPlanEndDt}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>处理描述(事务助理):</th>
			<td><input type="text" name="compEmailBccLine" value="${Addwo.compEmailBccLine}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>投诉表扬处理结果(行政部):</th>
			<td><input type="text" name="emailCcLine" value="${Addwo.emailCcLine}" class="input_txt"/></td>
		</tr>
		</table>
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