package io.huashili.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志统计
 */
public class LogStatistics implements Serializable {

    private static final long serialVersionUID = -4002495069317230435L;

    private Long id;

    private String key;

    private Double val;

    private Date time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Double getVal() {
        return val;
    }

    public void setVal(Double val) {
        this.val = val;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
