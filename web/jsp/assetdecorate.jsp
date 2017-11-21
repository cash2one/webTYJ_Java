<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>资产装修信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>装修申请日期</th>
				<th>装修完成日期</th>
				<th>施工单位名称</th>
				<th>设计图纸(关联附件)</th>
				<th>装修类型</th>
				<th>装修类别</th>
				<th>装修状态</th>
				<th>联系人</th>
				<th>联系电话</th>
				<th>联系地址</th>
				<th>是否委托</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty assetdecorates }">
				<c:forEach items="${assetdecorates}" var="f" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${f.assetsDecorateId}"/>${s.count}</td>				
						<td><fmt:formatDate value="${f.applyDate}" pattern="yyyy-MM-dd"/></td>					
						<td><fmt:formatDate value="${f.completeDate}" pattern="yyyy-MM-dd"/></td>
						<td>${f.builderName}</td>
						<td>${f.designDrawing}</td>
						<td>${f.decorationType}</td>
						<td>${f.decorationKind}</td>
						<td>${f.decorationState}</td>
						<td>${f.contacts}</td>
						<td>${f.contactTelephoner}</td>
						<td>${f.contactAddress}</td>
						<td>${f.entrusted}</td>
						<td><a href="javascript:updateAssetdecorate(${f.assetsDecorateId})">修改</a></td>
						<td><a href="javascript:deleteAssetdecorate(${f.assetsDecorateId})" id="delete">删除</a></td>
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
			<a href="javascript:addAssetdecorate()" class="myBtn"><em>新增</em></a>
		</div>
		${Assetdecorate.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteAssetdecorate(assetsDecorateId)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Assetdecorate/deleteAssetdecorate.do";
				$.post(url,{assetsDecorateId:assetsDecorateId},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");	
					}
				});
			}
		}
		
		function addAssetdecorate(){
			var dg = new $.dialog({
				title:'新增资产装修信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Assetdecorate/getAssetdecorate.do?assetsDecorateId=0'
				});
    		dg.ShowDialog();
		}
		
		function updateAssetdecorate(assetsDecorateId){
			var dg = new $.dialog({
				title:'修改资产装修信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Assetdecorate/getAssetdecorate.do?assetsDecorateId='+assetsDecorateId
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>