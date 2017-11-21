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
	<form action="surname.do" method="post" name="surnameForm" id="surnameForm">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>序号</th>
			<th>宗地id</th>
			<th>类型</th>
			<th>名称</th>
			<th>公建建筑面积</th>
			<th>临时建筑</th>
			<th>配套费用总额</th>
			<th>公建用地面积</th>
			<th>移交对象</th>
			<th>移交对象名称</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty Surnames}">
				<c:forEach items="${Surnames}" var="surname" varStatus="vs">
				<tr class="main_info">
				<td>${surname.surnameInformationId}</td>
				<td>${surname.parceId}</td>
				<td>${surname.kind}</td>
				<td>${surname.name}</td>
				<td>${surname.surnameBuildErea}</td>
				<td>${surname.transferObject}</td>
				<td>${surname.transferObjectName}</td>			
				<td><a href="javascript:editHouse(${surname.surnameInformationId});">修改</a> | <a href="javascript:delHouse(${surname.surnameInformationId});">删除</a></td>
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
			<a href="javascript:addHouse();" class="myBtn"><em>新增</em></a>
		</div>
		${surname.page.pageStr }
	</div>
	</form>
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function addSurname(){
			//$(".shadow").show();
			var dg = new $.dialog({
				title:'新增公建信息',
				id:'house_new',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Surname/getSurname.do?surnameInformationId=0'
				});
    		dg.ShowDialog();
		}
		
		function editSurname(surnameInformationId){
			var dg = new $.dialog({
				title:'修改公建信息',
				id:'house_edit',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				resize:false,
				page:'House/getSurname.do?surnameInformationId='+surnameInformationId
				});
    		dg.ShowDialog();
		}
		
		function delSurname(surnameInformationId){
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Surname/deleteSurname.do?";
				$.post(url,{surnameInformationId:surnameInformationId},function(data){
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