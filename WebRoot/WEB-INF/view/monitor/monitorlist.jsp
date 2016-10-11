<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>系统信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${path}/css/table.css"  rel="stylesheet">
  </head>
  
  <body>
    <h1>系统信息</h1>
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
		  <a class="dropdown-toggle" href="info/getList?page=0&limitCount=20&time=<%=new Date().getTime()%>">返回</a>
		  <a class="dropdown-toggle" href="index.jsp">首页</a>
		</div>
	</div>
   	<hr style="width: 80%; color: blue;"/>
   	<table class="table table-hover">
   		<tr>
   			<th style="width: 5%;">ID</th>
   			<th style="width: 35%;">任务ID</th>
   			<th style="width: 25%;">总内存</th>
   			<th style="width: 10%;">已使用内存</th>
   			<th style="width: 15%;">剩余内存</th>
   			<th style="width: 15%;">CPU使用率</th>
   			<th style="width: 15%;">当前线程数</th>
   			<th style="width: 15%;">执行时间</th>
   		</tr>
   		<c:forEach  var="info" items="${list}" varStatus="count">
   			<tr>
   				<td align="center">
					${info.id}
				</td>
				<td align="center">
					${info.guid}
				</td>
				<td align="center">
					${info.memTotal}
				</td>
				<td align="center">
					${info.memUsed}
				</td>
				<td align="center">
					${info.memFree}
				</td>
				<td align="center">
					${info.cpuRatio * 100}
				</td>
				<td align="center">
					${info.threadTotal}
				</td>
				<td align="center">
					${info.opTime}
				</td>
   			</tr>
   		</c:forEach>
   	</table>
  </body>
</html>
