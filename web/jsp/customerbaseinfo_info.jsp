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
	<form action="/Home/Customerbaseinfo/AddorUpdateCustomerbaseinfo.do" name="customerbaseinfoForm" id="Form" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">							
		<tr class="info">
			<th>客户编号:</th>			
			<td><input type="text" name="custcode" id="custcode" class="input_txt" value="${customerbaseinfo.custcode}"/>
			<input type="hidden" name="id" value="${customerbaseinfo.id}"></td>
		</tr>
		<tr class="info">
			<th>姓名:</th>
			<td><input type="text" name="name" id="name" class="input_txt" value="${customerbaseinfo.name}"/></td>
		</tr>
		<tr class="info">
			<th>性别:</th>
			<td><input type="text" name="sex" id="sex" class="input_txt" value="${customerbaseinfo.sex}"/></td>
		</tr>
		<tr class="info">
			<th>籍贯:</th>
			<td><input type="text" name="nativeplace" id="nativeplace" class="input_txt" value="${customerbaseinfo.nativeplace}"/></td>
		</tr>
		<tr class="info">
			<th>户口所在地:</th>
			<td><input type="text" name="census" id="census" class="input_txt" value="${customerbaseinfo.census}"/></td>
		</tr>
		<tr class="info">
			<th>出生日期:</th>
			<td><input type="text" name="birthday" id="birthday" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${customerbaseinfo.birthday}" pattern="yyyy-MM-dd"/>" /></td>
		</tr>
		<tr class="info">
			<th>证件类型:</th>
			<td><input type="text" name="cardtype" id="cardtype" class="input_txt" value="${customerbaseinfo.cardtype}"/></td>
		</tr>
		<tr class="info">
			<th>证件号码:</th>
			<td><input type="text" name="cardnum" id="cardnum" class="input_txt" value="${ customerbaseinfo.cardnum}"/></td>
		</tr>
		<tr class="info">
			<th>家家号:</th>
			<td><input type="text" name="jiajianum" id="jiajianum" class="input_txt" value="${ customerbaseinfo.jiajianum}"/></td>
		</tr>
		<tr class="info">
			<th>微信帐号:</th>
			<td><input type="text" name="weixinnum" id="weixinnum" class="input_txt" value="${ customerbaseinfo.weixinnum}"/></td>
		</tr>
		<tr class="info">
			<th>婚否:</th>
			<td><input type="text" name="married" id="married" class="input_txt" value="${ customerbaseinfo.married}"/></td>
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