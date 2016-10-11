package com.tlong.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tlong.entity.MonitorInfo;
import com.tlong.service.MonitorInfoService;
import com.tlong.vo.MonitorInfoVo;

public class MonitorServiceRunnable implements Runnable {
	private MonitorInfoVo[] monitorInfoVo;
	private MonitorInfoService monitorInfoServiceImpl;
	public MonitorServiceRunnable(
			MonitorInfoService serviceImpl,
			MonitorInfoVo[] list){
		
		this.monitorInfoVo = list;
		this.monitorInfoServiceImpl = serviceImpl;
	}
	public void run(){
		Date today = new Date();
		List<MonitorInfo> monitorList = new ArrayList<MonitorInfo>();
		MonitorInfo monitorInfo = null;
		try{
			for(MonitorInfoVo monitor : monitorInfoVo){
				monitorInfo = new MonitorInfo();
				monitorInfo.setCpuRatio(monitor.getCpuRatio());
				monitorInfo.setMemFree(monitor.getMemFree());
				monitorInfo.setMemTotal(monitor.getMemTotal());
				monitorInfo.setMemUsed(monitor.getMemUsed());
				monitorInfo.setOpTime(today);
				monitorInfo.setThreadTotal(monitor.getThreadTotal());
				monitorList.add(monitorInfo);
			}
			monitorInfoServiceImpl.add(monitorList);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				throw new Exception(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
