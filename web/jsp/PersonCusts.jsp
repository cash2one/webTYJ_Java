<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>客户基本信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>客户编号</th>
				<th>客户类型</th>
				<th>姓名</th>
				<th>性别</th>
				<th>籍贯</th>
				<th>户口所在地</th>
				<th>出生日期</th>	
				<th>证件类型</th>
				<th>证件号码</th>
				<th>家家账号</th>
				<th>微信帐号</th>
				<th>工作单位</th>
				<th>客户等级</th>
				<th>紧急联系人</th>
				<th>紧急联系电话</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty PersonCusts }">
				<c:forEach items="${PersonCusts}" var="p" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${p.custId}"/>${s.count}</td>
						<td>${p.custCode}</td>			
						<td>
							<c:if test="${p.custStyle==0}">
								个人
							</c:if>
							<c:if test="${p.custStyle==1}">
								企业
							</c:if>
						</td>
						<td>${p.name}</td>
						<td>
							<c:if test="${p.sex==0}">
								男
							</c:if>
							<c:if test="${p.sex==1}">
								女
							</c:if>
						</td>						
						<td>${p.nativePlace}</td>
						<td>${p.census}</td>
						<td><fmt:formatDate value="${p.birthday}" pattern="yyyy-MM-dd"/></td>
						<td>
							<c:if test="${p.cardType==0}">
								身份证
							</c:if>
							<c:if test="${p.cardType==1}">
								护照
							</c:if>
						</td>
						<td>${p.cardNum}</td>
						<td>${p.jiajiaNum}</td>
						<td>${p.weixinNum}</td>
					 	<td>${p.workUnits}</td>
					 	<td>${p.custLevel}</td>
					 	<td>${p.urgentContactPerson}</td>
					 	<td>${p.urgentContactPhone}</td>
						<td><a href="javascript:updatePersonCust(${p.custId})">修改</a></td>
						<td><a href="javascript:deletePersonCust(${p.custId})">删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="18">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addPersonCust()" class="myBtn"><em>新增</em></a>
		</div>
		${personCust.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deletePersonCust(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/PersonCust/deletePersonCust.do";
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
		
		function addPersonCust(){
			var dg = new $.dialog({
				title:'新增客户基本信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'PersonCust/getPersonCust.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updatePersonCust(id){
			var dg = new $.dialog({
				title:'修改客户基本信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'PersonCust/getPersonCust.do?id='+id
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>