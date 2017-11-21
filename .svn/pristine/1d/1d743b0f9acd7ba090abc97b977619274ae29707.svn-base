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
<script type="text/javascript" src="../js/lib/EasyUI/jquery.easyui.min.js"></script>
</head>
<body>
	<form action="/Home/Parcelinfo/AddorUpdateParcelinfo.do" name="parcelinfoForm" id="parcelinfoForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>项目字段信息：</th>
			<td>
				<input style="height:28px;width:200px" class="easyui-combobox" id="cc" name="cc" multiple="true" panelheight="auto" editable="false"/>
			</td>
			<td>关联项目字段信息可多选</td>
		</tr>
		<tr class="info">
			<th>用地类型</th>
			<td>
				<input type="text" name="landKind" class="input_txt" value="${parcelinfo.landKind }"/>
				<input type="hidden" name="parcelNumber" value="${parcelinfo.parcelNumber}">
			</td>
		</tr>
		<tr class="info">
			<th>开发类型:</th>
			<td><input type="text" name="developKind" class="input_txt" value="${parcelinfo.developKind }"/></td>
		</tr>
		<tr class="info">
			<th>交易方式:</th>
			<td><input type="text" name="tradeWay" value="${parcelinfo.tradeWay }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>开发期限起:</th>
			<td><input type="text" name="developTimeStart" onclick="WdatePicker()" value="<fmt:formatDate value="${parcelinfo.developTimeStart }"/>"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>开发期限止:</th>
			<td><input type="text" name="developTimeEnd" onclick="WdatePicker()" value="<fmt:formatDate value="${parcelinfo.developTimeEnd }"/>" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>土地价格:</th>
			<td><input type="text" name="landPrice" class="input_txt" value="${parcelinfo.landPrice }"/></td>
		</tr>
		<tr class="info">
			<th>土地性质:</th>
			<td><input type="text" name="landNature" class="input_txt" value="${parcelinfo.landNature }"/></td>
		</tr>
		<tr class="info">
			<th>独立项目:</th>
			<td><input type="text" name="independentProject" class="input_txt" value="${parcelinfo.independentProject }"/></td>
		</tr>
		<tr class="info">
			<th>土地条件:</th>
			<td><input type="text" name="landCondition" class="input_txt" value="${parcelinfo.landCondition }"/></td>
		</tr>
		<tr class="info">
			<th>总用地面积:</th>
			<td><input type="text" name="totalLandArea" class="input_txt" value="${parcelinfo.totalLandArea }"/></td>
		</tr>
		<tr class="info">
			<th>总建筑面积:</th>
			<td><input type="text" name="totalBuildArea" class="input_txt" value="${parcelinfo.totalBuildArea }"/></td>
		</tr>
		<tr class="info">
			<th>车位配比:</th>
			<td><input type="text" name="capacityBuildingArea" class="input_txt" value="${parcelinfo.capacityBuildingArea }"/></td>
		</tr>
		<tr class="info">
			<th>容积率:</th>
			<td><input type="text" name="volumeRate" class="input_txt" value="${parcelinfo.volumeRate }"/></td>
		</tr>
		<tr class="info">
			<th>土地亩价:</th>
			<td><input type="text" name="landUnitPrice" class="input_txt" value="${parcelinfo.landUnitPrice }"/></td>
		</tr>
		<tr class="info">
			<th>折合楼面价:</th>
			<td><input type="text" name="atFloorPrice" value="${parcelinfo.atFloorPrice }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>建设用地面积:</th>
			<td><input type="text" name="constructionLandArea" value="${parcelinfo.constructionLandArea }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>住宅建筑面积:</th>
			<td><input type="text" name="houseBuildArea" value="${parcelinfo.houseBuildArea }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>商业建筑面积:</th>
			<td><input type="text" name="businessBuildArea" value="${parcelinfo.businessBuildArea }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>公建建筑面积:</th>
			<td><input type="text" name="surnameBuildArea" value="${parcelinfo.surnameBuildArea }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>剩余建筑面积:</th>
			<td><input type="text" name="remainBuildArea" value="${parcelinfo.remainBuildArea }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>公建用地面积:</th>
			<td><input type="text" name="surnameLandArea" value="${parcelinfo.surnameLandArea }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>其他独立用地面积:</th>
			<td><input type="text" name="otherIndependentLandArea" value="${parcelinfo.otherIndependentLandArea }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>建筑密度（覆盖率）:</th>
			<td><input type="text" name="buildingDensity" value="${parcelinfo.buildingDensity }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>机动车泊位数:</th>
			<td><input type="text" name="vehicleParkingSpace" value="${parcelinfo.vehicleParkingSpace }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>航空限高区间（绝对标高）:</th>
			<td><input type="text" name="absoluteLevel" value="${parcelinfo.absoluteLevel }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>建筑高度（层数）:</th>
			<td><input type="text" name="buildingHeight" value="${parcelinfo.buildingHeight }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>地理区位:</th>
			<td><input type="text" name="geographicalPositionArea" value="${parcelinfo.geographicalPositionArea }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>退红线要求:</th>
			<td><input type="text" name="backLineRequirement" value="${parcelinfo.backLineRequirement }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>总体指标平衡:</th>
			<td><input type="text" name="totalTargetBalance" value="${parcelinfo.totalTargetBalance }" class="input_txt"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$.ajaxSetup({
		        async: false//设置post请求为同步请求
		    });
			$('#cc').combobox({ 
				url:'/Home/Parcelinfo/listAllProjectfieldinfo.do',
				valueField:'projectId',
				textField:'projectName',
				onLoadSuccess: function () { //数据加载完毕事件
					if('${parcelinfo.parcelNumber}'!=0){
						$.post("/Home/Parcelinfo/getProjectfieldinfoByParcelId.do",{ParcelId:'${parcelinfo.parcelNumber}'},function(data){
							var json=eval(data);
							for (var i= 0;i<json.length;i++) {
								$('#cc').combobox('select',json[i]['projectId']);
							}
						});
					}
                 }
			}); 
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#parcelinfoForm").submit();
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