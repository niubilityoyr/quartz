package com.oyr.demo.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.DirectSchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler {
	
	public static void main(String[] args) throws SchedulerException, InterruptedException {
		//打印开始时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = format.format(date);
		System.out.println(strDate);
		
		//创建任务
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				.withIdentity("myJob", "hello")
				.usingJobData("job1", "myjob")
				.usingJobData("jobFloat", 777f)
				.build();
		/*//获取job名称
		System.out.println(jobDetail.getKey().getName());
		//获取job分组
		System.out.println(jobDetail.getKey().getGroup());
		//获取job类名
		System.out.println(jobDetail.getJobClass().getName());
		*/

		//创建触发器
		CronTrigger trigger = TriggerBuilder
				.newTrigger()	//获取trigger
				.withIdentity("myTrigger", "hello")	//设置分组和标识
				.withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))//每隔一秒触发一次
				.build();
		//2017年内每天10点15分触发一次
		//0 15 10 * * ? 2018
		//每天的14点整至14点59分55秒，以及18点整至18点59分55秒，没分钟触发一次
		//0/5 * 14,18 * * ?
		//每月周一至周五的10点15分触发一次
		//0 15 10 ? * 1-6
		//每月最后一天的10点15分触发一次
		//0 15 10 L * ?
		//每月第三个周五的10点15分触发一次
		//0 15 10 ? * 5#3
		
		
		//创建任务调度器，使用工厂创建
		/*StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = stdSchedulerFactory.getScheduler();
		
		
		DirectSchedulerFactory directSchedulerFactory = DirectSchedulerFactory.getInstance();
		Scheduler scheduler = directSchedulerFactory.getScheduler();*/
		
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		//启动
		scheduler.start();
		//设置任务和触发器
		Date scheduleJob = scheduler.scheduleJob(jobDetail, trigger);
		System.out.println("scheduler time is " + format.format(scheduleJob));//第一次调用任务的时间
		Thread.sleep(3000);
		//scheduler.standby();//挂起
		scheduler.shutdown();
		Thread.sleep(3000);
		scheduler.start();
	}
	
}
