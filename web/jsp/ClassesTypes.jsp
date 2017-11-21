<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>班次类型表</title>
</head>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>id</th>
				<th>班次类型名称</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty ClassesTypes }">
				<c:forEach items="${ClassesTypes}" var="e" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${e.classesTypeId}"/>${s.count}</td>				
						<td>${e.classesTypeName}</td>
						<td><a href="javascript:updateDivision(${e.classesTypeId})">修改</a></td>
						<td><a href="javascript:deleteDivision(${e.classesTypeId})">删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="17">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addDivision()" class="myBtn"><em>新增</em></a>
		</div>
		<%-- //${division.page.pageStr} --%>
	</div>
	</form>
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteDivision(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/ClassesType/deleteClassesType.do";
				$.post(url,{id:id},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");
					}
				});
			}
		}
		
		function addDivision(){
			//alert('aa00');
			var dg = new $.dialog({
				title:'新增岗位类型',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'ClassesType/getClassesTypebyId.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateDivision(id){
			var dg = new $.dialog({
				title:'修改岗位类型',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'ClassesType/getClassesTypebyId.do?id='+id
				});
    		dg.ShowDialog();
		}
		
</script>
</body>
</html>