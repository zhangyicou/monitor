package com.tlong.thread;

import java.util.List;

import org.springframework.util.StopWatch;

import com.alibaba.fastjson.JSON;
import com.tlong.util.HttpUtil;
import com.tlong.vo.MonitorInfoVo;

/**
 * 请求线程
 * @author lixuemei
 *
 */
public class MonitorReqRunnable implements Runnable {
	private List<MonitorInfoVo> monitorList;
	private String monitorUrl;
	private String className = this.getClass().getName();
	private String methodName = "doAround";
	
	public MonitorReqRunnable(String monitorUrl, List<MonitorInfoVo> monitors){
		this.monitorUrl = monitorUrl;
		this.monitorList = monitors;
	}
	public void run() {
		try{
			StopWatch stopWatch = new StopWatch();
        	stopWatch.start();
			MonitorInfoVo monitors[] = new MonitorInfoVo[monitorList.size()];
			int i = 0;
			for(MonitorInfoVo monitor : monitorList){
				monitors[i++] = monitor;
			}
			StopWatch reqWatch = new StopWatch();
			reqWatch.start();
			String str = HttpUtil.post(this.monitorUrl+"/info/addMonitor", JSON.toJSONString(monitors));
			System.out.print("addMonitor.time:".concat(String.valueOf(reqWatch.getTotalTimeMillis())));
			stopWatch.stop();
        	System.out.print(className.concat(".").concat(methodName)
        			.concat(".time:").concat(String.valueOf(stopWatch.getTotalTimeMillis())));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
