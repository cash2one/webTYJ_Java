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
<script type="text/javascript" src="../js/lib/jquery-1.5.1.min.js"></script>
</head>
<body>
	<form action="/Home/initialize/updateSchedulingByStaffId.do" name="HillockForm" id="HillockForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
		
			<th>部门名称:${scheduling.divisionName}
			<input type="hidden" name="divisionId" value="${scheduling.divisionId}">
				
			</th>

		</tr>
		<tr class="info">
			<th>岗位:${scheduling.postName}</th>
		</tr>
			<tr class="info">
			<th>员工编号:${scheduling.staffId}<input type="hidden" value="${scheduling.staffId}" name="staffId"></th>
			
			
		</tr>
		<tr class="info">
			<th>员工姓名:${scheduling.staffName}</th>
		</tr>
		<tr class="info">
	
			<th>日期:<input  type="text" name="currentdate"   onclick="WdatePicker()" readonly="readonly" style="width:70px;"/> </th>
		</tr>
		<tr class="info">
			<th>班次:
				<select name="classesTypeId" id="classesTypeId">
				
					<c:forEach items="${classesTypes}" var="c" varStatus="d">
						<option  value="${c.classesTypeId}"<c:if test="${c.classesTypeId==scheduling.classesTypeId}">selected="selected"</c:if>>${c.classesTypeName}</option>
					</c:forEach>
					
				</select>
				<input type="hidden" name="classesTypeName" id="classesTypeName">
			</th>
		</tr>
		
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	
	<script type="text/javascript" src="/Home/js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="/Home/js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="/Home/js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="/Home/js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">	
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				alert("aa")
				$("#HillockForm").submit();
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
		$("#classesTypeId").change(function() {
			alert("aa");
			var text= $("#classesTypeId option:selected").text();
			 $("#classesTypeName").val(text);
			 alert($("#classesTypeName").val());
			});
	
		
		function failed(){
			alert("新增失败");
		}
	</script>
</body>
</html>