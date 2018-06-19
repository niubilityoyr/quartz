package com.oyr.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyBean2 extends QuartzJobBean{

	private String username;
	
	public void setUsername(String username) {
		this.username = username;
	}

	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("my is executeInternal ：" + format.format(date));
		System.out.println("username：" + username);
		JobKey jobKey = context.getJobDetail().getKey();
		System.out.println("jobname：" + jobKey.getName() + "，jobGroup：" + jobKey.getGroup());
	}
	
}
