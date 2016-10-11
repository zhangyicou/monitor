package com.tlong.aopadvice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.ThreadCpu;
import com.tlong.sys.SigarHelper;
import com.tlong.thread.MonitorReqRunnable;
import com.tlong.vo.MonitorInfoVo;

public class AspectAdvice {
	private String monitorUrl;
	private List<MonitorInfoVo> monitorList = new ArrayList<MonitorInfoVo>();
	private ExecutorService exeService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 3);
	 /**
     * 前置通知
     * 
     * @param jp
     */
    public void doBefore(JoinPoint jp) {
    }

    /**
     * 后置通知
     * 
     * @param jp
     *            连接点
     * @param result
     *            返回值
     */
    public void doAfter(JoinPoint jp, String result) {
    }

    /**
     * 环绕通知
     * 
     * @param pjp
     *            连接点
     */
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
    	
        MonitorInfoVo monitorInfoVo = getMonitorInfo();
        if(monitorInfoVo != null){
        	monitorInfoVo.setClassName(pjp.getTarget().getClass().getName());
        	monitorInfoVo.setMethodName(pjp.getSignature().getName());
        	insert(monitorInfoVo);
        	//String str = HttpUtil.post("http://localhost:18001/monitor/info/addMonitor", JSON.toJSONString(monitorInfoVo));
        }
        // 获取目标对象
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
        Object result = pjp.proceed();
        monitorInfoVo = getMonitorInfo();
        if(monitorInfoVo != null){
        	monitorInfoVo.setClassName(pjp.getTarget().getClass().getName());
        	monitorInfoVo.setMethodName(pjp.getSignature().getName());
        	insert(monitorInfoVo);
        	//String str = HttpUtil.post(this.monitorUrl+"/info/addMonitor", JSON.toJSONString(monitorInfoVo));
        }
        
        if(monitorList.size() > 100){
        	//此处一定要使用同步锁，否则可能会遗漏监控信息
        	synchronized (this) {
        		MonitorReqRunnable reqRunnable = new MonitorReqRunnable(this.monitorUrl, monitorList);
        		exeService.submit(reqRunnable);
				monitorList = new ArrayList<MonitorInfoVo>();
			}
        }
        return result;
    }
    
    private synchronized void insert(MonitorInfoVo monitorInfoVo){
    	monitorList.add(monitorInfoVo);
    }

    /**
     * 异常通知
     * 
     * @param jp
     * @param e
     */
    public void doThrow(JoinPoint jp, Throwable e) {
        //System.out.println("删除出错啦");
    }
    
    private MonitorInfoVo getMonitorInfo(){
    	MonitorInfoVo monitorInfo = new MonitorInfoVo();
    	try{
			Mem mem = SigarHelper.getMem();
			if(mem != null){
				monitorInfo.setMemFree(mem.getFree());
				monitorInfo.setMemTotal(mem.getTotal());
				monitorInfo.setMemUsed(mem.getUsed());
			}
	//		
			ThreadCpu threadCpu = SigarHelper.getThreadCpu();
			if(threadCpu != null	){
				monitorInfo.setThreadTotal(threadCpu.getTotal());
			}
	//		
			CpuPerc[] cpuPercs = SigarHelper.getCupInfo();
			int count = 0;
			float combined = 0f;
			for(CpuPerc cpuPerc : cpuPercs){
				combined += cpuPerc.getCombined();
				count++;
			}
			
			monitorInfo.setCpuRatio(Double.valueOf(String.valueOf(combined/count)));
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
    		monitorInfo = null;
		}
    	
    	return monitorInfo;
    }

	public void setMonitorUrl(String monitorUrl) {
		this.monitorUrl = monitorUrl;
	}
}
