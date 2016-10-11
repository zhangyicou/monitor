package com.tlong.service;

import java.util.List;

import com.tlong.entity.MonitorInfo;

public interface MonitorInfoService {
	/**
	 * 新增
	 * @param monitorBase monitorBase
	 * @return
	 */
	public int add(MonitorInfo monitorInfo) throws Exception;
	
	/**
	 * 新增
	 * @param monitorBase monitorBase
	 * @return
	 */
	public void add(List<MonitorInfo> monitorInfo) throws Exception;
	
	/**
	 * 获取监控信息
	 * @param monitorInfo
	 * @return
	 * @throws Exception
	 */
	public List<MonitorInfo> getList(MonitorInfo monitorInfo, int startIndex, int limitCount) throws Exception;
	
	public void delete();
}
