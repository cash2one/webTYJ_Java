<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Test</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
</head>
<body>
	<form action="staff.do" method="post" name="staffForm" id="staffForm">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>员工id</th>
			<th>公司id</th>
			<th>员工号</th>
			<th>姓氏</th>
			<th>名字</th>
			<th>姓氏拼音</th>
			<th>名字拼音</th>
			<th>性别</th>
			<th>籍贯</th>
			<th>婚否</th>		
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty Staffs}">
				<c:forEach items="${Staffs}" var="staff" varStatus="vs">
				<tr class="main_info">
				<td>${staff.staffId}</td>
				<td>${staff.companyId}</td>
				<td>${staff.staffNumber}</td>
				<td>${staff.firstName}</td>
				<td>${staff.lastName}</td>
				<td>${staff.firstNameSpell}</td>
				<td>${staff.lastNameSpell}</td>
				<td>${staff.sex}</td>
				<td>${staff.nativePlace}</td>
				<td>${staff.married}</td>
				
				<td><a href="javascript:editStaff(${staff.staffId});">修改</a> | <a href="javascript:delStaff(${staff.staffId});">删除</a></td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="7">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addStaff();" class="myBtn"><em>新增</em></a>
		</div>
		${house.page.pageStr }
	</div>
	</form>
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function addStaff(){
			//$(".shadow").show();
			var dg = new $.dialog({
				title:'新增员工信息',
				id:'house_new',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Staff/getStaff.do?staffId=0'
				});
    		dg.ShowDialog();
		}
		
		function editStaff(staffId){
			var dg = new $.dialog({
				title:'修改员工信息',
				id:'house_edit',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				resize:false,
				page:'Staff/getStaff.do?staffId='+staffId
				});
    		dg.ShowDialog();
		}
		
		function delStaff(staffId){
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Staff/deleteStaff.do?";
				$.post(url,{staffId:staffId},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");
					}
				});
			}
		}
		
	</script>
</body>
</html>