package com.oyr.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {
	
	public void printMessage(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("my is printMessage ：" + format.format(date));
	}
	
}
