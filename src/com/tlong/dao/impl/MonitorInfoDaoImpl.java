package com.tlong.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tlong.dao.MonitorInfoDao;
import com.tlong.dao.base.BaseDaoSupport;
import com.tlong.entity.MonitorInfo;

/**
 * 
 * @author yichu.zhang
 *
 */
@Repository
public class MonitorInfoDaoImpl 
		extends BaseDaoSupport implements MonitorInfoDao {

	public int addMonitorInfo(MonitorInfo monitorInfo) {
		try {
			this.getSession().save(monitorInfo);
			return 1;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return 0;
		}
	}
	
	public void addMonitorInfo(List<MonitorInfo> monitorInfo){
		Session session = this.getSession();
		session.beginTransaction();
		int index = 0;
		for(MonitorInfo monitor : monitorInfo){
			session.save(monitor);
			index++;
			if(index % 50 == 0){
				session.flush();  
                session.clear(); 
			}
		}
		
		session.getTransaction().commit();
	}

	public int deleteMonitorInfo(Date date) {
		String HQL = "delete MonitorInfo where opTime < ?";
		return this.getSession().createQuery(HQL).setDate(0, date).executeUpdate();
	}

	public List<MonitorInfo> queryMonitorInfoList(MonitorInfo info,
			int startIndex, int limitCount) {
		StringBuilder HQL = new StringBuilder();
		HQL.append("from MonitorInfo m order by cpuRatio desc");
		
		return this.getSession().createQuery(HQL.toString())
			.setFirstResult(startIndex).setMaxResults(limitCount).list();
	}

}
