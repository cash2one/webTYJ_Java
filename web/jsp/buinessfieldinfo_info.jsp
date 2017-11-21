<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
.info th{text-align: right;width:65px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;}
</style>
</head>
<body>
	<form action="/Home/Buinessfieldinfo/AddorUpdateBuinessfieldinfo.do" name="buinesssfieldinfoForm" id="Form" target="result" method="post" onsubmit="return checkInfo();">
		<input type="hidden" name="shopId" id="shop_id" value="${buinessfieldinfo.shopId }"/>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>项目编号:</th>
			<td><input type="text" name="projectNumber" id="projec_number" class="input_txt" value="${buinessfieldinfo.projectNumber }"/></td>
		</tr>
		<tr class="info">
			<th>是否计费:</th>
			<td><input type="text" name="charging" id="charging" value="${buinessfieldinfo.charging }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>管理费单价:</th>
			<td><input type="text" name="maintenancePrice" id="maintenance_price" value="${buinessfieldinfo.maintenancePrice }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>专项资金:</th>
			<td><input type="text" name="specialMoney" id="special_money" value="${buinessfieldinfo.specialMoney }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>区号:</th>
			<td><input type="text" name="areaCode" id="area_code" value="${buinessfieldinfo.areaCode }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>期号:</th>
			<td><input type="text" name="number" id="number" value="${buinessfieldinfo.number }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>座:</th>
			<td><input type="text" name="seat" id="seat" value="${buinessfieldinfo.seat }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>栋号:</th>
			<td><input type="text" name="ridgepole" id="ridgepole" value="${buinessfieldinfo.ridgepole }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>单元:</th>
			<td><input type="text" name="unit" id="unit" value="${buinessfieldinfo.unit }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>楼层:</th>
			<td><input type="text" name="floor" id="floor" value="${buinessfieldinfo.floor }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>楼层区:</th>
			<td><input type="text" name="floorArea" id="floorArea" value="${buinessfieldinfo.floorArea }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>商铺号:</th>
			<td><input type="text" name="shopNumber" id="shopNumber" value="${buinessfieldinfo.shopNumber }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>商铺地址:</th>
			<td><input type="text" name="shopAddress" id="shopAddress" value="${buinessfieldinfo.shopAddress }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>销售状态:</th>
			<td><input type="text" name="salesState" id="salesState" value="${buinessfieldinfo.salesState }" class="input_txt" /></td>
		</tr>
		<tr class="info">
			<th>经营信息:</th>
			<td><input type="text" name="operateMessage" id="operateMessage" value="${buinessfieldinfo.operateMessage }" class="input_txt" /></td>
		</tr>
		
		
	</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	
	<script type="text/javascript" src="../js/lib/jquery/jquery-1.5.1.min.js"></script>
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