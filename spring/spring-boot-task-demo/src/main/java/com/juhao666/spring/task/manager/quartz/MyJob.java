package com.juhao666.spring.task.manager.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Slf4j
@Component
public class MyJob extends QuartzJobBean {
//    @Autowired
//    DataSource dataSource;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        jdbcTemplate.update("INSERT INTO emp (username, age, position) VALUES (?, ?,?)", "abc", 60, "CXX");
        //可以在这里调用Service代码实现自定义的业务逻辑
        log.info("This is my quartz job running...");
    }
}
