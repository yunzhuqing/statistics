package io.huashili.service;

import io.huashili.GroupType;
import io.huashili.dto.CoordinateDO;
import io.huashili.dto.LogStatistics;
import io.huashili.mapper.LogStatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogStatisticsService {
    @Autowired
    private LogStatisticsMapper logStatisticsMapper;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
        return logStatisticsMapper.groupSum(attrs);
    }
}
