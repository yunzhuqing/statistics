package io.huashili;

import io.huashili.dto.CoordinateDO;
import io.huashili.dto.LogStatistics;
import io.huashili.mapper.LogStatisticsMapper;
import io.huashili.mapper.UserMapper;
import io.huashili.util.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StatisticsMain.class})
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;


    @Transactional
    @Test
    public void testHour() throws Exception{
        Map<String, Object> params = new HashMap<>();
        Date now = new Date();
        params.put("startTime", TimeUtil.startDateInHour(now));
        params.put("endTime", TimeUtil.endDateInHour(now));
        System.out.println("size: " + userMapper.size(params));
    }



}
