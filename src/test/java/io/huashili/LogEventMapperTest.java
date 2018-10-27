package io.huashili;

import io.huashili.dto.LogClick;
import io.huashili.mapper.LogEventMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StatisticsMain.class})
public class LogEventMapperTest {

    @Resource
    private LogEventMapper logEventMapper;

    @Transactional
    @Test
    public void testAddLogClick() {
        LogClick logClick = new LogClick();
        logClick.setTopic("index");
        logEventMapper.add(logClick);
        System.out.println(logClick.getId());
        Assert.state(logClick.getId() > 0, "插入失败");
    }
}
