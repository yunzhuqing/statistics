package io.huashili;

import io.huashili.dto.LogStatistics;
import io.huashili.service.LogStatisticsService;
import io.huashili.util.RedisUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class StatisticsTimeJob {

    @Resource
    private LogStatisticsService logStatisticsService;


    @Resource
    private RedisUtil redisUtil;

    /**
     * 每隔一个小时执行
     */
    @Scheduled(cron = "0 0 0/1 * * *")
    public void syncClickData() {
        TopicEnum[] topics = TopicEnum.values();
        for (TopicEnum topic : topics) {
            Object val = redisUtil.get(topic.getId());
            if (null == val) {
                continue;
            }
            String value = String.valueOf(val);
            LogStatistics logStatistics = new LogStatistics();
            logStatistics.setKey(topic.getId());
            logStatistics.setVal(Double.valueOf(value));
            logStatistics.setTime(new Date());
            logStatisticsService.save(logStatistics);
            redisUtil.set(topic.getId(), 0);
        }
    }

    /**
     * 每小时统计一次增长人数
     */
    @Scheduled(cron = "0 0 0/1 * * *")
    public void syncUserTotal() {
        Long size  = logStatisticsService.sizeOfPeopleInHour();
        LogStatistics logStatistics = new LogStatistics();
        logStatistics.setKey(TopicEnum.USER_TOTAL_HOUR.getId());
        logStatistics.setVal(Double.valueOf(size));
        logStatistics.setTime(new Date());
        logStatisticsService.save(logStatistics);
    }
}
