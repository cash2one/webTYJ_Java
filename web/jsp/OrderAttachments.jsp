<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>工单附件</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>工单编号</th>
				<th>文件名称</th>
				<th>附件类型</th>
				<th>文件类型</th>
				<th>文件状态</th>
				<th>已入档</th>
				<th>文件版本</th>	
				<th>文件日期</th>
				<th>备注</th>
				<th colspan="2">操作</th>
			</tr>
			<c:choose>
			<c:when test="${not empty OrderAttachments }">
				<c:forEach items="${OrderAttachments}" var="o" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${o.orderAttachmentId}"/>${s.count}</td>
						<td>${o.order.workOrderId}</td>			
						<td>${o.fileName}</td>
						<td>${o.fileSrcType}</td>
						<td>${o.dbLastUpdSrc}</td>						
						<td>
							<c:choose>
                                <c:when test="${o.publishCd==0}">
                                   	只读
                                </c:when>
       							<c:when test="${o.publishCd==1}">
                                   	损坏
                                </c:when>
                                <c:when test="${o.publishCd==2}">
                                   	管理员权限
                                </c:when>
                            </c:choose>
						</td>
					 	<td>
					 		<c:choose>
                                <c:when test="${o.fileDockStatFlg==0}">
                                   	是
                                </c:when>
       							<c:when test="${o.fileDockStatFlg==1}">
                                                                                                                              否
                                </c:when>
                            </c:choose>
					 	</td>
					 	<td>${o.fileRevNum}</td>
					 	<td><fmt:formatDate value="${o.fileDate}" pattern="yyyy-MM-dd"/> </td>
					 	<td>${o.comments}</td>
						<td><a href="javascript:updateOrderAttachment(${o.orderAttachmentId})">修改</a></td>
						<td><a href="javascript:deleteOrderAttachment(${o.orderAttachmentId})">删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="17">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	<div class="page_and_btn">
		<div>
			<a href="javascript:addOrderAttachment()" class="myBtn"><em>新增</em></a>
		</div>
		${OrderAttachment.page.pageStr}
	</div>
	
	<script type="text/javascript" src="js/lib/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function deleteOrderAttachment(id)
		{
			if(confirm("确定要删除该记录？")){
				var url = "/Home/OrderAttachment/deleteOrderAttachment.do";
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
		
		function addOrderAttachment(){
			var dg = new $.dialog({
				title:'新增工单附件',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'OrderAttachment/getOrderAttachment.do?id=0'
				});
    		dg.ShowDialog();
		}
		
		function updateOrderAttachment(id){
			var dg = new $.dialog({
				title:'修改工单附件',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'OrderAttachment/getOrderAttachment.do?id='+id
				});
    		dg.ShowDialog();
		}
		</script>

</body>
</html>