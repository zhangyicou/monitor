package com.tlong.dao;

import java.util.Date;
import java.util.List;

import com.tlong.entity.MonitorInfo;

/**
 * �����ϸ��Ϣ
 * @author yichu.zhang
 *
 */
public interface MonitorInfoDao {
	/**
	 * 保存
	 * @param monitorInfo
	 * @return
	 */
	public int addMonitorInfo(MonitorInfo monitorInfo);
	
	/**
	 * 批量保存
	 * @param monitorInfo
	 * @return
	 */
	public void addMonitorInfo(List<MonitorInfo> monitorInfo);
	
	/**
	 * ����ɾ��
	 * @param date
	 * @return
	 */
	public int deleteMonitorInfo(Date date);
	
	/**
	 * ��ȡ�����Ϣ
	 * @param info
	 * @param startIndex
	 * @param limitCount
	 * @return
	 */
	public List<MonitorInfo> queryMonitorInfoList(MonitorInfo info, int startIndex, int limitCount);
}
