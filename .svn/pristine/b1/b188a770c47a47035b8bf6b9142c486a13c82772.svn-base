<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
.info th{text-align: right;width:80px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;}
</style>
</head>
<body>
	<form action="/Home/Housefieldinfo/AddorUpdateHousefieldinfo.do" name="housefieldinfoForm" id="Form" target="result" method="post">
	<table border="0" cellpadding="0" cellspacing="0">							
		<tr class="info">
			<th>项目编号:</th>			
			<td><input type="text" name="projectNumber" id="projectNumber" class="input_txt" value="${housefieldinfo.projectNumber }"/>
			<input type="hidden" name="homeid" value="${housefieldinfo.homeid}"></td>
		</tr>
		<tr class="info">
			<th>项目名称:</th>
			<td><input type="text" name="projectName" id="projectName" class="input_txt" value="${housefieldinfo.projectName }"/></td>
		</tr>
		<tr class="info">
			<th>销售状态:</th>
			<td><input type="text" name="salesState" id="salesState" class="input_txt" value="${housefieldinfo.salesState }"/></td>
		</tr>
		<tr class="info">
			<th>入伙状态:</th>
			<td><input type="text" name="intakeState" id="intakeState" class="input_txt" value="${housefieldinfo.intakeState }"/></td>
		</tr>
		<tr class="info">
			<th>租赁状态:</th>
			<td><input type="text" name="rentState" id="rentState" class="input_txt" value="${housefieldinfo.rentState }"/></td>
		</tr>
		<tr class="info">
			<th>交易信息:</th>
			<td><input type="text" name="tradeMessage" id="tradeMessage" class="input_txt" value="${housefieldinfo.tradeMessage }"/></td>
		</tr>
		<tr class="info">
			<th>经营信息:</th>
			<td><input type="text" name="operateMessage" id="operateMessage" class="input_txt" value="${housefieldinfo.operateMessage }"/></td>
		</tr>
		<tr class="info">
			<th>装修信息:</th>
			<td><input type="text" name="decorateMessage" id="decorateMessage" class="input_txt" value="${ housefieldinfo.decorateMessage }"/></td>
		</tr>
		<tr class="info">
			<th>租赁信息:</th>
			<td><input type="text" name="rentMessage" id="rentMessage" class="input_txt" value="${ housefieldinfo.rentMessage }"/></td>
		</tr>
		<tr class="info">
			<th>加建信息:</th>
			<td><input type="text" name="addition" id="addition" class="input_txt" value="${ housefieldinfo.addition }"/></td>
		</tr>
		<tr class="info">
			<th>房屋用户id:</th>
			<td>
				<select name="customerbaseinfo.custcode" id="customerbaseinfo.custcode" class="input_txt">
						<option value="">请选择</option>
						<c:forEach items="${customerbaseinfos}" var="c">
							<option <c:if test="${c.custcode==housefieldinfo.customerbaseinfo.custcode}">selected="selected"</c:if> value="${c.custcode }">${c.custcode }</option>
						</c:forEach>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>密码:</th>
			<td><input type="text" name="password" id="password" class="input_txt" value="${ housefieldinfo.password }"/></td>
		</tr>
	</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
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