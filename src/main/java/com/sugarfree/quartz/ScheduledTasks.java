package com.sugarfree.quartz;

import com.sugarfree.service.StatisticsService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ScheduledTasks
 * @Description: 轮训任务
 * @author: LT
 * @date: 2017/1/25
 */
@Component
@Configurable
@EnableScheduling
@Log4j
public class ScheduledTasks {

    @Autowired
    private StatisticsService statisticsService;

    @Scheduled(cron = "0 0 1 * * *")
    public void savePushStat(){
        log.info("savePushStat start");
        this.statisticsService.savePushStat();
        log.info("savePushStat end");
    }
}
