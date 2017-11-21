<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<style type="text/css">
body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:180px;color: #4f4f4f;padding-top:40px;font-size: 13px;}
.info td{text-align:left;padding-right: 60px;padding-top:40px;}
.aa {color: red;}
</style>
</head>

<body>
	<form action="/Home/Producequote/AddProducequote.do" name="OrderTypeForm" id="OrderTypeForm" target="result" method="post">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td style="width: 200px;">人工费：</td>
			<td colspan="5">
				<select style="width: 270px;" name="produceprice">
	   			<option value="">请选择</option>
	   			<c:forEach items="${produceprices}" var="p">
	   				<option value="${p.productId}">${p.productName}</option>
	   			</c:forEach>
	   			</select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>名称</td>
			<td>单价</td>
			<td>总价</td>
			<td>数量</td>
		</tr>
		<tr>
			<td style="width: 200px;">物料费：</td>
			<td colspan="5">
				<select style="width: 270px;" name="produceprice">
	   			<option value="">请选择</option>
	   			<c:forEach items="${produceprices1}" var="p1">
	   				<option value="${p1.productId}">${p1.productName}</option>
	   			</c:forEach>
	   			</select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>名称</td>
			<td>单价</td>
			<td>总价</td>
			<td>数量</td>
		</tr>
		<tr>
			<td style="width: 200px;">材料费：</td>
			<td colspan="5">
				<select style="width: 270px;" name="produceprice">
	   			<option value="">请选择</option>
	   			<c:forEach items="${produceprices2}" var="p2">
	   				<option value="${p2.productId}">${p2.productName}</option>
	   			</c:forEach>
	   			</select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>名称</td>
			<td>单价</td>
			<td>总价</td>
			<td>数量</td>
		</tr>
		<tr>
			<td style="width: 200px;">措施费：</td>
			<td><input style="width: 200px;" type="text" value="0" name="producepricelists[0].actlAmt"/></td>
		</tr>
		<tr>
			<td style="width: 200px;">措施费理由：</td>
			<td><select style="width: 200px;" name="producepricelists[0].prodCd">
	   			<option value="">请选择</option>
	   			<option value="搭架子费用">搭架子费用</option>
	   			<option value="清洁费用">清洁费用</option>
	   			<option value="其他">其他</option>
	   		</select>
	   		</td>
		</tr>
		<tr>
			<td style="width: 400px;" colspan="2">
	   			<textarea name="producepricelists[0].lineNote" rows="" cols=""></textarea>
	   		</td>
		</tr>
		<tr>
			<td style="width: 200px;">合计费用：</td>
			<td>
				<input id="actlAmt" style="width: 200px;" type="text" readonly="readonly" name="actlAmt"/>
	   		</td>
		</tr>
		<tr>
			<td><input type="submit"  value="提交"/> </td>
		</tr>
	</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	<script type="text/javascript" src="../js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript">
		var index=1;
		
		$("select[name='produceprice']").bind('change',function(){
			var id = $(this).val();
			var obj=$(this);
			$.get("/Home/Producequote/getProducequote.do",{id:id},function(data){
				var json=eval(data);
				var str="<tr><td><input type='hidden' name='producepricelists["+index+"].prdintId' value='"+json['productId']+"'/></td><td><input type='text' name='producepricelists["+index+"].partName'  value='"+json['productName']+"'/></td><td><span>"+json['stdPriUnit']+"</span><input type='hidden'  name='producepricelists["+index+"].baseUnitPri'  value='"+json['stdPriUnit']+"'/></td><td><span class='aa'>"+json['stdPriUnit']+"</span><input type='hidden' name='producepricelists["+index+"].actlAmt'  value='"+json['stdPriUnit']+"'/></td><td><input type='text' style='width: 20px;' name='producepricelists["+index+"].qtyReq' value='1'/></td><td><input type='hidden' name='producepricelists["+index+"].prodCd' value='"+json['type']+"'/></td></tr>";
				obj.parent().parent().next().after(str);
				index++;
			});
		});
	
		$(":input").live('keyup',function(){
			var obj=$(this);
			if(obj.attr("name")!='producepricelists[0].actlAmt')
			{
				var baseUnitPri = obj.parent().prev().prev().first().text();/* 单价 */
				var qtyReq = obj.val();/* 数量 */
				obj.parent().prev().first().text(parseInt(baseUnitPri)*parseInt(qtyReq));
				obj.parent().prev().first().next().attr('value',parseInt(baseUnitPri)*parseInt(qtyReq)); 
				obj.parent().prev().first().attr('class','aa');
			}
			var actlAmt=0;
			$(".aa").each(function(){
				actlAmt+=parseInt($(this).text());
			});
			$("#actlAmt").val(parseInt(actlAmt)+parseInt($("input[name='producepricelists[0].actlAmt']").val()));
		});
	</script>
</body>
</html>