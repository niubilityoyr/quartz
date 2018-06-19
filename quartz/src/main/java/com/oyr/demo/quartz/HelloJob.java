package com.oyr.demo.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

/*
 * 自定义任务
 * */
public class HelloJob implements Job{

	private String job1;
	private Float jobFloat;
	private Float triggerFloat;
	private String trigger;
	
	public void setJob1(String job1) {
		this.job1 = job1;
	}

	public void setJobFloat(Float jobFloat) {
		this.jobFloat = jobFloat;
	}

	public void setTriggerFloat(Float triggerFloat) {
		this.triggerFloat = triggerFloat;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = format.format(date);
		System.out.println(strDate);
		
		/*//获取job的信息
		JobKey jobKey = context.getJobDetail().getKey();
		String group = jobKey.getGroup();
		String name = jobKey.getName();
		System.out.println("job group：" + group);
		System.out.println("job name：" + name);
		
		//获取trigger的信息
		TriggerKey triggerKey = context.getTrigger().getKey();
		String tGroup = triggerKey.getGroup();
		String tname = triggerKey.getName();
		System.out.println("trigger group：" + tGroup);
		System.out.println("trigger name：" + name);
		
		Trigger t = context.getTrigger();
		//获取当前job实例的key
		JobKey jk = t.getJobKey();
		System.out.println(jk.getGroup());
		//获取开始时间
		Date startTime = t.getStartTime();
		//获取结束时间
		Date endTime = t.getEndTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(startTime));
		System.out.println(format.format(endTime));*/
		
		//获取job中的datamap
		//context.getMergedJobDataMap();//获取合并后的dataMap，如果key值重复，以触发器的key为大
		
		/*System.out.println("job str:" + job1);
		System.out.println("job float:" + jobFloat);
		
		System.out.println("Trigger str:" + trigger);
		System.out.println("Trigger float:" + triggerFloat);*/
		
		System.out.println("hello world!");
		
	}

}
