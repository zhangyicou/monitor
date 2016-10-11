<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
    <title>系统监控配置信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <!--<link href="/resources/css/oxygen.css" rel="stylesheet" type="text/css">-->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/font-awesome.css" rel="stylesheet">
    <link href="/resources/css/admin.css" rel="stylesheet">
    <link href="/resources/css/MIS_com.css" rel="stylesheet" type="text/css" />
    <link href="/resources/css/supplier.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/icon.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/jquery.datetimepicker.css"/ >
    <link href="/resources/css/default/fontsize.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/chosen.css" type="text/css" media="all"/>
	<%-- jsp:include page="${path}/base/getList.action?page=0&limitCount=20&time=<%=new Date().getTime()%>"></jsp:include --%>
  </head>
  
  <body>
    <div class="container">
    <div class="row">
        <div class="span2">
            <div class="main-left-col">
                <h1><i class="icon-shopping-cart icon-large"></i>系统监控配置信息</h1>
                <ul class="side-nav">
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#handleorder-dropdown" href="#"><i class="icon-eye-open"></i>系统监控<b class="caret"></b></a>
                        <ul id="handleorder-dropdown" class="collapse">
                            <li id="baseinfo"><a href="base/getList?page=0&limitCount=20&time=<%=new Date().getTime()%>" class="li_font_size">监控对象管理</a></li>
                            <li id="info"><a href="info/getList?page=0&limitCount=20&time=<%=new Date().getTime()%>" class="li_font_size">系统信息管理</a></li>
                        </ul>
                    </li>
                </ul>
            </div> <!-- end main-left-col -->
        </div> <!-- end span2 -->
        <div class="span10">
            <div id="content" class="panel panel-default" ></div>
        </div>
        <div class="row">
	        <div class="span10" style="margin-left: 230px;">
	            <div class="footer" style="margin-top:30px;">
	                <p>&copy; 感谢使用系统监控系统</p>
	            </div>
	        </div>
	    </div>
	</div> <!-- end row -->
</div> <!-- end container -->
<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/resources/js/jquery-1.7.2.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/excanvas.min.js"></script>
<script src="/resources/js/jquery.flot.min.js"></script>
<script src="/resources/js/jquery.flot.resize.min.js"></script>
<script src="/resources/js/jquery.datetimepicker.js"></script>
<script src="/resources/js/jquery.easyui.min.js"></script>
<script src="/resources/js/My97DatePicker/WdatePicker.js"></script>
<script src="/resources/js/chosen.jquery.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $("#${activeParent}").removeClass("collapse").addClass("in collapse");
        $("#${activeChild}").addClass("active");
    });
</script>
  </body>
</html>
