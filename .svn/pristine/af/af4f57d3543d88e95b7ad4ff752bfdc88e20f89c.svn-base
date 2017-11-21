<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="/Home/css/main.css"/>
<title>排班信息</title>
<script type="text/javascript" src="/Home/js/lib/datePicker/WdatePicker.js"></script>
</head>
<body>

<form action="/Home/initialize/newlistScheduLing.do" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table" id="staffReplace">
	<tr class="main_info" >
		<td colspan="5">部门
			<select id="divisionId"  name="divisionId">
				<option value="0">请选择</option>
				<c:forEach items="${divisions}" var="d" varStatus="c">
				<option value="${d.id }">${d.divisionName}</option>
				</c:forEach>
			</select>
		</td>
		<td colspan="5">岗位类型
			<select id="postTypeId" name="postTypeId">
				<option value="0">请选择</option>
				
			</select>
		</td>
		
		<td colspan="5">岗位
			<select id="postId" name="postId">
				<option value="0">请选择</option>
				
			</select>
		</td>
		
		<!-- <td colspan="5">员工姓名
			<input type="text" name="staffName" />
		</td> -->
		<td colspan="5">日期<!-- onclick="WdatePicker()" --> 
			<input  type="text" name="currentdate"  onclick="WdatePicker()"  readonly="readonly" style="width:70px;" value=""/>
			<input  type="submit" value="查询"/>
		</td>
	
	</tr> 
			<c:choose>
			<c:when test="${not empty Schedulings }">
				<c:forEach items="${Schedulings}" var="c" varStatus="s">
				<tr class="main_info">
				<c:if test="${s.count==1}">
							<td >序号 </td>
							 <td>部门名称</td> 
							<td>班次</td>
							<td>1</td>
				</c:if>
				<c:if test="${s.count!=1}">
							<td>1</td>
				</c:if>				
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
							<td>6</td>
							<td>7</td>
							<td>8</td>
							<td>9</td>
							<td>10</td>
							<td>11</td>
							<td>12</td>
							<td>13</td>
							<td>14</td>
							<td>15</td>
							<td>16</td>
		</tr>
					<tr class="main_info"  style="height: 45px">
							<td rowspan="4">${s.count} <input type="hidden" value="${c.id}"/></td>
						<c:if test="${s.count==1}">
							<td rowspan="16" style="width: 15px;font-size: 20px">${c.divisionName}</td>
						</c:if>	 
							<td rowspan="4" style="width: 15px;font-size: 12px">${c.postName}${c.classesTypeName}</td>
							<td>${c.id1}</td>
							<td>${c.id2}</td>
							<td>${c.id3}</td>
							<td>${c.id4}</td>
							<td>${c.id5}</td>
							<td>${c.id6}</td>
							<td>${c.id7}</td>
							<td>${c.id8}</td>
							<td>${c.id9}</td>
							<td>${c.id10}</td>
							<td>${c.id11}</td>
							<td>${c.id12}</td>
							<td>${c.id13}</td>
							<td>${c.id14}</td>
							<td>${c.id15}</td>
							<td>${c.id16}</td>
					</tr>
			<tr class="main_info">
							<td>17</td>
							<td>18</td>
							<td>19</td>
							<td>20</td>
							<td>21</td>
							<td>22</td>
							<td>23</td>
							<td>24</td>
							<td>25</td>
							<td>26</td>
							<td>27</td>
							<td>28 </td>
							<td>29</td>
							<td>30</td>
							<td>31</td>
			</tr>
					<tr class="main_info"  style="height: 45px">
					
							
							<td>${c.id17}</td>
							<td>${c.id18}</td>
							<td>${c.id19}</td>
							<td>${c.id20}</td>
							<td>${c.id21}</td>
							<td>${c.id22}</td>
							<td>${c.id23}</td>
							<td>${c.id24}</td>
							<td>${c.id25}</td>
							<td>${c.id26}</td>
							<td>${c.id27}</td>
							<td>${c.id28}</td>
							<td>${c.id29}</td>
							<td>${c.id30}</td>
							<td>${c.id31}</td>
						<%-- <td><a href="javascript:updateHillock(${c.id})">修改</a></td> --%>
						<!-- <td><a href="#">删除</a></td> -->
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
		</form>
<%-- 	<div class="page_and_btn">
		<div>
			<a href="javascript:addCarInfo()" class="myBtn"><em>新增</em></a>
		</div>
		${carInfo.page.pageStr}
	</div> --%>
	
	<script type="text/javascript" src="/Home/js/jquery/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="/Home/js/lib/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="/Home/js/lib/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){

			$(".main_info:even").addClass("main_table_even");
			var re= $("#staffReplace").html().replace(/,/g, "<br>");  //替换tr中的“，”<br>
			$("#staffReplace").html(re);
			
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
		function updateHillock(id){
			var dg = new $.dialog({
				title:'修改岗位',
				id:'user_new',
				width:700,
				height:480,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'/Home/initialize/findScheduLingById.do?id='+id
				});
    		dg.ShowDialog();
		}
		
		
	/* 	$("#divisionId").live("change", function() {
			
			var divisionId=$("#divisionId").val();
			
			$.post("/Home/Post/getDivisionbyId.do", {"id" : divisionId},function(data){
				$("#postTypeId").empty();
				var json=eval(data);
				for ( var i = 0; i < json.length; i++) {
					
					$("#postTypeId").append("<option id=optionId value="+json[i]['postTypeId']+">"+json[i]['postTypeName']+"</option>");
				}
				
			});
		}); */
		
		
		$("#divisionId").live("change", function() {
			
			var divisionId=$("#divisionId").val();
			
			$.post("/Home/Post/getDivisionbyId.do", {"id" : divisionId},function(data){
				$("#postTypeId").empty();
				var json=eval(data);
				for ( var i = 0; i < json.length; i++) {
					
					$("#postTypeId").append("<option id=optionId value="+json[i]['postTypeId']+">"+json[i]['postTypeName']+"</option>");
				}
				
			});
		});
		
		$("#postTypeId").live("change", function() {
			
			var postTypeId=$("#postTypeId").val();
			$.post("/Home/Post/listAllPostByPostTypeId.do", {"id" : postTypeId},function(data){
				$("#postId").empty();
				var json=eval(data);
				for ( var i = 0; i < json.length; i++) {
					
					$("#postId").append("<option id=optionId value="+json[i]['id']+">"+json[i]['postName']+"</option>");
				}
				
			});
		});
		
		
		
		
		</script>

</body>
</html>