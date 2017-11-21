<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户车辆信息</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<link rel="stylesheet" type="text/css" href="../js/lib/EasyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../js/lib/EasyUI/themes/icon.css">
<style type="text/css">
body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:180px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;padding-left: 20px}
</style>
<script type="text/javascript" src="../js/lib/jquery/jquery-1.5.1.min.js"></script>
</head>
<body>
	<form action="/Home/CarInfo/AddOrUpdateCarInfo.do" name="CarInfoForm" id="CarInfoForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>客户编号：</th>
			<td>
				<select name="personId">
					<option value="0">请选择</option>
					<c:forEach var="c" items="${personCusts}">
						<option <c:if test="${c.custId==CarInfo.personCust.custId}">selected="selected"</c:if> value="${c.custId}">${c.custCode}</option>
					</c:forEach>
				</select>
				<input type="hidden" name="carId" value="${CarInfo.carId}" class="input_txt"/>
			</td>
		</tr>
		<tr class="info">
			<th>车牌号码:</th>
			<td><input type="text" name="carNum" value="${CarInfo.carNum}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>车辆品牌:</th>
			<td><input type="text" name="carBrand" value="${CarInfo.carBrand}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>车辆类型:</th>
			<td>
				<select name="carType">
					<option <c:if test="${CarInfo.carType==0}">selected="selected"</c:if> value="0">小型汽车</option>
					<option <c:if test="${CarInfo.carType==1}">selected="selected"</c:if> value="1">中型汽车</option>
					<option <c:if test="${CarInfo.carType==2}">selected="selected"</c:if> value="2">大型汽车</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>车辆型号:</th>
			<td>
				<select name="carStyle">
					<option <c:if test="${CarInfo.carStyle==0}">selected="selected"</c:if> value="0">小轿车</option>
					<option <c:if test="${CarInfo.carStyle==1}">selected="selected"</c:if> value="1">货车</option>
					<option <c:if test="${CarInfo.carStyle==2}">selected="selected"</c:if> value="2">suv</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>发动机号码:</th>
			<td><input type="text" name="engineNum" class="input_txt" value="${CarInfo.engineNum }"/></td>
		</tr>
		<tr class="info">
			<th>车辆识别代号:</th>
			<td><input type="text" name="discriminateCode" class="input_txt" value="${CarInfo.discriminateCode }"/></td>
		</tr>
		<tr class="info">
			<th>核定载客:</th>
			<td><input type="text" name="passengers" class="input_txt" value="${CarInfo.passengers }"/></td>
		</tr>
		<tr class="info">
			<th>车辆颜色:</th>
			<td><input type="text" name="carColor" class="input_txt" value="${CarInfo.carColor }"/></td>
		</tr>
		<tr class="info">
			<th>注册登记日期:</th>
			<td><input type="text" name="regeditDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${CarInfo.regeditDate}" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>发证日期:</th>
			<td><input type="text" name="certificationDate" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${CarInfo.certificationDate}" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>交易类型:</th>
			<td>
			<select name="businessStyle">
					<option <c:if test="${CarInfo.businessStyle==0}">selected="selected"</c:if> value="0">现金</option>
					<option <c:if test="${CarInfo.businessStyle==1}">selected="selected"</c:if> value="1">支付宝</option>
					<option <c:if test="${CarInfo.businessStyle==2}">selected="selected"</c:if> value="2">信用卡</option>
				</select>
			</td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#CarInfoForm").submit();
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
			alert("操作失败");
		}
	</script>
</body>
</html>