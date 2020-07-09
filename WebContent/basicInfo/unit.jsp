<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List,java.util.ArrayList" %>
<%@ page import= "basicInformation.entity.Unit" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
	function UnitDelete(unitCode) {
		if(confirm("您确定要删除这个单位信息吗？")) {
			window.location="unitServlet?action=delete&unitCode="+unitCode;
		}
	}
	
	function updateUnit(unitCode) {
		if(confirm("您确定要修改这个单位信息吗？")) {
			window.location="unitServlet?action=update&unitCode="+unitCode;
		}
	}
	
	function addUnit(){
		window.location.href="addUnit.jsp";
	}
	$(document).ready(function(){
		$("ul li:eq(1)").addClass("active");
	});
</script>
<style type="text/css">
	.form-search{
		margin-top:5px;
		margin-bottom: 5px;
	}
	
	.data_search{
		float:right;
	}
	
	.select_form {
		margin-top: 5px;
		margin-bottom: 5px;
	}
	
	table{
		text-align: center;
		font-family: "黑体";
		width: 100%;
		height: 100%;
		border-bottom: 1px;
		cellpadding: 1px;
    	cellspacing: 1px;
    	border:1px solid black;
    	border-collapse: collapse;
	}
	table th{
		font-style: inherit;
	}
	table td,th{
		border:1px solid white;
	}
	.section{
		background: linear-gradient(white,lightblue);
	}
	
</style>
</head>
<body>
	<div class="section">
		<div><!-- 界面标题 -->
			<h3  align="center">往来信息单位信息表</h3>
		</div>
		<div class="section1"><!-- 查询功能块 -->
			<form name="myForm" class="form-search" method="post" action="dormManager?action=search">
				<button type="button" style="margin-right: 50px;" onclick="addUnit()">添加</button> <!-- "javascript:window.location='addUnit.jsp'" -->
				<span class="data_search">
					<select id="searchType" name="searchType" style="width: 80px;">
					<option value="unitCode">单位代码</option>
					<option value="unitName" ${searchType eq "userName"?'selected':'' }>单位名称</option>
					<option value="helpCode">助记码</option>
					</select>
					&nbsp;<input id="s_dormManagerText" name="s_dormManagerText" type="text"  style="width:90px;height: 20px;"  value="${s_dormManagerText }">
					&nbsp;<button type="submit" class="btn btn-info" onkeydown="if(event.keyCode==13) myForm.submit()">搜索</button>
				</span>
			</form>
		</div>
		<div class="section2"><!-- 展示信息块 -->
			<table>
				<tr bgcolor="#e1ffc1">
					<th>单位代码</th>
					<th>单位性质</th>
					<th>助记码</th>
					<th>所属地区</th>
					<th>所属行业</th>
					<th>单位类别</th>
					<th>单位名称</th>
					<th>联系人</th>
					<th>地址</th>
					<th>开户银行</th>
					<th>银行账号</th>
					<th>业务电话</th>
					<th>Email</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${unitList }" var="unit" >
					<tr>
						<td>${unit.unitCode }</td>
						<td>${unit.unitNature }</td>
						<td>${unit.helpCode }</td>
						<td>${unit.region }</td>
						<td>${unit.industry==null?"无":unit.industry }</td>
						<td>${unit.unitClass }</td>
						<td>${unit.unitName }</td>
						<td>${unit.contacts }</td>
						<td>${unit.address }</td>
						<td>${unit.bank }</td>
						<td>${unit.account }</td>
						<td>${unit.phone }</td>
						<td>${unit.email }</td>
						<td>${unit.info }</td>
						<td> 
							<button class="btn" type="button" onclick="updateUnit(${unit.unitCode})">修改</button> <!-- "javascript:window.location='unitServlet?action=update&unitCode=${unit.unitCode }'" -->
							<button class="btn" type="button" onclick="UnitDelete(${unit.unitCode})">删除</button>
			      		</td> 
					</tr>
				</c:forEach>
			</table>
			<h2 align="center"> 
	    		<a href="/basicInfo/unit.jsp">返回基础信息管理页面</a> 
	  		</h2> 
		</div>
	</div>
</body>
</html>
