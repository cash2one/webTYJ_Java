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
	<form action="/Home/Post/AddOrUpdatePost.do" name="HillockForm" id="HillockForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>部门名称:</th>
			<td>
			<input type="hidden" name="id" value="${post.id}">
			<select name="" id="divisionId" class="input_txt">
						<option value="0" >请选择</option>
						<c:forEach items="${Divisions}" var="p">					
							<option value="${p.id}">${p.divisionName}</option>
						</c:forEach>
				</select>
			</td>
		</tr>
			<tr class="info">
			<th>岗位类型:</th>
			<td>
			
			<select name="postTypeId" id="postTypeId" class="input_txt">
						<option value="" >请选择</option>
						
			</select>
			</td>
		</tr>
		<tr class="info">
			<th>岗位名称 :</th>
			<td>
			<input type="text" name="postName" class="input_txt" value="${post.postName}"/></td>
		</tr>
		
		<tr class="info">
			<th>位置描述:</th>
			<td>
			<input type="text" name="position" class="input_txt" value="${post.position}"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
			
				$("#HillockForm").submit();
			});
		});
		
		$("#divisionId").live("change", function() {
			alert($("#divisionId").val());
			var divisionId=$("#divisionId").val();
			
			$.post("getDivisionbyId.do", {"id" : divisionId},function(data){
				$("#postTypeId").empty();
				var json=eval(data);
				for ( var i = 0; i < json.length; i++) {
					alert(json[i]['postTypeId']);
					$("#postTypeId").append("<option id=optionId value="+json[i]['postTypeId']+">"+json[i]['postTypeName']+"</option>");
				}
				
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