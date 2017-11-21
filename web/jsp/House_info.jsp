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
.info th{text-align: right;width:180px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;padding-left: 20px}
</style>
<script type="text/javascript" src="../js/lib/jquery/jquery-1.5.1.min.js"></script>
</head>
<body>
	<form action="/Home/House/AddorUpdateHouse.do" name="HouseForm" id="HouseForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">		
		
		<tr class="info">
			<th>项目id:</th>
			<td><input type="text" name="projectId" value="${house.projectId}" class="input_txt"/>
			<input type="hidden" name="id" value="${house.id}">
			</td>
			
		</tr>
		<tr class="info">
			<th>客户id:</th>
			<td><input type="text" name="custId" value="${house.custId}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>房屋编号:</th>
			<td><input type="text" name="houseId" value="${house.houseId}" class="input_txt"/></td>
		</tr>
		
		<tr class="info">
			<th>商铺编号:</th>
			<td><input type="text" name="shopId" value="${house.shopId}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>小区期号:</th>
			<td><input type="text" name="estateIssue" value="${house.estateIssue}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>小区区号:</th>
			<td><input type="text" name="estateAreacode" value="${house.estateAreacode}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>栋号:</th>
			<td><input type="text" name="ridgeNum" value="${house.ridgeNum}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>座号:</th>
			<td><input type="text" name="seatNum" value="${house.seatNum}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>单元:</th>
			<td><input type="text" name="unit" value="${house.unit}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>楼层:</th>
			<td><input type="text" name="floor" value="${house.floor}" class="input_txt"/></td>
		</tr>
		
		<tr class="info">
			<th>楼层区:</th>
			<td><input type="text" name="floorarea" value="${house.floorarea}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>房号:</th>
			<td><input type="text" name="roomNum" value="${house.roomNum}" class="input_txt"/></td>
		</tr>
		
		<tr class="info">
			<th>门牌号:</th>
			<td><input type="text" name="gateNum" value="${house.gateNum}" class="input_txt"/></td>
		</tr>
		
		
		<tr class="info">
			<th>入伙日期:</th>
			<td><input type="text" name="joinDate" onclick="WdatePicker()" value="<fmt:formatDate value="${house.joinDate}"/>"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>入伙状态:</th>
			<td>
				<select name="joinState">
					<option <c:if test="${house.joinState==1}">selected="selected"</c:if> value="1">已入伙</option>
					<option <c:if test="${house.joinState==2}">selected="selected"</c:if> value="2">未入伙</option>
				</select>
			</td>		</tr>
		<tr class="info">
			<th>销售状态:</th>
			<td>
				<select name="marketState">
					<option <c:if test="${house.marketState==1}">selected="selected"</c:if> value="1">已销售</option>
					<option <c:if test="${house.marketState==2}">selected="selected"</c:if> value="2">未销售</option>
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
				$("#HouseForm").submit();
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