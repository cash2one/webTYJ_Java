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
	<form action="/Home/Assetmanage/AddorUpdateAssetmanage.do" name="assetmanageForm" id="Form" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">							
		<tr class="info">
			<th>客户id:</th>
			<td>
			<input type="hidden" name="assetsManagemenid" value="${assetmanage.assetsManagemenid}">
			<select name="custId" id="personCust.custId" class="input_txt">
						<option value="">请选择</option>
						<c:forEach items="${personCusts}" var="p">
							<option <c:if test="${p.custId==assetmanage.personCust.custId}">selected="selected"</c:if> value="${p.custId }">${p.custId }</option>
						</c:forEach>
				</select>
		</td>
		</tr>
		<tr class="info">
			<th>经营项目:</th>
			<td><input type="text" name="manageProject" id="manageProject" class="input_txt" value="${assetmanage.manageProject }"/></td>
		</tr>
		<tr class="info">
			<th>经营名称:</th>
			<td><input type="text" name="manageName" id="manageName" class="input_txt" value="${assetmanage.manageName }"/></td>
		</tr>
		<tr class="info">
			<th>注册日期:</th>
			<td><input type="text" name="regeditDate" id="regeditDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${assetmanage.regeditDate }" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>注册地址:</th>
			<td><input type="text" name="regeditAddress" id="regeditAddress" class="input_txt" value="${assetmanage.regeditAddress }"/></td>
		</tr>
		<tr class="info">
			<th>营业执照:</th>
			<td><input type="text" name="instructions" id="instructions" class="input_txt" value="${assetmanage.instructions }"/></td>
		</tr>
		<tr class="info">
			<th>消防审批:</th>
			<td><input type="text" name="approval" id="approval" class="input_txt" value="${assetmanage.approval}" /></td>
		</tr>
		<tr class="info">
			<th>法人代表:</th>
			<td><input type="text" name="corporateRepresentative" id="corporateRepresentative" class="input_txt" onclick="WdatePicker()" value="${assetmanage.corporateRepresentative}" /></td>
		</tr>
		<tr class="info">
			<th>联系人:</th>
			<td><input type="text" name="contacts" id="contacts" class="input_txt" value="${assetmanage.contacts}"/></td>
		</tr>
		<tr class="info">
			<th>联系电话:</th>
			<td><input type="text" name="contactsTelephone" id="contactsTelephone" class="input_txt"  value="${assetmanage.contactsTelephone}"/></td>
		</tr>
		<tr class="info">
			<th>联系地址:</th>
			<td><input type="text" name="contactsAddress" id="contactsAddress" class="input_txt"  value="${assetmanage.contactsAddress}" /></td>
		</tr>
		<tr class="info">
			<th>开始日期:</th>
			<td><input type="text" name="startDate" id="startDate" class="input_txt"  value="${assetmanage.startDate}" /></td>
		</tr>
		<tr class="info">
			<th>经营状态:</th>
			<td><input type="text" name="manageState" id="manageState" class="input_txt" value="${assetmanage.manageState}"/></td>
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