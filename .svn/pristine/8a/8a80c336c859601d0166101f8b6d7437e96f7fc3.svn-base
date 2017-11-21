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
	<form action="/Home/Projectfieldinfo/AddorUpdateProjectfieldinfo.do" name="projectfieldinfoForm" id="projectfieldinfoForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>宗地信息：</th>
			<td>
				<input style="height:28px;width:200px" class="easyui-combobox" id="cc" name="cc" multiple="true" panelheight="auto" editable="false"/>
			</td>
			<td>关联宗地信息可多选</td>
		</tr>
		<tr class="info">
			<th>项目名称:</th>
			<td>
			<input type="text" name="projectName" id="projectfieldinfo.projectName" class="input_txt" value="${projectfieldinfo.projectName }"/>
			<input type="hidden" name="projectId" value="${projectfieldinfo.projectId}">
 			</td>
		</tr>
		<tr class="info">
			<th>项目编号:</th>
			<td><input type="text" name="projectNumber" value="${projectfieldinfo.projectNumber }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>项目总占地面积:</th>
			<td><input type="text" name="projectTotalArea" value="${projectfieldinfo.projectTotalArea }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>容积率:</th>
			<td><input type="text" name="plotRatio" value="${projectfieldinfo.plotRatio }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>核增容积率:</th>
			<td><input type="text" name="addPlotRatio" class="input_txt" value="${projectfieldinfo.addPlotRatio }"/></td>
		</tr>
		<tr class="info">
			<th>绿化率:</th>
			<td><input type="text" name="greeningRate" class="input_txt" value="${projectfieldinfo.greeningRate }"/></td>
		</tr>
		<tr class="info">
			<th>总建筑面积:</th>
			<td><input type="text" name="totalBuildArea" class="input_txt" value="${projectfieldinfo.totalBuildArea }"/></td>
		</tr>
		<tr class="info">
			<th>计容面积:</th>
			<td><input type="text" name="capacitanceArea" class="input_txt" value="${projectfieldinfo.capacitanceArea }"/></td>
		</tr>
		<tr class="info">
			<th>核增计容面积:</th>
			<td><input type="text" name="addCapacitanceArea" class="input_txt" value="${projectfieldinfo.addCapacitanceArea }"/></td>
		</tr>
		<tr class="info">
			<th>地下室面积:</th>
			<td><input type="text" name="basementArea" class="input_txt" value="${projectfieldinfo.basementArea }"/></td>
		</tr>
		<tr class="info">
			<th>车位配比:</th>
			<td><input type="text" name="stallMatching" class="input_txt" value="${projectfieldinfo.stallMatching }"/></td>
		</tr>
		<tr class="info">
			<th>地下车位总数:</th>
			<td><input type="text" name="undergroundParkingSpacesTotal" class="input_txt" value="${projectfieldinfo.undergroundParkingSpacesTotal }"/></td>
		</tr>
		<tr class="info">
			<th>地面车位总数:</th>
			<td><input type="text" name="groundParkingSpaceTotal" class="input_txt" value="${projectfieldinfo.groundParkingSpaceTotal }"/></td>
		</tr>
		<tr class="info">
			<th>全地址:</th>
			<td><input type="text" name="fullAddress" value="${projectfieldinfo.fullAddress }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>邮编:</th>
			<td><input type="text" name="postcode" value="${projectfieldinfo.postcode }" class="input_txt"/></td>
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
				url:'/Home/Projectfieldinfo/listAllParcelinfo.do',
				valueField:'parcelNumber',
				textField:'parcelNumber',
				onLoadSuccess: function () { //数据加载完毕事件
					if('${projectfieldinfo.projectId}'!=0){
						$.post("/Home/Projectfieldinfo/getProfamilyByProjectId.do",{projectId:'${projectfieldinfo.projectId}'},function(data){
							var json=eval(data);
							for (var i= 0;i<json.length;i++) {
								$('#cc').combobox('select',json[i]['parcelId']);
							}
						});
					}
                 }
			}); 
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#projectfieldinfoForm").submit();
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