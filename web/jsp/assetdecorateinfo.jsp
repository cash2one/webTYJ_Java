<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Test</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<style type="text/css">
body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:80px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;}
</style>
</head>
<body>
	<form action="/Home/Assetdecorate/AddorUpdateAssetdecorate.do" name="assetdecorateForm" id="Form" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">							
		<tr class="info">
			<th>装修申请日期:</th>
			<td><input type="hidden" name="assetsDecorateId" value="${assetdecorate.assetsDecorateId}">
			<input type="text" name="applyDate" id="applyDate" class="applyDate" onclick="WdatePicker()" value="<fmt:formatDate value="${assetdecorate.applyDate }" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>装修完成日期:</th>
			<td><input type="text" name="completeDate" id="completeDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${assetdecorate.completeDate }" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>施工单位名称:</th>
			<td><input type="text" name="builderName" id="builderName" class="input_txt"  value="${assetdecorate.builderName }" /></td>
		</tr>
		<tr class="info">
			<th>设计图纸(关联附件):</th>
			<td><input type="text" name="designDrawing" id="designDrawing" class="input_txt" value="${assetdecorate.designDrawing }"/></td>
		</tr>
		<tr class="info">
			<th>装修类型:</th>
			<td><input type="text" name="decorationType" id="decorationType" class="input_txt" value="${assetdecorate.decorationType }"/></td>
		</tr>
		<tr class="info">
			<th>装修类别:</th>
			<td><input type="text" name="decorationKind" id="decorationKind" class="input_txt" value="${assetdecorate.decorationKind}" /></td>
		</tr>
		<tr class="info">
			<th>装修状态:</th>
			<td><input type="text" name="decorationState" id="decorationState" class="input_txt"  value="${assetdecorate.decorationState}" /></td>
		</tr>
		<tr class="info">
			<th>联系人:</th>
			<td><input type="text" name="contacts" id="contacts" class="input_txt" value="${assetdecorate.contacts}" /></td>
		</tr>
		<tr class="info">
			<th>联系电话:</th>
			<td><input type="text" name="contactTelephoner" id="contactTelephoner" class="input_txt" value="${assetdecorate.contactTelephoner}"/></td>
		</tr>
		<tr class="info">
			<th>联系地址:</th>
			<td><input type="text" name="contactAddress" id="contactAddress" class="input_txt"  value="${assetdecorate.contactAddress}" /></td>
		</tr>
		<tr class="info">
			<th>是否委托:</th>
			<td><input type="text" name="entrusted" id="entrusted" class="input_txt"  value="${assetdecorate.entrusted}" /></td>
		</tr>
	</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		var dg;
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				
				$("#Form").submit();
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