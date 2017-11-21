<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>房屋住宅信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>项目编号</th>
				<th>项目名称</th>
				<th>销售状态</th>
				<th>入伙状态</th>
				<th>租赁状态</th>
				<th>交易信息</th>
				<th>经营信息</th>
				<th>装修信息</th>
				<th>租赁信息</th>
				<th>加建信息</th>
				<th>房屋用户编号</th>
				<th>密码</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty housefieldinfos }">
				<c:forEach items="${housefieldinfos}" var="h" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${h.homeid}"/>${s.count}</td>
						<td>${h.projectNumber}</td>			
						<td>${h.projectName}</td>
						<td>${h.salesState}</td>
						<td>${h.intakeState}</td>						
						<td>${h.rentState}</td>
						<td>${h.tradeMessage}</td>
						<td>${h.operateMessage}</td>
						<td>${h.decorateMessage}</td>
						<td>${h.rentMessage}</td>
						<td>${h.addition}</td>
						<td>${h.customerbaseinfo.custcode}</td>
					 	<td>${h.password}</td>
						<td><a href="javascript:updateHousefieldinfo(${h.homeid})">修改</a></td>
						<td><a href="javascript:deleteHousefieldinfo(${h.homeid})" id="delete">删除</a></td>
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
			<a href="javascript:addHousefieldinfo()" class="myBtn"><em>新增</em></a>
		</div>
		${housefieldinfo.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteHousefieldinfo(homeid)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Housefieldinfo/deleteHousefieldinfo.do";
				$.post(url,{homeid:homeid},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");	
					}
				});
			}
		}
		
		function addHousefieldinfo(){
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
				page:'Housefieldinfo/getHousefieldinfo.do?homeid=0'
				});
    		dg.ShowDialog();
		}
		
		function updateHousefieldinfo(homeid){
			var dg = new $.dialog({
				title:'修改房屋住宅信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Housefieldinfo/getHousefieldinfo.do?homeid='+homeid
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>