<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加索赔申请</title>
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
	<form action="/Home/Claim/addClaim.do" name="AddwoForm" id="AddwoForm" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>项目名称：</th>
			<td>
				<input type="text" class="input_txt" name="projectName"/>
			</td>
		</tr>
		<tr class="info">
			<th>关联工单编号：</th>
			<td>
				<input type="text" class="input_txt" name="orderId"/>
			</td>
		</tr>
		<tr class="info">
			<th>索赔工单编号:</th>
			<td><input type="text" name="claimorderId"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>客户:</th>
			<td><input type="text" name="clientele" value="${Addwo.todoCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>相关联系人:</th>
			<td><input type="text" name="manageContacts" value="${Addwo.subtypeCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>联系电话:</th>
			<td><input type="text" name="contactsPhone" value="${Addwo.subtypeCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>地区:</th>
			<td><input type="text" name="region" value="${Addwo.calTypeCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>项目:</th>
			<td><input type="text" name="project" value="${Addwo.objectiveCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>区</th>
			<td><input type="text" name="area" value="${Addwo.prSymptomCd}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>楼栋</th>
			<td><input type="text" name="floor" value="${Addwo.billableFlg}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>楼层</th>
			<td><input type="text" name="floor" value="${Addwo.owner}" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>索赔对象</th>
			<td><input type="text" name="claimObject" value="${Addwo.ownerNum}" class="input_txt"/></td>
		</tr>
		
		
		<tr class="info">
			<th>赔付类型</th>
			<td><input type="text" name="claimtype.typename" value="车位费" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>开始时间</th>
			<td><input type="text" name="claimtype.startdate" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>结束时间</th>
			<td><input type="text" name="claimtype.enddate"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>单价：</th>
			<td><input type="text" name="claimtype.price"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>月份：</th>
			<td><input type="text" name="claimtype.month" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>总金额：</th>
			<td><input type="text" name="claimtype.totalmoney"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>赔付类型</th>
			<td><input type="text" name="claimtype.typename" value="物业管理费" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>开始时间</th>
			<td><input type="text" name="claimtype.startdate" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>结束时间</th>
			<td><input type="text" name="claimtype.enddate"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>单价：</th>
			<td><input type="text" name="claimtype.price"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>月份：</th>
			<td><input type="text" name="claimtype.month" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>总金额：</th>
			<td><input type="text" name="claimtype.totalmoney"  class="input_txt"/></td>
		</tr>
		<tr>
			<th>具体描述：</th>
			<td><input type="text" name="claimtype.startdate"  class="input_txt"/></td>
		</tr>
		
		</table>
	<input  type="submit" value="提交"/>
	
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#AddwoForm").submit();
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