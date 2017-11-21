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
	<form action="/Home/Additioninfo/AddorUpdateAdditioninfo.do" name="additioninfoForm" id="Form" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">							
		<tr class="info">
			<th>项目编号:</th>
			<td>
			<input type="hidden" name="additionInformationId" value="${additioninfo.additionInformationId}">
				<select name="projectNumber" id="projectfieldinfo.projectNumber" class="input_txt">
						<option value="">请选择</option>
						<c:forEach items="${projectfieldinfos}" var="p">
							<option <c:if test="${p.projectNumber==additioninfo.projectfieldinfo.projectNumber}">selected="selected"</c:if> value="${p.projectNumber }">${p.projectNumber }</option>
						</c:forEach>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>加建日期:</th>
			<td><input type="text" name="additionDate" id="additionDate" class="input_txt" value="<fmt:formatDate value="${additioninfo.additionDate }" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>加建面积:</th>
			<td><input type="text" name="additionArea" id="additionArea" class="input_txt" value="${additioninfo.additionArea }"/></td>
		</tr>
		<tr class="info">
			<th>竣工日期:</th>
			<td><input type="text" name="completionDate" id="completionDate" class="input_txt" value="<fmt:formatDate value="${additioninfo.completionDate }" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>竣工面积:</th>
			<td><input type="text" name="completionErea" id="completionErea" class="input_txt" value="${additioninfo.completionErea }"/></td>
		</tr>
		<tr class="info">
			<th>加建类型:</th>
			<td><input type="text" name="additionKind" id="additionKind" class="input_txt" value="${additioninfo.additionKind }"/></td>
		</tr>
		<tr class="info">
			<th>加建描述:</th>
			<td><input type="text" name="additionDescribe" id="additionDescribe" class="input_txt" value="${additioninfo.additionDescribe }"/></td>
		</tr>
		<tr class="info">
			<th>资产编号:</th>
			<td><input type="text" name="propertyNumber" id="propertyNumber" class="input_txt" value="${ additioninfo.propertyNumber }"/></td>
		</tr>
	</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/jquery-1.5.1.min.js"></script>
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