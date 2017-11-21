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
	<form action="/Home/Corporatenews/AddorUpdateCorporatenews.do" name="corporatenewsForm" id="Form" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">								
		<tr class="info">
			<th>标题:</th>
			<td><input type="text" name="title" id="title" class="input_txt" value="${corporatenews.title }"/></td>
			<td><input type="hidden" name="id" id="id" class="input_txt" value="${corporatenews.id }"/></td>
		</tr>
		<tr class="info">
			<th>简要内容:</th>
			<td><input type="text" name="briefContent" id="briefContent" class="input_txt" value="${corporatenews.briefContent }"/></td>
		</tr>
		<tr class="info">
			<th>详细信息:</th>
			<td><input type="text" name="detailedInformation" id="detailedInformation" class="input_txt" value="${corporatenews.detailedInformation }"/></td>
		</tr>
		<tr class="info">
			<th>创建人:</th>
			<td><input type="text" name="founder" id="founder" class="input_txt" value="${corporatenews.founder }"/></td>
		</tr>	
		<tr class="info">
			<th>创建时间	:</th>
			<td><input type="text" name="creationTime" id="creationTime" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${corporatenews.creationTime}" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>最后修改人:</th>
			<td><input type="text" name="finalModifier" id="finalModifier" class="input_txt" value="${corporatenews.finalModifier }"/></td>
		</tr>
		<tr class="info">
			<th>最后修改时间:</th>
			<td><input type="text" name="lastModificationTime" id="lastModificationTime" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${corporatenews.lastModificationTime}" pattern="yyyy-MM-dd"/>"/></td>
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