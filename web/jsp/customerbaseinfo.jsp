<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>客户信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>客户编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>籍贯</th>
				<th>户口所在地</th>
				<th>出生日期</th>
				<th>证件类型</th>
				<th>证件号码</th>
				<th>联系住址</th>
				<th>家家号</th>
				<th>微信帐号</th>
				<th>婚否</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty customerbaseinfos }">
				<c:forEach items="${customerbaseinfos}" var="h" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${h.id}"/>${s.count}</td>
						<td>${h.custcode}</td>			
						<td>${h.name}</td>
						<td>${h.sex}</td>
						<td>${h.nativeplace}</td>						
						<td>${h.census}</td>
						<td><fmt:formatDate value="${h.birthday}" pattern="yyyy-MM-dd" /></td>
						<td>${h.cardtype}</td>
						<td>${h.cardnum}</td>
						<td>${h.contactaddress}</td>
						<td>${h.jiajianum}</td>
						<td>${h.weixinnum}</td>
					 	<td>${h.married}</td>
						<td><a href="javascript:updateCustomerbaseinfo(${h.id})">修改</a></td>
						<td><a href="javascript:deleteCustomerbaseinfo(${h.id})" id="delete">删除</a></td>
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
			<a href="javascript:addCustomerbaseinfo()" class="myBtn"><em>新增</em></a>
		</div>
		${customerbaseinfo.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteCustomerbaseinfo(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Customerbaseinfo/deleteCustomerbaseinfo.do";
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
		
		function addCustomerbaseinfo(){
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
				page:'Customerbaseinfo/getCustomerbaseinfo.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateCustomerbaseinfo(id){
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
				page:'Customerbaseinfo/getCustomerbaseinfo.do?id='+id
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>