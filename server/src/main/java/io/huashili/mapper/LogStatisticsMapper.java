package io.huashili.mapper;

import io.huashili.GroupType;
import io.huashili.dto.CoordinateDO;
import io.huashili.dto.LogStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface LogStatisticsMapper {

    /**
     * 添加统计
     * @param logStatistics
     * @return
     */
    int add(LogStatistics logStatistics);

    /**
     * 聚合统计
     * @param attrs
     * @return
     */
    List<CoordinateDO> groupSum(Map<String, Object> attrs);

    /**
     * 点击数最多的前10个组件
     * @param attrs
     * @return
     */
    List<CoordinateDO> maxKeys(Map<String, Object> attrs);
}
