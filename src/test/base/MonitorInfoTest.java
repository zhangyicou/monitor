package test.base;

import java.util.ArrayList;
import java.util.List;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.ThreadCpu;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.tlong.sys.SigarHelper;
import com.tlong.util.HttpUtil;
import com.tlong.vo.MonitorInfoVo;

public class MonitorInfoTest {
	
	@Test
	public void addMonitorTest(){
		try{
			//MonitorInfoVo[] monitorList = new MonitorInfoVo[51];
			List<MonitorInfoVo> monitorList = new ArrayList<MonitorInfoVo>();
			MonitorInfoVo monitorInfo=null;
			for(int i = 0; i < monitorList.size(); i++){
				monitorInfo = new MonitorInfoVo();
				monitorInfo.setClassName(this.getClass().getName());
				monitorInfo.setMethodName("addMonitorTest."+i);
				
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
				
				
				monitorInfo.setCpuRatio(0.33d);
				monitorList.add(monitorInfo);
			}
			String result = HttpUtil.post("http://localhost:8080/monitor/info/addMonitor", JSON.toJSONString(monitorList));
			System.out.println("result:"+result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
