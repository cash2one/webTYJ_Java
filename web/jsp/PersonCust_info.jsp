<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户基本信息</title>
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
	<form action="/Home/PersonCust/AddOrUpdatePersonCust.do" name="PersonCustForm" id="PersonCustForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>客户编号：</th>
			<td><input type="text" name="custCode" value="${PersonCust.custCode}" class="input_txt"/>
			<input type="hidden" name="custId" value="${PersonCust.custId}" class="input_txt"/>	</td>
		</tr>
		<tr class="info">
			<th>客户类型：</th>
			<td>
				<select name="custStyle">
					<option <c:if test="${PersonCust.custStyle==0}">selected="selected"</c:if>  value="0">个人</option>
					<option <c:if test="${PersonCust.custStyle==1}">selected="selected"</c:if> value="1">企业</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>姓名:</th>
			<td><input type="text" name="name" value="${PersonCust.name}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>性别:</th>
			<td><input type="radio" name="sex" style="width: 10px;" checked="checked" value="0" class="input_txt"/>男
				<input type="radio" name="sex" <c:if test="${PersonCust.sex==1}">checked="checked"</c:if> style="width: 10px;"  value="1" class="input_txt"/>女
			</td>
		</tr>
		<tr class="info">
			<th>籍贯:</th>
			<td><input type="text" name="nativePlace" value="${PersonCust.nativePlace}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>户口所在地:</th>
			<td><input type="text" name="census" class="input_txt" value="${PersonCust.census }"/></td>
		</tr>
		<tr class="info">
			<th>出生日期:</th>
			<td>
			<input type="text" name="birthday" class="input_txt" onclick="WdatePicker()" value="<fmt:formatDate value="${PersonCust.birthday}" pattern="yyyy-MM-dd"/>"/>   
			</td>
		</tr>
		<tr class="info">
			<th>证件类型:</th>
			<td>
				<select name="cardType">
					<option <c:if test="${PersonCust.cardType==0}">selected="selected"</c:if>  value="0">身份证</option>
					<option <c:if test="${PersonCust.cardType==1}">selected="selected"</c:if> value="1">护照</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>证件号码:</th>
			<td><input type="text" name="cardNum" class="input_txt" value="${PersonCust.cardNum }"/></td>
		</tr>
		<tr class="info">
			<th>家家账号:</th>
			<td><input type="text" name="jiajiaNum" class="input_txt" value="${PersonCust.jiajiaNum }"/></td>
		</tr>
		<tr class="info">
			<th>微信帐号:</th>
			<td><input type="text" name="weixinNum" class="input_txt" value="${PersonCust.weixinNum }"/></td>
		</tr>
		<tr class="info">
			<th>工作单位:</th>
			<td><input type="text" name="workUnits" class="input_txt" value="${PersonCust.workUnits }"/></td>
		</tr>
		<tr class="info">
			<th>职务:</th>
			<td><input type="text" name="position" class="input_txt" value="${PersonCust.position }"/></td>
		</tr>
		<tr class="info">
			<th>婚否:</th>
			<td>
				<input type="radio" name="marrieState" style="width: 10px;" checked="checked" value="0" class="input_txt"/>已婚
				<input type="radio" name="marrieState" <c:if test="${PersonCust.marrieState==1}">checked="checked"</c:if> style="width: 10px;" value="1" class="input_txt"/>未婚
			</td>
		</tr>
		<tr class="info">
			<th>学历:</th>
			<td>
				<select name="eduLevel">
					<option <c:if test="${PersonCust.eduLevel==0}">selected="selected"</c:if>  value="0">本科</option>
					<option <c:if test="${PersonCust.eduLevel==1}">selected="selected"</c:if> value="1">专科</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>社会关系:</th>
			<td><input type="text" name="social" value="${PersonCust.social }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>政治面貌:</th>
			<td>
				<select name="landscape">
					<option <c:if test="${PersonCust.landscape==0}">selected="selected"</c:if>  value="0">党员</option>
					<option <c:if test="${PersonCust.landscape==1}">selected="selected"</c:if> value="1">军人</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>兴趣爱好:</th>
			<td><input type="text" name="hobby" value="${PersonCust.hobby }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>客户等级:</th>
			<td><input type="text" name="custLevel" value="${PersonCust.custLevel }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>是否有企业联系:</th>
			<td>
				<input type="radio" name="isEnterprise" style="width: 10px;" checked="checked" value="0" class="input_txt"/>是
				<input type="radio" name="isEnterprise" <c:if test="${PersonCust.isEnterprise==1}">checked="checked"</c:if> style="width: 10px;" value="1" class="input_txt"/>否
			</td>
		</tr>
		<tr class="info">
			<th>紧急联系人:</th>
			<td><input type="text" name="urgentContactPerson" value="${PersonCust.urgentContactPerson }" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>紧急联系电话:</th>
			<td><input type="text" name="urgentContactPhone" value="${PersonCust.urgentContactPhone }" class="input_txt"/></td>
		</tr>
		</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#PersonCustForm").submit();
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