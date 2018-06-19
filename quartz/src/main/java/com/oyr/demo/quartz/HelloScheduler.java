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
		//��ӡ��ʼʱ��
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = format.format(date);
		System.out.println(strDate);
		
		//��������
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				.withIdentity("myJob", "hello")
				.usingJobData("job1", "myjob")
				.usingJobData("jobFloat", 777f)
				.build();
		/*//��ȡjob����
		System.out.println(jobDetail.getKey().getName());
		//��ȡjob����
		System.out.println(jobDetail.getKey().getGroup());
		//��ȡjob����
		System.out.println(jobDetail.getJobClass().getName());
		*/

		//����������
		CronTrigger trigger = TriggerBuilder
				.newTrigger()	//��ȡtrigger
				.withIdentity("myTrigger", "hello")	//���÷���ͱ�ʶ
				.withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))//ÿ��һ�봥��һ��
				.build();
		//2017����ÿ��10��15�ִ���һ��
		//0 15 10 * * ? 2018
		//ÿ���14������14��59��55�룬�Լ�18������18��59��55�룬û���Ӵ���һ��
		//0/5 * 14,18 * * ?
		//ÿ����һ�������10��15�ִ���һ��
		//0 15 10 ? * 1-6
		//ÿ�����һ���10��15�ִ���һ��
		//0 15 10 L * ?
		//ÿ�µ����������10��15�ִ���һ��
		//0 15 10 ? * 5#3
		
		
		//���������������ʹ�ù�������
		/*StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = stdSchedulerFactory.getScheduler();
		
		
		DirectSchedulerFactory directSchedulerFactory = DirectSchedulerFactory.getInstance();
		Scheduler scheduler = directSchedulerFactory.getScheduler();*/
		
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		//����
		scheduler.start();
		//��������ʹ�����
		Date scheduleJob = scheduler.scheduleJob(jobDetail, trigger);
		System.out.println("scheduler time is " + format.format(scheduleJob));//��һ�ε��������ʱ��
		Thread.sleep(3000);
		//scheduler.standby();//����
		scheduler.shutdown();
		Thread.sleep(3000);
		scheduler.start();
	}
	
}
