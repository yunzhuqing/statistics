package io.huashili.api;

import io.huashili.TopicEnum;
import io.huashili.dto.CoordinateDO;
import io.huashili.dto.LogClick;
import io.huashili.util.IpUtil;
import io.huashili.util.PlatformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@RestController
public class LogClickAPI {
    @Autowired
    private Queue logClickQueue;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/")
    public String root() {
        return "这是花十里统计平台";
    }

    @RequestMapping("/log")
    public ResponseEntity<String> log(@RequestBody LogClick logClick, HttpServletRequest request) {
        if(StringUtils.isEmpty(logClick.getPlatform()) || !PlatformUtil.contain(logClick.getPlatform())) {
            return new ResponseEntity<>("platform must be provided", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(!TopicEnum.contains(logClick.getTopic())) {
            return new ResponseEntity<>("topic can not be found", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logClick.setIp(IpUtil.getIpAddr(request));
        logClick.setCreateTime(new Date());
        jmsMessagingTemplate.convertAndSend(logClickQueue, logClick);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
