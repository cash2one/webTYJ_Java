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
	<form action="/Home/familypersoninfo/AddorUpdateFamilypersoninfo.do" name="familypersoninfosForm" id="familypersoninfosForm" target="result" method="post">
		<input type="hidden" name="id" id="id" value="${familypersoninfo.id }"/>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>客户编号:</th>
			<td><input type="text" name="custcode" id="custcode" class="input_txt" value="${familypersoninfo.custcode }" /></td>
		</tr>		
		<tr class="info">
			<th>家庭成员编号:</th>
			<td><input type="text" name="familycode" id="familycode" class="input_txt" value="${familypersoninfo.familycode }" /></td>
		</tr>
		<tr class="info">
			<th>关系类型:</th>
			<td><input type="text" name="relationshiptype" id="relationshiptype" class="input_txt" value="${familypersoninfo.relationshiptype }"/></td>
		</tr>
		<tr class="info">
			<th>证件类型:</th>
			<td><input type="text" name="cardtype" id="cardtype" class="input_txt" value="${familypersoninfo.cardtype }"/></td>
		</tr>
		<tr class="info">
			<th>证件号码:</th>
			<td><input type="text" name="cardnum" id="cardnum" class="input_txt" value="${familypersoninfo.cardnum }"/></td>
		</tr>
		<tr class="info">
			<th>性别:</th>
			<td><input type="text" name="sex" id="sex" class="input_txt" value="${familypersoninfo.sex }"/></td>
		</tr>
		<tr class="info">
			<th>出生年月:</th>
			<td><input type="text" name="birthday" id="birthday" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${familypersoninfo.birthday }" pattern="yyyy-MM-dd"/>"/></td>
			
		</tr>
		<tr class="info">
			<th>联系电话:</th>
			<td><input type="text" name="tel" id="tel" class="input_txt" value="${familypersoninfo.tel }"/></td>
		</tr>
		<tr class="info">
			<th>电子邮件:</th>
			<td><input type="text" name="email" id="email" class="input_txt" value="${familypersoninfo.email }"/></td>
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
				$("#familypersoninfosForm").submit();
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