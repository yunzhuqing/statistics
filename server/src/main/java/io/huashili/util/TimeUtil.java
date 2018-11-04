package io.huashili.util;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeUtil {

    /**
     * 开始时间
     * @return
     */
    public static Date startDateInHour(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取一个时间段的起始时间和结束时间
     * @param time
     * @return
     */
    public static Date endDateInHour(Date time) {
        Calendar calendar = Calendar.getInstance();
        time.setTime(time.getTime() + TimeUnit.HOURS.toMillis(1));
        calendar.setTime(time);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static void main(String [] args) {
        Date now = new Date();
        System.out.println(TimeUtil.startDateInHour(now));
        System.out.println(TimeUtil.endDateInHour(now));
    }

}
