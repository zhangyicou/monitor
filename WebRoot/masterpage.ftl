<#macro masterpage title="直连系统" activeParent="" activeChild="">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>${title}</title>
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
    <#nested "customCss" />
</head>
<body>

<div class="container">
    <div class="row">
        <div class="span2">
            <div class="main-left-col">
                <h1><i class="icon-shopping-cart icon-large"></i>直连平台</h1>
                <ul class="side-nav">
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#task-dropdown" href="/DCTaskSchedule/taskInfoPage?pageNumber=1">
                            <i class="icon-eye-open"></i>直连重构任务<b class="caret"></b></a>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#handleorder-dropdown" href="#"><i class="icon-eye-open"></i>订单处理<b class="caret"></b></a>
                        <ul id="handleorder-dropdown" class="collapse">
                            <li id="monitorOrderFlow"><a href="/ordermonitor/index" class="li_font_size">订单流监控</a></li>
                            <li id="checkOrder"><a href="/ordermonitor/ordercheck" class="li_font_size">订单自检</a></li>
                            <li id="orderbeforecheck"><a href="/orderbeforecheck/index" class="li_font_size">成单前超时监控</a></li>
                            <li id="orderbeforecheckpass"><a href="/orderbeforecheck/passIndex" class="li_font_size">成单前不一致率监控</a></li>
                            <li id="orderdifferent"><a href="/orderdifferent/index" class="li_font_size">兜底</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#handlepricequestion-dropdown" href="#"><i class="icon-eye-open"></i>价格落地失败 <b class="caret"></b></a>
                        <ul id="handlepricequestion-dropdown" class="collapse">
                            <li id="handleQuestion"><a href="/priceerror" class="li_font_size">失败问题处理</a></li>
                            <li id="mappingManager"><a href="/sqlServerMapping/getHotelMapping" class="li_font_size">映射管理</a></li>
                            <li id="handleNonMapping"><a href="/priceerror/nonmapping" class="li_font_size">非mapping问题处理</a></li>
                            <li id="priceerrorreport"><a href="/priceerror/errorreport?suppliercode=0&elongHotelId=0" class="li_font_size">酒店价格落地失败查询</a></li>
                            <li id="opReport"><a href="/priceerror/report" class="li_font_size">异常数据表</a></li>
                            <li id="opChart"><a href="/priceerror/chart/default" class="li_font_size">跟进走势图</a></li>
                        </ul>
                    </li>
                     <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#handleproduct-dropdown" href="#"><i class="icon-eye-open"></i>产量成功率失败问题监控<b class="caret"></b></a>
                        <ul id="handleproduct-dropdown" class="collapse">
                            <li id="opChart"><a href="http://172.21.14.12/DcMonitor/Tool/SuccessfulReport" class="li_font_size">成功率与产量监控</a></li>
                            <li id="opChart"><a href="http://172.21.14.12/DcMonitor/Tool/ErrorMonitor" class="li_font_size">失败类型错误监控</a></li>
                            <li id="opChart"><a href="http://172.21.14.12/DcMonitor/ReserveTrouble/Index" class="li_font_size">失败订单明细查看</a></li>
                            <li id="opChart"><a href="http://172.21.14.12/DcMonitor/ReserveTrouble/TroubleDescList" class="li_font_size">错误类型归类</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#battools-dropdown" href="#"><i class="icon-eye-open"></i>批量上线直连酒店 <b class="caret"></b></a>
                        <ul id="battools-dropdown" class="collapse">
                        	<li id="newmapping"><a href="../maimp/master" class="li_font_size">新版mapping信息批量导入</a></li>
							<li id="newmappingerror"><a href="../bierrorinfo/errorMasterPage" class="li_font_size">新版mapping导入错误信息</a></li>
                            <li id="opChart"><a href="http://172.21.14.12/DcMonitor/Tool/BulkImport" class="li_font_size">旧版mapping信息批量导入</a></li>
                            <li id="opChart"><a href="http://172.21.14.12/DcMonitor/Tool/BulkImport" class="li_font_size">直连酒店相关设置导入</a></li>
                            <li id="opChart"><a href="http://172.21.14.12/DcMonitor/Tool/BulkImport" class="li_font_size">pull频次批量导入</a></li>
                        	<li id="nomapping"><a href="../mappingfilter/master" class="li_font_size">获取未mapping直连酒店信息</a></li>
                            <li id="ihghotelconf"><a href="../ihgHotelConf/confManager" class="li_font_size">洲际酒店分表配置</a></li>
                            <li id="chinaonlineprocheck"><a href="/productcheck/checkswitch" class="li_font_size">畅联在线校验开关配置</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#differhotel-dropdown" href="#"><i class="icon-eye-open"></i>差异酒店抓取工具 <b class="caret"></b></a>
                        <ul id="differhotel-dropdown" class="collapse">
                            <li id="opChart"><a href="http://172.21.14.12/DcMonitor/Tool/DiffPmsProduct" class="li_font_size">富尔特差异产品获取</a></li>
                        	<li id="EANstaticpull"><a href="../efiles/master" class="li_font_size">EAN静态信息抓取工具</a></li>
                            <li id="htpromoation"><a href="../htcx/activityList" class="li_font_size">汉庭促销活动列表内容</a></li>
                            <li id="htcxproductinfo"><a href="../htcx/htcxproductinfo?hotelId=-1" class="li_font_size">汉庭促销活动中间表查看</a></li>
                        	<li id="onlinelist"><a href="../hotelonlineoffline/index" class="li_font_size">上下线酒店明细</a></li>
                        	<li id="dcRedis"><a href="../dcredis/redisCheck" class="li_font_size">直连主从Redis结果查询</a></li>
                        	<li id="hotelValid"><a href="../hotelvalid/validmanager" class="li_font_size">酒店是否有效管理</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#accessstandard-dropdown" href="#"><i class="icon-eye-open"></i>供应商准入标准<b class="caret"></b></a>
                        <ul id="accessstandard-dropdown" class="collapse">   
                     		<li id="opChart1"><a href="../accessstandard/index" class="li_font_size">阈值设置</a></li>
                        	<li id="opChart2"><a href="../accessstandard/allsupplier" class="li_font_size">全部供应商准入查询</a></li>
                        	<li id="opChart3"><a href="../accessstandard/idsupplier" class="li_font_size">单个供应商准入查询</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#pullsystem-dropdown" href="#"><i class="icon-eye-open"></i>Pull配置管理 <b class="caret"></b></a>
                        <ul id="pullsystem-dropdown" class="collapse">
                            <li id="supplierManager"><a href="/supplierconfig/index" class="li_font_size">供应商配置管理</a></li>
                            <li id="supplierProperty"><a href="/supplierProperty?coreType=1" class="li_font_size">供应商属性配置</a></li>
                            <li id="taskManager"><a href="/pull/batchHotelTasks" class="li_font_size">.net批量任务管理</a></li>
                            <li id="taskManager"><a href="/pullLog/PMSResponseMessage" class="li_font_size">pull日志管理</a></li>
                            <li id="taskManager"><a href="/pushLog/index" class="li_font_size">push日志管理</a></li>
                            <li id="taskManager"><a href="/pull/taskmanager" class="li_font_size">任务管理</a></li>
                            <li id="pullLog"><a href="/pull/viewlog" class="li_font_size">Pull日志查看</a></li>
                            <li id="productProcessLog"><a href="/pull/viewproductprocesslog" class="li_font_size">落地日志查看</a></li>
                            <li id="productProcessLog"><a href="/log/viewTaskLog" class="li_font_size">Task日志查看</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#ctripDataImportsystem-dropdown" href="#"><i class="icon-eye-open"></i>供应商Mapping管理 <b class="caret"></b></a>
                        <ul id="ctripDataImportsystem-dropdown" class="collapse">
                            <li id="ctripDataImport"><a href="/import/toImport" class="li_font_size">携程酒店Excel导入</a></li>
                            <li id="hotelMappingManager"><a href="/hotel_mapping/getHotelMapping" class="li_font_size">供应商映射管理</a></li>
                            <li id="ctripDataView"><a href="/ctripDataImport/getCtripDataImports?currentPage=1&status=1" class="li_font_size">供应商导入表信息</a></li>
                            <li id="mappingError"><a href="/mappingerror/" class="li_font_size">Mapping错误信息</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#viewCtripMappingSyncLogsystem-dropdown" href="#"><i class="icon-eye-open"></i>定时扫描Mapping数据日志 <b class="caret"></b></a>
                        <ul id="viewCtripMappingSyncLogsystem-dropdown" class="collapse">
                            <li id="CtripMappingSyncLog"><a href="/view/toCtripMappingSyncLogPage" class="li_font_size">查看定时扫描Mapping数据日志</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#onlinesearchtasksystem-dropdown" href="#"><i class="icon-eye-open"></i>OnlineSearch配置管理 <b class="caret"></b></a>
                        <ul id="onlinesearchtasksystem-dropdown" class="collapse">
                            <li id="onlinesearchtaskmanager"><a href="/onlinesearchtask/taskmanager" class="li_font_size">OnlineSearch任务管理</a></li>
                       </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#ctrip-task-dropdown" href="#"><i class="icon-eye-open"></i>携程任务管理<b class="caret"></b></a>
                        <ul id="ctrip-task-dropdown" class="collapse">
                            <li id="fullTaskManager"><a href="/ctrip_pull/taskmanager" class="li_font_size">全量任务管理</a></li>
                            <li id="incrementTaskManager"><a href="/ctrip_increment/taskmanager" class="li_font_size">增量任务管理</a></li>
                            <li id="taskManager"><a href="/template/index" class="li_font_size">任务模板管理</a></li>
                        </ul>
                    </li>
					<li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#ctrip-push-dropdown" href="#"><i class="icon-eye-open"></i>携程酒店推送管理<b class="caret"></b></a>
                        <ul id="ctrip-push-dropdown" class="collapse">
                            <li id="viewPushHotelManager"><a href="/pushHotel/view" class="li_font_size">携程酒店推送详情</a></li>
                            <li id="viewPushPage"><a href="/push/viewPushPage" class="li_font_size">携程酒店推送任务</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#supplier-mapping-dropdown" href="#"><i class="icon-eye-open"></i>供应商促销活动自动mapping<b class="caret"></b></a>
                        <ul id="supplier-mapping-dropdown" class="collapse">
                            <li id="viewSupplierRoomInfo"><a href="/supplierRoomInfo/view" class="li_font_size">供应商房型信息</a></li>
                            <li id="viewSupplierMRoomMappingInfo"><a href="/supplierMRoomMapping/view" class="li_font_size">供应商M房型mapping</a></li>
                            <li id="viewSupplierMRoomMappinglog"><a href="/supplierMRoomMappinglog/view" class="li_font_size">供应商M房型mapping日志</a></li>
                            <li id="viewSupplierElongActivity"><a href="/supplierElongActivity/view?currentPage=1" class="li_font_size">供应商促销活动</a></li>
                            <li id="showOnLineSHotelLog"><a href="/showOnlineSHotelLog/view?currentPage=1&success=1" class="li_font_size">酒店上线日志</a></li>
                            <li id="showPauseSHotelLog"><a href="/showPauseSHotelLog/view?currentPage=1&success=1" class="li_font_size">酒店下线日志</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#ctripquestionAll" href="#"><i class="icon-eye-open"></i>携程问题查询<b class="caret"></b></a>
                        <ul id="ctripquestionAll" class="collapse">
                            <li id="ctripquestion"><a href="/ctripQuesstionTool/index" class="li_font_size">携程问题查询</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#qunarquestionAll" href="#"><i class="icon-eye-open"></i>去哪问题查询<b class="caret"></b></a>
                        <ul id="qunarquestionAll" class="collapse">
                            <li id="qunarquestion"><a href="/qunarQuesstionTool/index" class="li_font_size">去哪问题查询</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle li_menu_font_size" data-toggle="collapse" data-target="#htcxProductStatistical" href="#"><i class="icon-eye-open"></i>汉庭酒店房型和RP与艺龙mapping表差异报表<b class="caret"></b></a>
                        <ul id="htcxProductStatistical" class="collapse">
                            <li id="productStatistical"><a href="/htcxProductStatistical/view" class="li_font_size">汉庭酒店房型和RP与艺龙mapping表差异报表下载</a></li>
                        </ul>
                    </li>
                </ul>
            </div> <!-- end main-left-col -->
        </div> <!-- end span2 -->
        <div class="span10">
            <div id="content" />
        </div>
        <div class="row">
	        <div class="span10" style="margin-left: 230px;">
	            <div class="footer" style="margin-top:30px;">
	                <p>&copy; 感谢使用直连系统</p>
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
<#nested "customJs" />
</body>
</html>
</#macro>