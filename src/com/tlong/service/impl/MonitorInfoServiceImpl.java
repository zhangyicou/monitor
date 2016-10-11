package com.tlong.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.tlong.dao.MonitorInfoDao;
import com.tlong.entity.MonitorInfo;
import com.tlong.service.MonitorInfoService;

@Service("monitorInfoServiceImpl")
public class MonitorInfoServiceImpl implements MonitorInfoService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MonitorInfoDao monitorInfoDaoImpl;
	
	public int add(MonitorInfo monitorInfo) throws Exception{
		return monitorInfoDaoImpl.addMonitorInfo(monitorInfo);
	}
	
	public void add(List<MonitorInfo> monitorInfo) throws Exception{
		StopWatch sw = new StopWatch();
		sw.start();
		monitorInfoDaoImpl.addMonitorInfo(monitorInfo);
		sw.stop();
		logger.info("addList.time:"+sw.getTotalTimeMillis());
	}
	
	public List<MonitorInfo> getList(MonitorInfo monitorInfo, int startIndex, int limitCount) throws Exception{
		return monitorInfoDaoImpl.queryMonitorInfoList(monitorInfo, startIndex * limitCount, limitCount);
	}
	
	public void delete(){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		date = calendar.getTime();
		monitorInfoDaoImpl.deleteMonitorInfo(date);
	}
}
