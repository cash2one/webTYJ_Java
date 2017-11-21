<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工单附件</title>
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
	<form action="/Home/OrderAttachment/AddOrUpdateOrderAttachment.do" name="OrderAttachmentForm" id="OrderAttachmentForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>工单：</th>
			<td>
				<select name="workOrderId">
					<option value="0">请选择</option>
					<c:forEach var="o" items="${Orders}">
						<option <c:if test="${o.workOrderId==OrderAttachment.order.workOrderId}">selected="selected"</c:if> value="${o.workOrderId}">${o.workOrderId}</option>
					</c:forEach>
				</select>
				<input type="hidden" name="orderAttachmentId" value="${OrderAttachment.orderAttachmentId}">
			</td>
		</tr>
		<tr class="info">
			<th>文件名称:</th>
			<td><input type="text" name="fileName" value="${OrderAttachment.fileName}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>附件类型:</th>
			<td><input type="text" name="fileSrcType" value="${OrderAttachment.fileSrcType}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>文件类型:</th>
			<td><input type="text" name="dbLastUpdSrc" value="${OrderAttachment.dbLastUpdSrc}"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>文件状态:</th>
			<td>
				<select name="publishCd">
					<option <c:if test="${OrderAttachment.publishCd==0}">selected="selected"</c:if> value="0">只读</option>
					<option <c:if test="${OrderAttachment.publishCd==1}">selected="selected"</c:if> value="1">损坏</option>
					<option <c:if test="${OrderAttachment.publishCd==2}">selected="selected"</c:if> value="2">管理员权限</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>已入档:</th>
			<td><input type="radio" name="fileDockStatFlg" style="width: 10px;" checked="checked" class="input_txt" value="0"/>是
				<input type="radio" name="fileDockStatFlg" style="width: 10px;" <c:if test="${OrderDeferred.fileDockStatFlg==1}">checked="checked"</c:if> class="input_txt" value="1"/>否
			</td>
		</tr>
		<tr class="info">
			<th>文件版本:</th>
			<td><input type="text" name="fileRevNum" class="input_txt" value="${OrderAttachment.fileRevNum }"/></td>
		</tr>
		<tr class="info">
			<th>文件日期:</th>
			<td><input type="text" name="fileDate" onclick="WdatePicker()" value="<fmt:formatDate value="${OrderAttachment.fileDate }" pattern="yyyy-MM-dd" />" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>备注:</th>
			<td><input type="text" name="comments" class="input_txt" value="${OrderAttachment.comments }" /></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#OrderAttachmentForm").submit();
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