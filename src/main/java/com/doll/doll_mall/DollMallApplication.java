package com.doll.doll_mall;

import com.doll.doll_mall.utils.VerCodeGenerateUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@MapperScan("com.doll.doll_mall.mapper") //扫描的mapper
@SpringBootApplication
public class DollMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(DollMallApplication.class, args);

		/*=========定时任务============*/
/*		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
//				System.out.println("task  run:"+ new Date());
				System.out.println(VerCodeGenerateUtil.generateVerCode());
			}

		};

		Timer timer = new Timer();

		//安排指定的任务在指定的时间开始进行重复的固定延迟执行。这里是每3秒执行一次
		timer.schedule(timerTask,10,3000);*/

	}

}
