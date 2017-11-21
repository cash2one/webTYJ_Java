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
	<form action="/Home/Parce/AddorUpdateParce.do" name="ParceForm" id="ParceForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>项目信息：</th>
			<td>
				<input style="height:28px;width:200px" class="easyui-combobox" id="cc" name="cc" multiple="true" panelheight="auto" editable="false"/>
			</td>
			<td>关联项目信息可多选</td>
		</tr>
		<tr class="info">
			<th>宗地编号:</th>
			<td>
			<input type="text" name="parceNum" class="input_txt" value="${Parce.parceNum }"/>
			<input type="hidden" name="parceId" value="${Parce.parceId}">
 			</td>
		</tr>
		<tr class="info">
			<th>用地类型:</th>
			<td><input type="text" name="landKind" value="${Parce.landKind }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>地理区位:</th>
			<td><input type="text" name="geographyArea" value="${Parce.geographyArea }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>开发类型:</th>
			<td>
				<select name="developKind">
					<option value="0" <c:if test="${Parce.developKind==0}">selected="selected"</c:if>>一次开发</option>
					<option value="1" <c:if test="${Parce.developKind==0}">selected="selected"</c:if>>二次开发</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>土地性质:</th>
			<td><input type="text" name="landProperties" class="input_txt" value="${Parce.landProperties }"/></td>
		</tr>
		<tr class="info">
			<th>交易方式:</th>
			<td>
				<select name="tradeWay">
					<option value="0" <c:if test="${Parce.tradeWay==0}">selected="selected"</c:if>>现金</option>
					<option value="1" <c:if test="${Parce.tradeWay==1}">selected="selected"</c:if>>支付宝</option>
					<option value="2" <c:if test="${Parce.tradeWay==2}">selected="selected"</c:if>>信用卡</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>开发期限起:</th>
			<td><input type="text" name="developTimeStart"  class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${Parce.developTimeStart}" pattern="yyyy-MM-dd"/>" /></td>
		</tr>
		<tr class="info">
			<th>开发期限止:</th>
			<td><input type="text" name="developTimeEnd" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${Parce.developTimeEnd}" pattern="yyyy-MM-dd"/>"/></td>
		</tr>
		<tr class="info">
			<th>土地价格:</th>
			<td><input type="text" name="landPrice" class="input_txt" value="${Parce.landPrice }"/></td>
		</tr>
		<tr class="info">
			<th>土地亩价:</th>
			<td><input type="text" name="landUnitPrice" class="input_txt" value="${Parce.landUnitPrice }"/></td>
		</tr>
		<tr class="info">
			<th>是否独立项目:</th>
			<td>
				<input type="radio"  name="isIndep" checked="checked" value="0"/>是
				<input type="radio" <c:if test="${Parce.isIndep==1}">checked="checked"</c:if> name="isIndep" value="1"/>否
			</td>
		</tr>
		<tr class="info">
			<th>土地条件:</th>
			<td><input type="text" name="totalLandArea" class="input_txt" value="${Parce.totalLandArea }"/></td>
		</tr>
		<tr class="info">
			<th>省:</th>
			<td>
				<select name="province">
					<option value="0" <c:if test="${Parce.province==0}">selected="selected"</c:if>>湖北省</option>
					<option value="1" <c:if test="${Parce.province==1}">selected="selected"</c:if>>湖南省</option>
					<option value="2" <c:if test="${Parce.province==2}">selected="selected"</c:if>>广州省</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>市:</th>
			<td>
				<select name="city">
					<option value="0" <c:if test="${Parce.city==0}">selected="selected"</c:if>>武汉市</option>
					<option value="1" <c:if test="${Parce.city==1}">selected="selected"</c:if>>随州市</option>
					<option value="2" <c:if test="${Parce.city==2}">selected="selected"</c:if>>上海市</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>区:</th>
			<td>
				<select name="area">
					<option value="0" <c:if test="${Parce.area==0}">selected="selected"</c:if>>洪山区</option>
					<option value="1" <c:if test="${Parce.area==1}">selected="selected"</c:if>>武昌区</option>
					<option value="2" <c:if test="${Parce.area==2}">selected="selected"</c:if>>曾都区</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>街道:</th>
			<td>
				<select name="street">
					<option value="0" <c:if test="${Parce.street==0}">selected="selected"</c:if>>步行街</option>
					<option value="1" <c:if test="${Parce.street==1}">selected="selected"</c:if>>汉孟路</option>
					<option value="2" <c:if test="${Parce.street==2}">selected="selected"</c:if>>解放路</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>全地址:</th>
			<td><input type="text" name="address" value="${Parce.address }" class="input_txt"/></td>
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
				url:'/Home/Parce/listAllParceProject.do',
				valueField:'projectId',
				textField:'projectNumber',
				onLoadSuccess: function () { //数据加载完毕事件
					if('${Parce.parceId}'!=0){
						$.post("/Home/Parce/listParceProjectByParceId.do",{ParceId:'${Parce.parceId}'},function(data){
							var json=eval(data);
							for (var i= 0;i<json.length;i++) {
								$('#cc').combobox('select',json[i]['project']['projectId']);
							}
						});
					}
                 }
			}); 
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#ParceForm").submit();
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
			alert("操作失败！");
		}
	</script>
</body>
</html>