<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>账户信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>个人客户id</th>
				<th>账单投递地址</th>
				<th>托收银行帐号</th>
				<th>银行名称</th>
				<th>开户名</th>
				<th>是否有效</th>
				<th>启用日期</th>
				<th>失效日期</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty accounts }">
				<c:forEach items="${accounts}" var="f" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${f.accountId}"/>${s.count}</td>				
						<td>${f.personCust.custId}</td>					
						<td>${f.billingAddress}</td>
						<td>${f.bankAccount}</td>
						<td>${f.bankName}</td>
						<td>${f.openAccountName}</td>
						<td>${f.effectived}</td>
						<td><fmt:formatDate value="${f.startTime}" pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value="${f.endTime}" pattern="yyyy-MM-dd"/></td>
						<td><a href="javascript:updateAccount(${f.accountId})">修改</a></td>
						<td><a href="javascript:deleteAccount(${f.accountId})" id="delete">删除</a></td>
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
			<a href="javascript:addAccount()" class="myBtn"><em>新增</em></a>
		</div>
		${Account.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteAccount(accountId)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Account/deleteAccount.do";
				$.post(url,{accountId:accountId},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");	
					}
				});
			}
		}
		
		function addAccount(){
			var dg = new $.dialog({
				title:'新增家庭信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Account/getAccount.do?accountId=0'
				});
    		dg.ShowDialog();
		}
		
		function updateAccount(accountId){
			var dg = new $.dialog({
				title:'修改家庭信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Account/getAccount.do?accountId='+accountId
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>