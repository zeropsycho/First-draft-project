package com.test.util;

import java.util.Calendar;

public class DateUtil {

    /**
     *
     * @param time 系统时间（单位毫秒）
     * @param strDate 时间范围戳（单位时分秒）
     * @return true：在该事件范围内，false：不在事件范围内
     */
    public static boolean isInDate(long time, String strDate) {
        Calendar calendar = Calendar.getInstance();
        time = System.currentTimeMillis(); //本机时间

        //规定格式拆分
        String[] strSplit = strDate.split("~");
        String strDateBegin = strSplit[0];
        String strDateEnd = strSplit[1];

        //处理开始时间
        String[] startTime = strDateBegin.split(":");
        calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(startTime[0])); //时 毫秒
        calendar.set(Calendar.MINUTE, Integer.valueOf(startTime[1])); //分 毫秒
        calendar.set(Calendar.SECOND, Integer.valueOf(startTime[2])); //秒 毫秒
        calendar.set(Calendar.MILLISECOND, 0);
        long startTimeL = calendar.getTimeInMillis();

        //处理结束时间
        String[] endTimel = strDateEnd.split(":");
        calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(endTimel[0]));
        calendar.set(Calendar.MINUTE, Integer.valueOf(endTimel[1]));
        calendar.set(Calendar.SECOND, Integer.valueOf(endTimel[2]));
        calendar.set(Calendar.MILLISECOND, 0);
        long endTimeL = calendar.getTimeInMillis();

        System.out.println("分割后的时间：" + strDateBegin + "\n二：" + strDateEnd);
        System.out.println("当前时间Long：" + time + "\n开始时间Long：" + startTimeL + "\n结束时间Long：" + endTimeL);

        return time >= startTimeL && time <= endTimeL;
    }

    public static void main(String[] args) {
        System.out.println(isInDate(System.currentTimeMillis(), "16:56:00~17:00:00"));
    }
}
