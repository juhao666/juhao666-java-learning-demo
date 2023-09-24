package com.juhao666.spring.task.manager.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Slf4j
//@Component
public class MyTaskDemo {

    private int[] people = {6, 2, 3, 1};

    private int count = 0;

    /**
     * 固定延迟5秒
     * @throws InterruptedException
     */
//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() throws InterruptedException {
//        if (count < 4) {
//            int timeConsuming = people[count];
//            log.info("fixedDelayTask-----第 {} 个人在 {} 开始如厕，耗时：{} 秒", count + 1,
//                    formatTime(),
//                    timeConsuming);
//            Thread.sleep(timeConsuming * 1000L);
//            count++;
//        }
//    }

//    /**
//     * crontable 模式  5秒的整倍数
//     * @throws InterruptedException
//     */
//
//    @Scheduled(cron = "0/5 * * * * ? ")
//    public void cronTask() throws InterruptedException {
//        if (count < 4) {
//            int timeConsuming = people[count];
//            log.info("cronTask-----第 {} 个人在 {} 开始如厕，耗时：{} 秒", count + 1,
//                    formatTime(),
//                    timeConsuming);
//            Thread.sleep(timeConsuming * 1000L);
//            count++;
//        }
//    }
//
    /**
     * 按比例
     * 如果前一个task 5秒内结束，则下一个任务等待5秒开始
     * 如果前一个task 5秒内没有结束，则下一个任务立即开始
     * @throws InterruptedException
     */
//    @Scheduled(fixedRate = 5000)
//    public void fixedRateTask() throws InterruptedException {
//        if (count < 4) {
//            int timeConsuming = people[count];
//            log.info("fixedRateTask-----第 {} 个人在 {} 开始如厕，耗时：{} 秒", count + 1,
//                    formatTime(),
//                    timeConsuming);
//            Thread.sleep(timeConsuming * 1000L);
//            count++;
//        }
//    }

    private String formatTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}
