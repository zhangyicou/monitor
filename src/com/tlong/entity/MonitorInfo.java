package com.tlong.entity;

import static javax.persistence.GenerationType.IDENTITY;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * �������
 * @author yichu.zhang
 *
 */
@Entity
@Table(name = "m_info", catalog = "monitor")
public class MonitorInfo {
	private Long id;//id
	private Long memTotal;//总内存
	private Long memUsed;//已使用内存
	private Long memFree;//剩余内存
	private Double cpuRatio;//CPU使用率
  	private Long threadTotal;//当前线程数
	private Date opTime;//时间
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "memTotal")
	public Long getMemTotal() {
		return memTotal;
	}
	public void setMemTotal(Long memTotal) {
		this.memTotal = memTotal;
	}
	
	@Column(name = "memUsed")
	public Long getMemUsed() {
		return memUsed;
	}
	public void setMemUsed(Long memUsed) {
		this.memUsed = memUsed;
	}
	
	@Column(name = "memFree")
	public Long getMemFree() {
		return memFree;
	}
	public void setMemFree(Long memFree) {
		this.memFree = memFree;
	}
	
	@Column(name = "cpuRatio")
	public Double getCpuRatio() {
		return cpuRatio;
	}
	public void setCpuRatio(Double cpuRatio) {
		this.cpuRatio = cpuRatio;
	}
	
	@Column(name = "threadTotal")
	public Long getThreadTotal() {
		return threadTotal;
	}
	public void setThreadTotal(Long threadTotal) {
		this.threadTotal = threadTotal;
	}
	
	@Column(name = "opTime")
	public Date getOpTime() {
		return opTime;
	}
	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}
}
