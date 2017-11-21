<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>资产经营信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>客户id</th>
				<th>经营项目</th>
				<th>经营名称</th>
				<th>注册日期</th>
				<th>注册地址</th>
				<th>营业执照</th>
				<th>消防审批</th>
				<th>法人代表</th>
				<th>联系人</th>
				<th>联系电话</th>
				<th>联系地址</th>
				<th>开始日期</th>
				<th>经营状态</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty assetmanages }">
				<c:forEach items="${assetmanages}" var="f" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${f.assetsManagemenid}"/>${s.count}</td>				
						<td>${f.personCust.custId}</td>					
						<td>${f.manageProject}</td>
						<td>${f.manageName}</td>
						<td> <fmt:formatDate value="${f.regeditDate}" pattern="yyyy-MM-dd"/>  </td>
						<td>${f.regeditAddress}</td>
						<td>${f.instructions}</td>
						<td>${f.approval}</td>
						<td>${f.corporateRepresentative}</td>
						<td>${f.contacts}</td>
						<td>${f.contactsTelephone}</td>
						<td>${f.contactsAddress}</td>
						<td><fmt:formatDate value="${f.startDate}" pattern="yyyy-MM-dd"/></td>
						<td>${f.manageState}</td>
						<td><a href="javascript:updateAssetmanage(${f.assetsManagemenid})">修改</a></td>
						<td><a href="javascript:deleteAssetmanage(${f.assetsManagemenid})" id="delete">删除</a></td>
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
			<a href="javascript:addAssetmanage()" class="myBtn"><em>新增</em></a>
		</div>
		${Assetmanage.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteAssetmanage(assetsManagemenid)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Assetmanage/deleteAssetmanage.do";
				$.post(url,{assetsManagemenid:assetsManagemenid},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");	
					}
				});
			}
		}
		
		function addAssetmanage(){
			var dg = new $.dialog({
				title:'新增资产经营信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Assetmanage/getAssetmanage.do?assetsManagemenid=0'
				});
    		dg.ShowDialog();
		}
		
		function updateAssetmanage(assetsManagemenid){
			var dg = new $.dialog({
				title:'修改资产经营信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Assetmanage/getAssetmanage.do?assetsManagemenid='+assetsManagemenid
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>