package com.tlong.vo;

public class MonitorInfoVo {
	private String className;//类名
	private String methodName;//方法名
	private Long memTotal;//总内存
	private Long memUsed;//已使用内存
	private Long memFree;//剩余内存
	private Double cpuRatio;//CPU使用率
  	private Long threadTotal;//总线程数
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Long getMemTotal() {
		return memTotal;
	}
	public void setMemTotal(Long memTotal) {
		this.memTotal = memTotal;
	}
	public Long getMemUsed() {
		return memUsed;
	}
	public void setMemUsed(Long memUsed) {
		this.memUsed = memUsed;
	}
	public Long getMemFree() {
		return memFree;
	}
	public void setMemFree(Long memFree) {
		this.memFree = memFree;
	}
	public Double getCpuRatio() {
		return cpuRatio;
	}
	public void setCpuRatio(Double cpuRatio) {
		this.cpuRatio = cpuRatio;
	}
	public Long getThreadTotal() {
		return threadTotal;
	}
	public void setThreadTotal(Long threadTotal) {
		this.threadTotal = threadTotal;
	}
}
