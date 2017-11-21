<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>委托信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>id</th>
				<th>住宅id</th>
				<th>附件类型</th>
				<th>附件名字</th>
				<th>附件url</th>
				<th>最后修改时间</th>
				<th>最后修改人</th>
				<th>状态</th>	
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty Adjuncts }">
				<c:forEach items="${Adjuncts}" var="e" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${e.id}"/>${s.count}</td>
						<td>${e.house.id}</td>			
						<td>${e.accessoryStyle}</td>
						<td>${e.accessoryName}</td>
						<td>${e.accessoryUrl}</td>
						<td><fmt:formatDate value="${e.lastUpdatetime}" pattern="yyyy-MM-dd"/></td>						
						<td>${e.lastUpdatepeople}</td>
						<td>${e.state}</td>
						<td><a href="javascript:updateAdjunct(${e.id})">修改</a></td>
						<td><a href="javascript:deleteAdjunctById(${e.id})">删除</a></td>
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
			<a href="javascript:addAdjunct()" class="myBtn"><em>新增</em></a>
		</div>
		${adjunct.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteAdjunctById(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Adjunct/deleteAdjunctById.do";
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
		
		function addAdjunct(){
			var dg = new $.dialog({
				title:'新增附件信息',
				id:'user_new',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Adjunct/getAdjunct.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateAdjunct(id){
			var dg = new $.dialog({
				title:'修改附件信息',
				id:'user_new',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Adjunct/getAdjunct.do?id='+id
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>