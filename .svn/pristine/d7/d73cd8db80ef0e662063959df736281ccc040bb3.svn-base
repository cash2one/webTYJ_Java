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
	<form action="/Home/garagefield/AddorUpdateGaragefield.do" name="garagefieldsForm" id="garagefieldsForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>项目id:</th>
			<td>
 			<input type="hidden" name="garageId" id="garageId" value="${Garagefield.garageId }"/>
 			<select name="projectId" id="project.projectId" class="input_txt">
						<option value="">请选择</option>
						<c:forEach items="${projects}" var="p">
							<option <c:if test="${p.projectId==Garagefield.project.projectId}">selected="selected"</c:if> value="${p.projectId }">${p.projectId }</option>
						</c:forEach>
				</select>
				</td>
 			</tr>	
		<tr class="info">
			<th>车库编码:</th>
			<td><input type="text" name="garageNumber" id="garageNumber" class="input_txt" value="${Garagefield.garageNumber }" /></td>
		</tr>		
		<tr class="info">
			<th>车库识别码:</th>
			<td><input type="text" name="garageCdkey" id="garageCdkey" class="input_txt" value="${Garagefield.garageCdkey }" /></td>
		</tr>
		<tr class="info">
			<th>显示名称:</th>
			<td><input type="text" name="name" id="name" class="input_txt" value="${Garagefield.name }"/></td>
		</tr>
		<tr class="info">
			<th>位置描述:</th>
			<td><input type="text" name="position" id="position" class="input_txt" value="${Garagefield.position }"/></td>
		</tr>
		<tr class="info">
			<th>车位类型:</th>
			<td>
				<select name="cardType">
					<option <c:if test="${Garagefield.stallKind==1}">selected="selected"</c:if> value="1">轿车</option>
					<option <c:if test="${Garagefield.stallKind==2}">selected="selected"</c:if> value="2">货车</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>车位数:</th>
			<td><input type="text" name="projectNumber" id="projectNumber" class="input_txt" value="${Garagefield.projectNumber }"/></td>
		</tr>
		<tr class="info">
			<th>车库入口数:</th>
			<td><input type="text" name="garageEntnum" id="garageEntnum" class="input_txt" value="${Garagefield.garageEntnum}"/></td>	
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
				$("#garagefieldsForm").submit();
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