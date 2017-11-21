<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Test</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
</head>
<body>
	<form action="enterprise.do" method="post" name="enterpriseForm" id="enterpriseForm">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>序号</th>
			<th>客户编号</th>
			<th>单位名称</th>
			<th>单位属性</th>
			<th>注册日期</th>
			<th>注册地址</th>
			<th>营业执照</th>
			<th>法人代表</th>
			<th>证件类型</th>
			<th>证件号码</th>
			<th>单位地址</th>
			<th>企业类型</th>
			<th>单位委托人</th>
			<th>经营类型</th>
			<th>税务登记号</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty Enterprise}">
				<c:forEach items="${Enterprise}" var="enterprise" varStatus="vs">
				<tr class="main_info">
				<td>${enterprise.enterpriseId}</td>
				<td>${enterprise.custcode}</td>
				<td>${enterprise.unitName}</td>
				<td>${enterprise.unitAttribute}</td>
				<td><fmt:formatDate value="${enterprise.registTime}" pattern="yyyy-MM-dd"/></td>
				<td>${enterprise.registAddress}</td>
				<td>${enterprise.businessLicense}</td>
				<td>${enterprise.represent}</td>
				<td>${enterprise.cardType}</td>
				<td>${enterprise.cardNum}</td>
				<td>${enterprise.unitAddress}</td>
				<td>${enterprise.enterpriseType}</td>
				<td>${enterprise.unitPrincipal}</td>
				<td>${enterprise.businessType}</td>
				<td>${enterprise.taxReg}</td>
				<td><a href="javascript:editEnterprise(${enterprise.enterpriseId});">修改</a> | <a href="javascript:delEnterprise(${enterprise.enterpriseId});">删除</a></td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="7">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addEnterprise();" class="myBtn"><em>新增</em></a>
		</div>
		${enterprise.page.pageStr }
	</div>
	</form>
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function addEnterprise(){
			//$(".shadow").show();
			var dg = new $.dialog({
				title:'新增企业信息',
				id:'enterprise_new',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Enterprise/getEnterprise.do?enterpriseId=0'
				});
    		dg.ShowDialog();
		}
		
		function editEnterprise(enterpriseId){
			var dg = new $.dialog({
				title:'修改企业信息',
				id:'enterprise_edit',
				width:600,
				height:400,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				resize:false,
				page:'Enterprise/getEnterprise.do?enterpriseId='+enterpriseId
				});
    		dg.ShowDialog();
		}
		
		function delEnterprise(enterpriseId){
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Enterprise/deleteEnterprise.do?";
				$.post(url,{enterpriseId:enterpriseId},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");
					}
				});
			}
		}
		
	</script>
</body>
</html>