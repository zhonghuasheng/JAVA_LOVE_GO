package com.zhonghuasheng.spring4.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduleService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    // cron配置:每隔三秒
    @Scheduled(cron = "*/3 * * * * ?")
    public void cronService() {
        System.out.println("Cron: " + sdf.format(new Date()));
    }

    // 每隔五秒执行一次
    @Scheduled(fixedRate = 5000)
    public void fixedRate() {
        System.out.println("FixedRate: " + sdf.format(new Date()));
    }

    // 距离上次执行2秒后执行
    @Scheduled(fixedDelay = 2000)
    public void fixDelay() {
        System.out.println("FixedDelay: " + sdf.format(new Date()));
    }
}
