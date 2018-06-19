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
 * �Զ�������
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
		
		/*//��ȡjob����Ϣ
		JobKey jobKey = context.getJobDetail().getKey();
		String group = jobKey.getGroup();
		String name = jobKey.getName();
		System.out.println("job group��" + group);
		System.out.println("job name��" + name);
		
		//��ȡtrigger����Ϣ
		TriggerKey triggerKey = context.getTrigger().getKey();
		String tGroup = triggerKey.getGroup();
		String tname = triggerKey.getName();
		System.out.println("trigger group��" + tGroup);
		System.out.println("trigger name��" + name);
		
		Trigger t = context.getTrigger();
		//��ȡ��ǰjobʵ����key
		JobKey jk = t.getJobKey();
		System.out.println(jk.getGroup());
		//��ȡ��ʼʱ��
		Date startTime = t.getStartTime();
		//��ȡ����ʱ��
		Date endTime = t.getEndTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(startTime));
		System.out.println(format.format(endTime));*/
		
		//��ȡjob�е�datamap
		//context.getMergedJobDataMap();//��ȡ�ϲ����dataMap�����keyֵ�ظ����Դ�������keyΪ��
		
		/*System.out.println("job str:" + job1);
		System.out.println("job float:" + jobFloat);
		
		System.out.println("Trigger str:" + trigger);
		System.out.println("Trigger float:" + triggerFloat);*/
		
		System.out.println("hello world!");
		
	}

}
