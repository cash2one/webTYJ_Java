<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>加建信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>项目编号</th>
				<th>加建日期</th>
				<th>加建面积</th>
				<th>竣工日期</th>
				<th>竣工面积</th>
				<th>加建类型</th>
				<th>加建描述</th>
				<th>资产编号</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty additioninfos }">
				<c:forEach items="${additioninfos}" var="h" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${h.additionInformationId}"/>${s.count}</td>		
						<td>${h.projectfieldinfo.projectNumber}</td>			
						<td><fmt:formatDate value="${h.additionDate}" pattern="yyyy-MM-dd" /></td>
						<td>${h.additionArea}</td>
						<td><fmt:formatDate value="${h.completionDate}" pattern="yyyy-MM-dd" /></td>						
						<td>${h.completionErea}</td>
						<td>${h.additionKind}</td>
						<td>${h.additionDescribe}</td>
						<td>${h.propertyNumber}</td>
						<td><a href="javascript:updateAdditioninfo(${h.additionInformationId})">修改</a></td>
						<td><a href="javascript:deleteAdditioninfo(${h.additionInformationId})" id="delete">删除</a></td>
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
			<a href="javascript:addAdditioninfo()" class="myBtn"><em>新增</em></a>
		</div>
		${Additioninfo.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteAdditioninfo(additionInformationId)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Additioninfo/deleteAdditioninfo.do";
				$.post(url,{additionInformationId:additionInformationId},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");	
					}
				});
			}
		}
		
		function addAdditioninfo(){
			var dg = new $.dialog({
				title:'新增加建信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Additioninfo/getAdditioninfo.do?additionInformationId=0'
				});
    		dg.ShowDialog();
		}
		
		function updateAdditioninfo(additionInformationId){
			var dg = new $.dialog({
				title:'修改加建信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Additioninfo/getAdditioninfo.do?additionInformationId='+additionInformationId
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>