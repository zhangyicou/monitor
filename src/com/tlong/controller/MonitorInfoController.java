package com.tlong.controller;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.tlong.entity.MonitorInfo;
import com.tlong.service.MonitorInfoService;
import com.tlong.thread.MonitorServiceRunnable;
import com.tlong.vo.MonitorInfoVo;

/**
 * 监控信息
 * @author yichu.zhang
 *
 */
@Controller
@RequestMapping("info")
public class MonitorInfoController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ExecutorService exeService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 3);
    @Autowired
    private MonitorInfoService monitorInfoServiceImpl;
    
    @RequestMapping(value = "addMonitor", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
	public String addMonitor(@RequestBody MonitorInfoVo[] monitorInfoVo){
    	logger.info(".addMonitor monitorInfoVo:"+JSON.toJSONString(monitorInfoVo));
		if(monitorInfoVo == null || monitorInfoVo.length < 1){
			logger.info("monitorInfos is null");
		}else{
			MonitorServiceRunnable monitorRunnable 
				= new MonitorServiceRunnable(monitorInfoServiceImpl, monitorInfoVo);
			exeService.submit(monitorRunnable);
		}
		return "{\"code\":\"1\"}";
	}
    
    @RequestMapping(value="getList", method=RequestMethod.GET)
	public String getList(int page, int limitCount, Model model){
		MonitorInfo monitorInfo = new MonitorInfo();
		try{
			List<MonitorInfo> list = monitorInfoServiceImpl.getList(monitorInfo, page, limitCount);
			model.addAttribute("list", list);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "monitor/monitorlist";
	}
}
