package com.tlong.quartz;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author yichu.zhang
 */
public class DetailQuartzJobBean extends QuartzJobBean {
	private Logger logger = Logger.getLogger(this.getClass());
	private String targetObject;
	private String targetMethod;
	private ApplicationContext ctx;

	/* (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		try {
			logger.info("execute [" + targetObject + "] at once.........................");
			
			Object otargetObject = ctx.getBean(targetObject);
			Method m = null;
			try {
				// 反射需要执行的类
				m = otargetObject.getClass().getMethod(targetMethod, new Class[] { JobExecutionContext.class });
				//invoke需要执行的方法与参数
				m.invoke(otargetObject, new Object[] { context });
			} catch (SecurityException e) {
				logger.error(e.getMessage());
			} catch (NoSuchMethodException e) {
				logger.error(e.getMessage());
			}
		} catch (Exception e) {
			throw new JobExecutionException(e);
		}
	}

	/**
	 * @brief 设置ApplicationContext
	 * @param applicationContext 上下文
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.ctx = applicationContext;
	}

	/**
	 * @brief 设置目标类
	 * @param targetObject 目标类 
	 */
	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}

	/**
	 * @brief 设置目标方法
	 * @param targetMethod 目标方法
	 */
	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}

}