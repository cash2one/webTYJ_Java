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
	<form action="/Home/Adjunct/AddorUpdateAdjunct.do" name="AdjunctForm" id="AdjunctForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>住宅id:</th>
			<td>
			<input type="hidden" name="id" value="${Adjunct.id}">
			<select name="houseid" id="house.id" class="input_txt">
						<option value="">请选择</option>
						<c:forEach items="${houses}" var="p">
							<option <c:if test="${p.id==Adjunct.house.id}">selected="selected"</c:if> value="${p.id }">${p.id }</option>
						</c:forEach>
				</select>
		</td>
		</td>
		</tr>
		<tr class="info">
			<th>附件类型:</th>
			<td>
				<select name="accessoryStyle">
					<option <c:if test="${Adjunct.accessoryStyle==0}">selected="selected"</c:if>  value="0">文件</option>
					<option <c:if test="${Adjunct.accessoryStyle==1}">selected="selected"</c:if> value="1">图片</option>
					<option <c:if test="${Adjunct.accessoryStyle==2}">selected="selected"</c:if> value="1">视频</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>附件名字:</th>
			<td><input type="text" name="accessoryName" value="${Adjunct.accessoryName}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>附件url:</th>
			<td><input type="text" name="accessoryUrl" value="${Adjunct.accessoryUrl}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>最后修改时间:</th>
			<td><input type="text" name="lastUpdatetime" onclick="WdatePicker()" value="<fmt:formatDate value="${Adjunct.lastUpdatetime }"/>"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>最后修改人:</th>
			<td><input type="text" name="lastUpdatepeople" class="input_txt" value="${Adjunct.lastUpdatepeople }"/></td>
		</tr>
		<tr class="info">
			<th>状态:</th>
			<td><input type="text" name="state" class="input_txt" value="${Adjunct.state }"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#AdjunctForm").submit();
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