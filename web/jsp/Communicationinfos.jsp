<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>通讯信息表</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>联系信息Id</th>
				<th>个人客户Id</th>
				<th>国家编号</th>
				<th>城市编号</th>
				<th>手机号码</th>
				<th>固定电话</th>
				<th>分机号</th>
				<th>QQ</th>	
				<th>电子邮箱</th>
				<th>备注</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty Communicationinfos }">
				<c:forEach items="${Communicationinfos}" var="e" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${e.contactId}"/>${s.count}</td>
						<td>${e.personCust.custId}</td>			
						<td>${e.countryCode}</td>
						<td>${e.cityCode}</td>
						<td>${e.telephoneNum}</td>					
						<td>${e.landlineNum}</td>
						<td>${e.extensionNum}</td>
						<td>${e.QQ}</td>
						<td>${e.email}</td>
						<td>${e.remark}</td>
						<td><a href="javascript:updateCommunicationinfo(${e.contactId})">修改</a></td>
						<td><a href="javascript:deleteCommunicationinfoById(${e.contactId})" id="delete">删除</a></td>
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
			<a href="javascript:addCommunicationinfo()" class="myBtn"><em>新增</em></a>
		</div>
		${entrustInfo.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteCommunicationinfoById(contactId)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Communicationinfo/deleteCommunicationinfoById.do";
				$.post(url,{contactId:contactId},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");
					}
				});
			}
		}
		
		function addCommunicationinfo(){
			var dg = new $.dialog({
				title:'新增通讯信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Communicationinfo/getCommunicationinfo.do?contactId=0'
				});
    		dg.ShowDialog();
		}
		
		function updateCommunicationinfo(contactId){
			var dg = new $.dialog({
				title:'修改通讯信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Communicationinfo/getCommunicationinfo.do?contactId='+contactId
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>