package com.railway.transportation.framword.starter.common.toolkit;

import lombok.SneakyThrows;

/**
 * 线程池工具类
 */
public final class ThreadUtil {

    @SneakyThrows(value = InterruptedException.class)
    public static void sleep(long millis) {
        Thread.sleep(millis);
    }
}
