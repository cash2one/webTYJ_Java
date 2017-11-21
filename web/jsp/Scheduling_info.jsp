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
</head>
<body>
	<form action="/Home/Scheduling/AddOrUpdateScheduling.do" name="SchedulingForm" id="SchedulingForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>部门:</th>
			<td>
			<input type="hidden" name="id" value="${Scheduling.id}">
			<select id="Division" onchange="division(this.value);" class="input_txt">
					<option value="0" selected="selected" >请选择</option>
					<c:forEach items="${divisions}" var="d">
						<option value="${d.id}">${d.divisionName}</option>
					</c:forEach>
			</select>
			</td>
		</tr>
		<tr class="info">
			<th>岗位:</th>
			<td>
			<select id="hillock" onchange="hillocks(this.value);" class="input_txt">
				<option value="0" selected="selected" >请选择</option>
			</select>
			</td>
		</tr>
		<tr class="info">
			<th>员工:</th>
			<td>
			<select name="staffId" id="staff" class="input_txt">
				<c:if test="${Scheduling.id==null}">
					<option value="0" selected="selected" >请选择</option>
				</c:if>
				<c:if test="${Scheduling.id!=null}">
					<option value="${Scheduling.staffId}" selected="selected" >${Scheduling.staff.firstName}${Scheduling.staff.lastName}</option>
				</c:if>
			</select>
			</td>
		</tr>
		
		<tr class="info">
			<th>班次:</th>
			<td>
				<select name="classesId">
					<option <c:if test="${Scheduling.classesId==1}">selected="selected"</c:if> value="1">A班</option>
					<option <c:if test="${Scheduling.classesId==2}">selected="selected"</c:if> value="2">B班</option>
					<option <c:if test="${Scheduling.classesId==3}">selected="selected"</c:if> value="3">C班</option>
				</select>
			</td>
			<td>
		</tr>
		
		<tr class="info">
			<th>备注:</th>
			<td><input type="text" name="remark" class="input_txt" value="${Scheduling.remark }"/></td>
		</tr>
		
		<tr class="info">
			<th>日期:</th>
			<td><input type="text" name="currentDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${Scheduling.currentDate}" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="../js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#SchedulingForm").submit();
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
		
		function division(id){
			$("#hillock").do("");
			$("#hillock").append("<option value='0' selected='selected' >请选择</option>");
			$.post("/Home/Scheduling/listHillockByDivisionsId.do",{divisionId:id},function(data){
				var json=eval(data);
				for(var i=0;i<json.length;i++)
				{
					$("#hillock").append("<option value="+json[i]['id']+">"+json[i]['post']+"</option>");
				}
			});
		}
		
		function hillocks(id){
			$("#staff").do("");
			$("#staff").append("<option value='0' selected='selected' >请选择</option>");
			$.post("/Home/Scheduling/listStaffByHillockId.do",{hillockId:id},function(data){
				var json=eval(data);
				for(var i=0;i<json.length;i++)
				{
					$("#staff").append("<option value="+json[i]['staffId']+">"+json[i]['firstName']+""+json[i]['lastName']+"</option>");
				}
			});
		}
	</script>
</body>
</html>