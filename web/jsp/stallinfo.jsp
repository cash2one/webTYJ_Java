<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Test</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<link rel="stylesheet" type="text/css" href="../js/lib/EasyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../js/lib/EasyUI/themes/icon.css">
<style type="text/css">
body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:120px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;padding-left: 20px}
</style>
<script type="text/javascript" src="../js/lib/jquery/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="../js/lib/EasyUI/jquery.easyui.min.js"></script>
</head>
<body>
	<form action="/Home/Stall/AddorUpdateStall.do" name="stallForm" id="stallForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>管理费单价:</th>
			<td>
			<input type="hidden" name="stallId" class="input_txt" value="${stall.stallId}"/>
			<input type="text" name="maintenancePrice" class="input_txt" value="${stall.maintenancePrice }"/>
 			</td>
		</tr>
		<tr class="info">
			<th>车库编号:</th>
			<td>
				<select name="garageId" id="garagefield.garageId" class="input_txt">
						<option value="">请选择</option>
						<c:forEach items="${garagefields}" var="p">
							<option <c:if test="${p.garageId==stall.garagefield.garageId}">selected="selected"</c:if> value="${p.garageId }">${p.garageId }</option>
						</c:forEach>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>个人客户id:</th>
			<td>
				<select name="personId" id="personCust.custId" class="input_txt">
						<option value="">请选择</option>
						<c:forEach items="${personCusts}" var="p">
							<option <c:if test="${p.custId==stall.personCust.custId}">selected="selected"</c:if> value="${p.custId }">${p.custId }</option>
						</c:forEach>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>楼层号:</th>
			<td><input type="text" name="floorNumber" id="floorNumber" value="${stall.floorNumber }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>所在区:</th>
			<td><input type="text" name="bairro" id="bairro" class="input_txt" value="${stall.bairro }"/></td>
		</tr>
		<tr class="info">
			<th>车位号:</th>
			<td><input type="text" name="stallNumber" id="stallNumber" class="input_txt" value="${stall.stallNumber }"/></td>
		</tr>
		<tr class="info">
			<th>是否机械车位:</th>
			<td><input type="text" name="isMechanicalStall" id="isMechanicalStall" class="input_txt" value="${stall.isMechanicalStall }"/></td>
		</tr>
		<tr class="info">
			<th>车位位置:</th>
			<td><input type="text" name="stallPosition"  id="stallPosition" class="input_txt" value="${stall.stallPosition }"/></td>
		</tr>
		<tr class="info">
			<th>车位属性:</th>
			<td><input type="text" name="stallProperty" id="stallProperty" class="input_txt" value="${stall.stallProperty }"/></td>
		</tr>
		<tr class="info">
			<th>是否固定车位:</th>
			<td><input type="text" name="fixedParking" id="fixedParking" class="input_txt" value="${stalls.fixedParking }"/></td>
		</tr>
		<tr class="info">
			<th>竣工日期:</th>
			<td><input type="text" name="completionDate"  id="completionDate" class="input_txt" value="<fmt:formatDate value="${stall.completionDate }" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>入伙日期:</th>
			<td><input type="text" name="intakeDate" id="intakeDate" class="input_txt" value="<fmt:formatDate value="${stall.intakeDate }" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>销售状态:</th>
			<td><input type="text" name="salesState" id="salesState" value="${stall.salesState }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>入伙状态:</th>
			<td><input type="text" name="intakeState" id="intakeState" value="${stall.intakeState }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>租赁状态:</th>
			<td><input type="text" name="rentState" id="rentState" value="${stalls.rentState }" class="input_txt"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#stallForm").submit();
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