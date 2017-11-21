<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
.info th{text-align: right;width:65px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;}
</style>
</head>
<body>
	<form action="/Home/Infrastructure/AddorUpdateInfrastructure.do" name="infrastructureForm" id="Form" target="result" method="post" onsubmit="return checkInfo();">
	<input type="hidden" name="parcelnumber" id="parcel_number" value="${infrastructure.parcelnumber }"/>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>类型:</th>
			<td><input type="text" name="type" id="type" class="input_txt" value="${infrastructure.type }"/></td>
		</tr>
		<tr class="info">
			<th>名称:</th>
			<td><input type="text" name="name" id="name" value="${infrastructure.name }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>公建建筑面积:</th>
			<td><input type="text" name="coveredarea" id="covered_area" value="${infrastructure.coveredarea }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>临时建筑:</th>
			<td><input type="text" name="temporaryworks" id="temporary_works" value="${infrastructure.temporaryworks }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>配套费用总额:</th>
			<td><input type="text" name="inclusivefee" id="inclusive_fee" value="${infrastructure.inclusivefee }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>公建用地面积:</th>
			<td><input type="text" name="landarea" id="land_area" value="${infrastructure.landarea }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>移交对象:</th>
			<td><input type="text" name="transferobject" id="transfer_object" value="${infrastructure.transferobject }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>移交对象名称:</th>
			<td><input type="text" name="transferobjectname" id="transfer_object_name" value="${infrastructure.transferobjectname }" class="input_txt" /></td>
		</tr>
		
	</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	
	<script type="text/javascript" src="../js/lib/jquery/jquery-1.5.1.min.js"></script>
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