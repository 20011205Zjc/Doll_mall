package com.doll.doll_mall;

import com.doll.doll_mall.utils.VerCodeGenerateUtil;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/24 16:44
 */
public class test {
    public static void main(String[] args) {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
               /* System.out.println("task  run:"+ new Date());*/
                System.out.println(VerCodeGenerateUtil.generateVerCode());
            }

        };

        Timer timer = new Timer();

        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。这里是每3秒执行一次
        timer.schedule(timerTask,10,3000);
    }
}
