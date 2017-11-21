<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>客户车辆信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>客户编号</th>
				<th>车牌号码</th>
				<th>车辆品牌</th>
				<th>车辆类型</th>
				<th>车辆型号</th>
				<th>发动机号码</th>
				<th>车辆识别代号</th>	
				<th>核定载客</th>
				<th>车辆颜色</th>
				<th>注册登记日期</th>
				<th>发证日期</th>
				<th>交易类型</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty CarInfos }">
				<c:forEach items="${CarInfos}" var="c" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${c.carId}"/>${s.count}</td>
						<td>${c.personCust.custId}</td>			
						<td>${c.carNum}</td>
						<td>${c.carBrand}</td>
						<td>
							<c:choose>
                                <c:when test="${c.carType==0}">
                                   	 小型汽车	
                                </c:when>
       							<c:when test="${c.carType==1}">
                                   	 中型汽车	
                                </c:when>
                                <c:when test="${c.carType==2}">
                                   	 大型汽车	
                                </c:when>
                            </c:choose>
						</td>						
						<td>
						<c:choose>
                                <c:when test="${c.carStyle==0}">
                                   	 小轿车	
                                </c:when>
       							<c:when test="${c.carStyle==1}">
                                   	 货车	
                                </c:when>
                                <c:when test="${c.carStyle==2}">
                                   	 suv	
                                </c:when>
                        </c:choose>
                        </td>
						<td>${c.engineNum}</td>
					 	<td>${c.discriminateCode}</td>
					 	<td>${c.passengers}</td>
					 	<td>${c.carColor}</td>
					 	<td><fmt:formatDate value="${c.regeditDate}" pattern="yyyy-MM-dd"/></td>
					 	<td><fmt:formatDate value="${c.certificationDate}" pattern="yyyy-MM-dd"/></td>
					 	<td>
					 	<c:choose>
                                <c:when test="${c.businessStyle==0}">
                                   	 现金	
                                </c:when>
       							<c:when test="${c.businessStyle==1}">
                                   	 支付宝
                                </c:when>
                                <c:when test="${c.businessStyle==1}">
                                   	信用卡	
                                </c:when>
                        </c:choose>
                        </td>
						<td><a href="javascript:updateCarInfo(${c.carId})">修改</a></td>
						<td><a href="javascript:deleteCarInfo(${c.carId})">删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="15">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addCarInfo()" class="myBtn"><em>新增</em></a>
		</div>
		${carInfo.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteCarInfo(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/CarInfo/deleteCarInfo.do";
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
		
		function addCarInfo(){
			var dg = new $.dialog({
				title:'新增客户车辆信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'CarInfo/getCarInfo.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateCarInfo(id){
			var dg = new $.dialog({
				title:'修改客户车辆信息',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'CarInfo/getCarInfo.do?id='+id
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>