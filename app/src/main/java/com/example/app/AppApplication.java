package com.example.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangbin
 */
@SpringBootApplication
@EnableScheduling
@Slf4j
public class AppApplication {

  @Scheduled(cron = "*/10 * * * * ?")
  public void testLogin() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    log.info("用户登录:" + sdf.format(new Date()));
  }

  @Scheduled(cron = "*/30 * * * * ?")
  public void testLogout() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    log.info("用户退出:" + sdf.format(new Date()));
  }

  public static void main(String[] args) {
    SpringApplication.run(AppApplication.class, args);
  }
}
