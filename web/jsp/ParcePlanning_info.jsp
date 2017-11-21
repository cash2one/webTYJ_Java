<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宗地规划信息</title>
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
	<form action="/Home/ParcePlanning/AddOrUpdateParcePlanning.do" name="parcePlanningForm" id="parcePlanningForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>宗地信息：</th>
			<td>
				<select name="parceId">
					<option value="0">请选择</option>
					<c:forEach var="p" items="${parces}">
						<option <c:if test="${p.parceId==parcePlanning.parce.parceId}">selected="selected"</c:if> value="${p.parceId}">${p.parceNum}</option>
					</c:forEach>
				</select>
				<input type="hidden" name="parcePlanningId" value="${parcePlanning.parcePlanningId}">
			</td>
		</tr>
		<tr class="info">
			<th>总占地面积</th>
			<td><input type="text" name="occupationArea" value="${parcePlanning.occupationArea}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>容积率:</th>
			<td><input type="text" name="plotRatio" value="${parcePlanning.plotRatio}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>计容面积:</th>
			<td><input type="text" name="calArea" value="${parcePlanning.calArea}"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>核增计容面积:</th>
			<td><input type="text" name="accountCalArea" value="${parcePlanning.accountCalArea}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>核增容积率:</th>
			<td><input type="text" name="accountPlotRatio" class="input_txt" value="${parcePlanning.accountPlotRatio }"/></td>
		</tr>
		<tr class="info">
			<th>建筑密度（覆盖率）:</th>
			<td><input type="text" name="buildingDensity" class="input_txt" value="${parcePlanning.buildingDensity }"/></td>
		</tr>
		<tr class="info">
			<th>商业建筑面积:</th>
			<td><input type="text" name="businessBuildArea" class="input_txt" value="${parcePlanning.businessBuildArea }"/></td>
		</tr>
		<tr class="info">
			<th>计容建筑面积:</th>
			<td><input type="text" name="capacityBuildingArea" class="input_txt" value="${parcePlanning.capacityBuildingArea }"/></td>
		</tr>
		<tr class="info">
			<th>住宅建筑面积:</th>
			<td><input type="text" name="houseBuildArea" class="input_txt" value="${parcePlanning.houseBuildArea }"/></td>
		</tr>
		<tr class="info">
			<th>建设用地面积:</th>
			<td><input type="text" name="constructionLandArea" class="input_txt" value="${parcePlanning.constructionLandArea }"/></td>
		</tr>
		<tr class="info">
			<th>公建建筑面积:</th>
			<td><input type="text" name="surnameBuildArea" class="input_txt" value="${parcePlanning.surnameBuildArea }"/></td>
		</tr>
		<tr class="info">
			<th>公建用地面积:</th>
			<td><input type="text" name="surnameLandArea" class="input_txt" value="${parcePlanning.surnameLandArea }"/></td>
		</tr>
		<tr class="info">
			<th>建筑高度（层数）:</th>
			<td><input type="text" name="buildingHeight" value="${parcePlanning.buildingHeight }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>总体指标平衡:</th>
			<td><input type="text" name="totalTargetBalance" value="${parcePlanning.totalTargetBalance }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>航空限高区间（绝对标高）:</th>
			<td><input type="text" name="absoluteLevel" value="${parcePlanning.absoluteLevel }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>总建筑面积:</th>
			<td><input type="text" name="totalBuildArea" value="${parcePlanning.totalBuildArea }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>其他独立用地面积:</th>
			<td><input type="text" name="otherIndependentLandArea" value="${parcePlanning.otherIndependentLandArea }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>剩余建筑面积:</th>
			<td><input type="text" name="remainBuildArea" value="${parcePlanning.remainBuildArea }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>退红线要求:</th>
			<td><input type="text" name="backLineRequirement" value="${parcePlanning.backLineRequirement }" class="input_txt"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#parcePlanningForm").submit();
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