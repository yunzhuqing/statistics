package io.huashili;

import io.huashili.dto.CoordinateDO;
import io.huashili.dto.LogStatistics;
import io.huashili.mapper.LogStatisticsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StatisticsMain.class})
public class LogStatisticsMapperTest {

    @Resource
    private LogStatisticsMapper logStatisticsMapper;


    @Transactional
    @Test
    public void testHour() throws Exception{
        SimpleDateFormat hourFormat = new SimpleDateFormat("yyyy-MM-dd HH");
        String key="index-suggest";
        for(int i=0; i<20; i++) {
            LogStatistics logStatistics = new LogStatistics();
            logStatistics.setKey(key);
            logStatistics.setVal(Double.valueOf(23 + i));
            logStatistics.setTime(hourFormat.parse("2018-11-01 "+(12 + i)+":00:00"));
            logStatisticsMapper.add(logStatistics);
            Assert.state(logStatistics.getId() > 0, "插入失败");
        }

        int limit = 4;
        Map<String, Object> attrs = new HashMap<>();
        attrs.put("key", key);
        attrs.put("groupType", GroupType.HOUR.ordinal());
        attrs.put("lowest", "2018-10-30 00:00:00");
        attrs.put("limit", limit);
        List<CoordinateDO> coordinateDOList = logStatisticsMapper.groupSum(attrs);
        Assert.state(coordinateDOList.size() > 0, "查询失败");
        coordinateDOList.forEach(coordinateDO -> {
            System.out.println(coordinateDO.getX() + " " + coordinateDO.getY());
        });

        attrs.put("groupType", GroupType.DAY.ordinal());
        coordinateDOList = logStatisticsMapper.groupSum(attrs);
        Assert.state(coordinateDOList.size() > 0, "查询失败");
        coordinateDOList.forEach(coordinateDO -> {
            System.out.println(coordinateDO.getX() + " " + coordinateDO.getY());
        });

        attrs.put("groupType", GroupType.MONTH.ordinal());
        coordinateDOList = logStatisticsMapper.groupSum(attrs);
        Assert.state(coordinateDOList.size() > 0, "查询失败");
        coordinateDOList.forEach(coordinateDO -> {
            System.out.println(coordinateDO.getX() + " " + coordinateDO.getY());
        });
    }


}
