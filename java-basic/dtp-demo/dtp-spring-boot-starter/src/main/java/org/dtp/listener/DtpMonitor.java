package org.dtp.listener;

import org.dtp.DtpExecutor;
import org.dtp.utils.DtpUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * auther: 图灵课堂-大都督周瑜
 */

public class DtpMonitor implements ApplicationRunner {

    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

    @Override
    public void run(ApplicationArguments args) throws Exception {

        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            monitor();
            alarm();
        }, 5, 5, TimeUnit.SECONDS);


    }

    private void monitor() {
        for (String name : DtpUtil.getAllDtpExecutorNames()) {
            DtpExecutor dtpExecutor = DtpUtil.getDtpExecutor(name);
            System.out.println(String.format("thread pool name: %s", name));
            System.out.println(String.format("core thread pool size: %s", dtpExecutor.getCorePoolSize()));
            System.out.println(String.format("maximum thread pool size: %s", dtpExecutor.getMaximumPoolSize()));
            System.out.println(String.format("active thread pool size: %s", dtpExecutor.getActiveCount()));
        }
    }

    private void alarm() {
        // 读取配置
        int max = 10;

        for (DtpExecutor executor : DtpUtil.getAllDtpExecutor()) {
            int activeCount = executor.getActiveCount();
            if (activeCount >= max) {
                System.out.println(String.format("warn, active threads is %s, warning threshold is %s", activeCount, max));
            }
        }
    }
}
