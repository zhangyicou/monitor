package com.tlong.sys;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.ThreadCpu;

public class SigarHelper {
	private static Sigar sigar = new Sigar();
	
	/**
	 * 获取CPU信息
	 * @return
	 */
	public static CpuPerc[] getCupInfo() throws Exception{
		try {
			CpuPerc[] cpuPercs = sigar.getCpuPercList();
			return cpuPercs;
		} catch (SigarException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	/**
	 * 内存信息
	 */
	public static Mem getMem() throws Exception{
		Mem mem = sigar.getMem();  
		return mem;
	}
	
	/**
	 * 线程
	 * @return
	 */
	public static ThreadCpu getThreadCpu() throws Exception{
		return sigar.getThreadCpu();
	}
}
