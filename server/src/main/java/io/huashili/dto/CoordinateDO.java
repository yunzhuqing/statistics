package io.huashili.dto;

import java.io.Serializable;

/**
 * 统计的坐标系
 */
public class CoordinateDO implements Serializable {
    private static final long serialVersionUID = -7547041916862347387L;

    private String x;

    private Double y;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
