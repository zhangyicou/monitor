<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>系统监控配置信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
   	<h1>系统监控配置信息</h1>
   	<hr style="width: 80%; color: blue;"/>
   	<div class="panel panel-default" style="float: inline-block">
	    <div class="input-group">
	         <span class="input-group-addon">ClassName</span>
	         <input type="text" class="form-control" placeholder="twitterhandle">
	         <span class="input-group-addon">MethodName</span>
	         <input type="text" class="form-control" placeholder="twitterhandle">
	      </div>
	    <br>
	   	<div class="btn-group" style="margin-left: 75%;">
		  <button type="button" class="btn btn-default">查询</button>
		  <button type="button" class="btn btn-default">新增</button>
		  <a class="dropdown-toggle" href="base/getList?page=0&limitCount=20&time=<%=new Date().getTime()%>">返回</a>
		  <a class="dropdown-toggle" href="index.jsp">首页</a>
		</div>
	</div>
   	<hr style="width: 80%; color: blue;"/>
   	<table class="table table-hover">
   		<tr>
   			<th style="width: 5%;">ID</th>
   			<th style="width: 35%;">ClassName</th>
   			<th style="width: 25%;">MethodName</th>
   			<th style="width: 10%;">是否有效</th>
   			<th style="width: 15%;">添加时间</th>
   			<th style="width: 15%;">操作</th>
   		</tr>
   		<c:forEach  var="base" items="${list}" varStatus="count">
   			<tr>
   				<td align="center">
					${base.id}
				</td>
				<td align="center">
					${base.className}
				</td>
				<td align="center">
					${base.methodName}
				</td>
				<td align="center">
					<c:if test="${base.isVilad eq 1}">有效</c:if>
					<c:if test="${base.isVilad eq 0}">无效</c:if>
				</td>
				<td align="center">
					${base.opTime}
				</td>
				<td align="center">
					<a class="dropdown-toggle" href="base/updateMonitorBase?id=${base.id}&isVilad=<c:if test="${base.isVilad eq 0}">1</c:if><c:if test="${base.isVilad eq 1}">0</c:if>">
						<i class="icon-eye-open"></i>
						<c:if test="${base.isVilad eq 0}">有效</c:if>
						<c:if test="${base.isVilad eq 1}">无效</c:if>
						<b class="caret"></b>
					</a>
				</td>
   			</tr>
   		</c:forEach>
   	</table>
  </body>
</html>
