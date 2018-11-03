package io.huashili;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 *
 */
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan({"io.huashili"})
public class StatisticsMain
{
    public static void main( String[] args )
    {
        SpringApplication.run(StatisticsMain.class, args);
    }
}
