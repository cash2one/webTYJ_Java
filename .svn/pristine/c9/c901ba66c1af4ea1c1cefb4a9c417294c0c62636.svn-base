<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>公建信息表</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>类型</th>
				<th>名称</th>
				<th>公建建筑面积</th>
				<th>临时建筑</th>
				<th>配套费用总额</th>
				<th>公建用地面积</th>
				<th>移交对象</th>
				<th>移交对象名称</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty infrastructures }">
				<c:forEach items="${infrastructures}" var="i" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${i.parcelnumber}"/>${s.count}</td>
						<td>${i.type}</td>			
						<td>${i.name}</td>
						<td>${i.coveredarea}</td>
						<td>${i.temporaryworks}</td>						
						<td>${i.inclusivefee}</td>
						<td>${i.landarea}</td>
						<td>${i.transferobject}</td>
						<td>${i.transferobjectname}</td>
						<td><a href="javascript:updateInfrastructure(${i.parcelnumber})">修改</a></td>
						<td><a href="javascript:deleteInfrastructure(${i.parcelnumber})" id="delete">删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="9">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addInfrastructureinfo()" class="myBtn"><em>新增</em></a>
		</div>
		${infrastructure.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteInfrastructure(parcelnumber)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Infrastructure/delete.do";
				$.post(url,{parcelnumber:parcelnumber},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");	
					}
				});
			}
		}
		
		function addInfrastructureinfo(){
			var dg = new $.dialog({
				title:'新增房屋住宅信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Infrastructure/getInfrastructure.do?parcelnumber=0'
				});
    		dg.ShowDialog();
		}
		
		function updateInfrastructure(parcelnumber){
			var dg = new $.dialog({
				title:'修改公建信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Infrastructure/getInfrastructure.do?parcelnumber='+parcelnumber
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>