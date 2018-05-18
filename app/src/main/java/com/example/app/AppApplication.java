package com.example.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangbin
 */
@SpringBootApplication
@EnableScheduling
@Slf4j
public class AppApplication {

  public List<String> users = new ArrayList<>();
  public List<String> operations = new ArrayList<>();

  /**
   * 每秒执行一次
   */
  @Scheduled(cron = "*/1 * * * * ?")
  public void test() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    log.info(sdf.format(new Date()) + "用户" + getRandomUser() + "执行" + getRandomOperation() + "操作");
  }

  /**
   * 随机获取用户
   */
  private String getRandomUser() {
    return users.get(new Random().nextInt(users.size()));
  }

  /**
   * 随机获取操作
   */
  private String getRandomOperation() {
    return operations.get(new Random().nextInt(operations.size()));
  }

  @Bean
  CommandLineRunner runner() {
    return args -> {
      users.addAll(Arrays.asList("刘大", "钱二", "张三", "李四", "王五", "赵六", "田七"));
      operations.addAll(Arrays.asList("登录", "退出", "转账", "收款", "发送消息", "接受消息", "加入群聊", "退出群聊"));
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(AppApplication.class, args);
  }
}
