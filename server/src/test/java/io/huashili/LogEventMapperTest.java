package io.huashili;

import io.huashili.dto.LogClick;
import io.huashili.mapper.LogClickMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StatisticsMain.class})
public class LogEventMapperTest {

    @Resource
    private LogClickMapper logClickMapper;

    @Transactional
    @Test
    public void testAddLogClick() {
        LogClick logClick = new LogClick();
        logClick.setTopic("index");
        logClick.setGroup("scene");
        logClick.setComponent("goods");
        logClick.setValue("1181001");
        logClickMapper.add(logClick);
        System.out.println(logClick.getId());
        Assert.state(logClick.getId() > 0, "插入失败");

        LogClick tmpClick = logClickMapper.get(logClick.getId());
        System.out.println("id:" + tmpClick.getId());
        System.out.println("topic:" + tmpClick.getTopic());
        Assert.notNull(tmpClick, "get失败 id:" + logClick.getId());

    }
}
