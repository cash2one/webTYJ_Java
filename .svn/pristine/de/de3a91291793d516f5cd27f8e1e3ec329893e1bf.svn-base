<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Test</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<style type="text/css">
body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:80px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;}
</style>
</head>
<body>
	<form action="/Home/Order/AddorUpdateOrder.do" name="orderForm" id="Form" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">							
		<tr class="info">
			<th>客户id:</th>
			<td>
			<input type="hidden" name="workOrderId" value="${order.workOrderId}">
			<select name="custId" id="personCust.custId" class="input_txt">
						<option value="">请选择</option>
						<c:forEach items="${personCusts}" var="p">
							<option <c:if test="${p.custId==order.personCust.custId}">selected="selected"</c:if> value="${p.custId }">${p.custId }</option>
						</c:forEach>
				</select>
		</td>
		</tr>
		<tr class="info">
			<th>客户名称:</th>
			<td><input type="text" name="lastName" id="lastName" class="input_txt" value="${order.lastName }"/></td>
		</tr>
		<tr class="info">
			<th>房屋id:</th>
			<td>
			<select name="houstId" id="house.id" class="input_txt">
						<option value="">请选择</option>
						<c:forEach items="${houses}" var="p">
							<option <c:if test="${p.id==order.house.id}">selected="selected"</c:if> value="${p.id }">${p.id }</option>
						</c:forEach>
				</select>
		</td>
		</tr>
		<tr class="info">
			<th>房屋名称:</th>
			<td><input type="text" name="houseName" id="houseName" class="input_txt" value="${order.houseName }"/></td>
		</tr>
		<tr class="info">
			<th>服务请求id:</th>
			<td><input type="text" name="sraSrId" id="sraSrId" class="input_txt" value="${order.sraSrId }"/></td>
		</tr>
		<tr class="info">
			<th>企业id:</th>
			<td>
			<select name="enterpriseId" id="enterprise.enterpriseId" class="input_txt">
						<option value="">请选择</option>
						<c:forEach items="${enterprises}" var="p">
							<option <c:if test="${p.enterpriseId==order.enterprise.enterpriseId}">selected="selected"</c:if> value="${p.enterpriseId }">${p.enterpriseId }</option>
						</c:forEach>
				</select>
		</td>
		</tr>
		<tr class="info">
			<th>企业名称:</th>
			<td><input type="text" name="entpriseName" id="entpriseName" class="input_txt" value="${order.entpriseName }"/></td>
		</tr>
		<tr class="info">
			<th>内部请求人员id:</th>
			<td><input type="text" name="askingId" id="askingId" class="input_txt" value="${order.askingId }"/></td>
		</tr>
		<tr class="info">
			<th>内部请求人员:</th>
			<td><input type="text" name="askingName" id="askingName" class="input_txt" value="${order.askingName}" /></td>
		</tr>
	</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		var dg;
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				
				$("#Form").submit();
			});
		});
		
		function success(){
			if(dg.curWin.document.forms[0]){
				dg.curWin.document.forms[0].action = dg.curWin.location+"";
				dg.curWin.document.forms[0].submit();
			}else{
				dg.curWin.location.reload();
			}
			dg.cancel();
		}
		
		function failed(){
			alert("新增失败");
		}
	</script>
</body>
</html>