package com.example.demo.task;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling
@Slf4j
@EnableAsync
public class ScheduleTask {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Value("${spring.task1.cron}")
    private String cron1;

    @Scheduled(cron = "${spring.task1.cron}:*/5 * * * * ?")
    public void task1() {
        log.info("cron1 is {}", cron1);
        log.info("task1 的执行时间 is {},thread name is {}", simpleDateFormat.format(new Date()), Thread.currentThread().getName());
    }


}
