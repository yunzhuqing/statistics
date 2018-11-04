package io.huashili.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

    /**
     * 获取用户总数
     * @return
     */
    Long size(Map<String, Object> params);

}
