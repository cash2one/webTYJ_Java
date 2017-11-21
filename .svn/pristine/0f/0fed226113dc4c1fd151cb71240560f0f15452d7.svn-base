<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>宗地信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>宗地编号</th>
				<th>用地类型</th>
				<th>地理区位</th>
				<th>开发类型</th>
				<th>土地性质</th>
				<th>交易方式</th>
				<th>开发期限起</th>	
				<th>开发期限止</th>
				<th>土地价格</th>
				<th>土地亩价</th>
				<th>是否独立项目</th>
				<th>土地条件</th>
				<th>省</th>
				<th>市</th>
				<th>区</th>
				<th>街道</th>
				<th>全地址</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty Parces }">
				<c:forEach items="${Parces}" var="p" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${p.parceId}"/>${s.count}</td>
						<td>${p.parceNum}</td>			
						<td>${p.landKind}</td>
						<td>${p.geographyArea}</td>
						<td>
							<c:choose>
                                <c:when test="${p.developKind==0}">
                                   	 一次开发	
                                </c:when>
       							<c:when test="${p.developKind==1}">
                                   	 二次开发	
                                </c:when>
                            </c:choose>
						</td>						
						<td>${p.landProperties}</td>
						<td>
							<c:choose>
                                <c:when test="${p.tradeWay==0}">
                                   	 现金	
                                </c:when>
       							<c:when test="${p.tradeWay==1}">
                                   	支付宝	
                                </c:when>
                                <c:when test="${p.tradeWay==2}">
                                   	信用卡
                                </c:when>
                            </c:choose>
						</td>
						<td><fmt:formatDate value="${p.developTimeStart}" pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value="${p.developTimeEnd}" pattern="yyyy-MM-dd"/></td>
						<td>${p.landPrice}</td>
						<td>${p.landUnitPrice}</td>
						<td>
							<c:choose>
                                <c:when test="${p.isIndep==0}">
                                   	是
                                </c:when>
       							<c:when test="${p.isIndep==1}">
                                   	 否	
                                </c:when>
                            </c:choose>
						</td>
					 	<td>${p.totalLandArea}</td>
					 	<td>
					 		<c:choose>
                                <c:when test="${p.province==0}">
                                   	湖北省	
                                </c:when>
       							<c:when test="${p.province==1}">
                                   	湖南省
                                </c:when>
                                <c:when test="${p.province==2}">
                                   	广州省
                                </c:when>
                            </c:choose>
					 	</td>
					 	<td>
					 		<c:choose>
                                <c:when test="${p.city==0}">
                                   	武汉市
                                </c:when>
       							<c:when test="${p.city==1}">
                                   	随州市
                                </c:when>
                                <c:when test="${p.city==2}">
                                   	北京市
                                </c:when>
                            </c:choose>
					 	</td>
					 	<td>
					 		<c:choose>
                                <c:when test="${p.area==0}">
                                   	洪山区
                                </c:when>
       							<c:when test="${p.area==1}">
                                   	武昌区
                                </c:when>
                                <c:when test="${p.area==2}">
                                   	曾都区
                                </c:when>
                            </c:choose>
					 	</td>
					 	<td>
					 		<c:choose>
                                <c:when test="${p.street==0}">
                                   	步行街
                                </c:when>
       							<c:when test="${p.street==1}">
                                   	汉孟路
                                </c:when>
                                <c:when test="${p.street==2}">
                                   	解放路
                                </c:when>
                            </c:choose>
					 	</td>
					 	<td>${p.address}</td>
						<td><a href="javascript:updateParce(${p.parceId})">修改</a></td>
						<td><a href="javascript:deleteParce(${p.parceId})">删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="20">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addParce()" class="myBtn"><em>新增</em></a>
		</div>
		${parces.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteParce(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/Parce/deleteParce.do";
				$.post(url,{id:id},function(data){
					if(data=="success"){
						document.location.reload();
					}else
					{
						alert("删除失败！");	
					}
				});
			}
		}
		
		function addParce(){
			var dg = new $.dialog({
				title:'新增项目字段信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Parce/getParce.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateParce(id){
			var dg = new $.dialog({
				title:'修改项目字段信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'Parce/getParce.do?id='+id
				});
    		dg.ShowDialog();
		}
		</script>
</body>
</html>