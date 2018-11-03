package io.huashili.service;

import io.huashili.dto.LogClick;
import io.huashili.mapper.LogClickMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogClickService {

    @Autowired
    private LogClickMapper logClickMapper;

    public void log(LogClick logClick) {
        logClickMapper.add(logClick);
    }
}
