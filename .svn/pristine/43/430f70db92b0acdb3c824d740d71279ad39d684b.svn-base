<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="/Home/css/main.css"/>
<script type="text/javascript" src="/Home/js/lib/jquery/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="/Home/js/lib/datePicker/WdatePicker.js"></script>
<title>自动化排班</title>
</head>
<body>
<form id="from" action="/Home/initialize/Scheduling.do" method="post">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>部门：</th>
			<td colspan="2">
				<select id="division" name="divisionId">
						<option value="">请选择</option>
					<c:forEach var="d" items="${divisions}">
						<option value="${d.id}">${d.divisionName}</option>
					</c:forEach>
				</select> 
			</td>
			<td>日期：<input id="date" name="schedulingDate" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy年MM月'})" type="text"/></td>
			<td><input type="button" onclick="fromsubmit()" value="排班"/></td>
		</tr>
	</table>
</form>	
<script type="text/javascript">
	function fromsubmit()
	{
		var divisionId=$("#division").val();
		var divisiontext=$("#division").find("option:selected").text();
		var schedulingDate=$("#date").val();
		$.get("/Home/initialize/isScheduling.do",{divisionId:divisionId,schedulingDate:schedulingDate},function(data){ 
			if(data=="failed")
			{
				alert(divisiontext+"的"+schedulingDate+"已排过班！");
			}else if(data=="failed1")
			{
				alert(divisiontext+"尚未初始化请先初始化！");
			}else
			{
				$("#from").submit();	
			}
		});
	}
</script>
</body>
</html>