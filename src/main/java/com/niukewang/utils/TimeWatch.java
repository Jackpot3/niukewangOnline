package com.niukewang.utils;

public class TimeWatch {

    private static long beginTime;

    private static long endTime;

    public static void begin() {
        beginTime = System.currentTimeMillis();
    }

    public static void end() {
        endTime = System.currentTimeMillis();
        System.out.println("执行时间为 : " + (endTime - beginTime)+"ms");
    }
}
