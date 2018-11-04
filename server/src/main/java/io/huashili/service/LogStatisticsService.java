package io.huashili.service;

import io.huashili.GroupType;
import io.huashili.dto.CoordinateDO;
import io.huashili.dto.LogStatistics;
import io.huashili.mapper.LogStatisticsMapper;
import io.huashili.mapper.UserMapper;
import io.huashili.util.RedisUtil;
import io.huashili.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LogStatisticsService {
    @Autowired
    private LogStatisticsMapper logStatisticsMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private SimpleDateFormat hourFormat = new SimpleDateFormat("yyyy-MM-dd HH");

    /**
     * 保存统计信息
     * @param logStatistics
     */
    public void save(LogStatistics logStatistics) {
        logStatisticsMapper.add(logStatistics);
    }

    /**
     * 聚合统计
     * 按照不同维度，不同时间求和
     * @param key
     * @param groupType
     * @param diff
     * @return
     */
    public List<CoordinateDO> groupsSum(String key, GroupType groupType, Long diff) {
        Map<String, Object> attrs = new HashMap<>();
        attrs.put("key", key);
        attrs.put("groupType", groupType.ordinal());
        Date lowest = new Date(System.currentTimeMillis() - diff);
        attrs.put("lowest", dateFormat.format(lowest));
        attrs.put("limit", 100);
        List<CoordinateDO> coordinates = logStatisticsMapper.groupSum(attrs);

        if(GroupType.HOUR == groupType) {
            CoordinateDO coordinateDO = new CoordinateDO();
            coordinateDO.setX(hourFormat.format(new Date()));
            Object value = redisUtil.get(key);
            if(null != value) {
                coordinateDO.setY(Double.valueOf(String.valueOf(value)));
            } else {
                coordinateDO.setY(Double.valueOf(0));
            }
            coordinates.add(coordinateDO);
        }
        return coordinates;
    }

    /**
     * 点击最多的组件
     * @return
     */
    public List<CoordinateDO> maxKeys(GroupType groupType, Long diff) {
        Map<String, Object> params = new HashMap<>();
        params.put("groupType", groupType.ordinal());
        Date lowest = new Date(System.currentTimeMillis() - diff);
        params.put("startTime", dateFormat.format(lowest));
        params.put("keys", Arrays.asList());
        params.put("offset", 0);
        params.put("len", 24);
        return logStatisticsMapper.maxKeys(params);
    }

    /**
     * 获取一小时内的增长人数
     * @return
     */
    public Long sizeOfPeople() {
        Map<String, Object> params = new HashMap<>();
        return userMapper.size(params);
    }

    /**
     * 获取一小时内的增长人数
     * @return
     */
    public Long sizeOfPeopleInHour() {
        Map<String, Object> params = new HashMap<>();
        Date now = new Date();
        params.put("startTime", TimeUtil.startDateInHour(now));
        params.put("endTime", TimeUtil.endDateInHour(now));
        return userMapper.size(params);
    }
}
