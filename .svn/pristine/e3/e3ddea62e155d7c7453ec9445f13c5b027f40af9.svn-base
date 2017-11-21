<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>追加工单</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>服务请求编号</th>
				<th>原工单编号</th>
				<th>工单来源</th>
				<th>工单类型</th>
				<th>负责人</th>
				<th>负责人工号</th>
				<th>派单时间</th>
				<th>工单状态</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty Addwos }">
				<c:forEach items="${Addwos}" var="a" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${a.addCdId}"/>${s.count}</td>
						<td>${a.order.workOrderId}</td>			
						<td>${a.order.workOrderId}</td>
						<td>${a.wcTypeCd}</td>
						<td>${a.todoCd}</td>						
						<td>${a.owner}</td>
						<td>${a.ownerNum}</td>					
						<td>${a.created}</td>
						<td>${a.evtStatCd}</td>
						<td><a href="javascript:updateAddwo(${o.addCdId})">修改</a></td>
						<td><a href="javascript:deleteAddwo(${o.addCdId})">删除</a></td>
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
			<a href="javascript:addAddwo()" class="myBtn"><em>新增</em></a>
		</div>
		${addwo.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteAddwo(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Addwo/deleteAddwo.do";
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
		
		function addAddwo(){
			var dg = new $.dialog({
				title:'新增追加工单',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Addwo/getAddwo.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateAddwo(id){
			var dg = new $.dialog({
				title:'修改追加工单',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Addwo/getAddwo.do?id='+id
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>