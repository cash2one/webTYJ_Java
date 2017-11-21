<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>客户编号</th>
				<th>家庭成员编号</th>
				<th>关系类型</th>
				<th>证件类型</th>
				<th>证件号码</th>
				<th>性别</th>
				<th>出生年月</th>
				<th>联系电话</th>
				<th>电子邮件</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty familypersoninfos }">
				<c:forEach items="${familypersoninfos}" var="f" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${f.id}"/>${s.count}</td>
						<td>${f.custcode}</td> 
						<td>${f.familycode}</td>
						<td>${f.relationshiptype}</td>
						<td>${f.cardtype}</td>
						<td>${f.cardnum}</td>
						<td>${f.sex}</td>
						<td><fmt:formatDate value="${f.birthday}" pattern="yyyy-MM-dd"/></td>
						<td>${f.tel}</td>
						<td>${f.email}</td>
						<td><a href="javascript:updateFamilypersoninfo(${f.id})">修改</a></td>
						<td><a href="javascript:deleteFamilypersoninfoById(${f.id})" id="delete">删除</a></td>
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
			<a href="javascript:addFamilypersoninfos()" class="myBtn"><em>新增</em></a>
		</div>
		${familypersoninfo.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteFamilypersoninfoById(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/familypersoninfo/deleteFamilypersoninfo.do";
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
		
		function addFamilypersoninfos(){
			var dg = new $.dialog({
				title:'新增清单信息',
				id:'user_new',
				width:400,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'familypersoninfo/getFamilypersoninfo.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateFamilypersoninfo(id){
			var dg = new $.dialog({
				title:'修改清单信息',
				id:'user_new',
				width:400,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'familypersoninfo/getFamilypersoninfo.do?id='+id
				});
    		dg.ShowDialog();
		}
		
	</script>
</body>
</html>