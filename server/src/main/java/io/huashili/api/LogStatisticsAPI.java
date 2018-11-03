package io.huashili.api;

import io.huashili.GroupType;
import io.huashili.TopicEnum;
import io.huashili.dto.CoordinateDO;
import io.huashili.dto.LogClick;
import io.huashili.dto.LogStatistics;
import io.huashili.service.LogStatisticsService;
import io.huashili.util.IpUtil;
import io.huashili.util.PlatformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
public class LogStatisticsAPI {

    @Autowired
    private LogStatisticsService logStatisticsService;

    @RequestMapping("/data")
    public ResponseEntity<List<CoordinateDO>> groupSum(@RequestParam("key") String key, @RequestParam("groupType") Integer groupType,
                                                       @RequestParam("start") Long start) {
        List<CoordinateDO> data=logStatisticsService.groupsSum(key, GroupType.valueOf(groupType), start);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
