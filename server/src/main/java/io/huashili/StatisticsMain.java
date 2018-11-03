package io.huashili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 *
 */
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableCaching
@EnableScheduling
@ComponentScan({"io.huashili"})
public class StatisticsMain
{
    public static void main( String[] args )
    {
        SpringApplication.run(StatisticsMain.class, args);
    }
}
