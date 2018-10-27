package io.huashili.mapper;

import io.huashili.dto.LogClick;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogEventMapper {
    void add(LogClick logClick);

    LogClick get(Long id);
}
