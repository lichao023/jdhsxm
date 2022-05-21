package com.jdhs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author jdhs
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class RecoverApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RecoverApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  家电回收启动成功   ლ(´ڡ`ლ) ");
    }
}