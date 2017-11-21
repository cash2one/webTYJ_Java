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
	<form action="/Home/Linkman/AddOrUpdateLinkman.do" name="LinkmanForm" id="LinkmanForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>客户id:</th>
			<td>
			<input type="hidden" name="linkmanId" value="${Linkman.linkmanId}">
			<select name="custId">
					<option value="0">请选择</option>
					<c:forEach var="p" items="${PersonCusts}">
						<option <c:if test="${p.custId==Linkman.personCust.custId}">selected="selected"</c:if> value="${p.custId}">${p.custId}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		
		<tr class="info">
			<th>姓名:</th>
			<input type="text" name="linkmanName" value="${Linkman.linkmanName}" class="input_txt"/>
		</tr>
		
		<tr class="info">
			<th>电话:</th>
			<td><input type="text" name="phone" value="${Linkman.phone}" class="input_txt"/></td>
		</tr>
		
		<tr class="info">
			<th>地址:</th>
			<td><input type="text" name="location" value="${Linkman.location}" class="input_txt"/></td>
		</tr>
		
		<tr class="info">
			<th>联系人类型:</th>
			<td>
			<select name="type">
					<option <c:if test="${Linkman.type==1}">selected="selected"</c:if> value="内部联系人">内部联系人</option>
					<option <c:if test="${Linkman.type==2}">selected="selected"</c:if> value="客户">客户</option>
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
				$("#LinkmanForm").submit();
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