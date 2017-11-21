<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<title>反馈信息</title>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
			<tr class="main_head">
				<th>序号</th>
				<th>公司名称</th>
				<th>公司地址</th>
				<th>公司信息</th>
			</tr>
			<c:choose>
			<c:when test="${not empty aboutuss }">
				<c:forEach items="${aboutus}" var="a" varStatus="s">
					<tr class="main_info">
						<td><input type="hidden" value="${a.companyName}"/>${s.count}</td>	
						<td>${a.companyAddr}</td>						
					 	<td>${a.companyInfo}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="18">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	

</body>
</html>