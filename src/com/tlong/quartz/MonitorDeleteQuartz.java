package com.tlong.quartz;

import java.io.Serializable;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tlong.service.MonitorInfoService;

@Service("monitorDeleteQuartz")
@Transactional(readOnly = false,rollbackFor=Exception.class)
public class MonitorDeleteQuartz implements Job, Serializable {
	private static final Logger logger = Logger.getLogger(MonitorDeleteQuartz.class.getName());
	private static final long serialVersionUID = -8595068275585361997L;
	
	@Resource(name="monitorInfoServiceImpl")
	private MonitorInfoService  monitorInfoServiceImpl;
	
	private void excute(){
		logger.info("excute....................................");
		monitorInfoServiceImpl.delete();
	}
	
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		excute();
	}
}
