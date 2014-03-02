package com.alexhulbert.jmobiledevice;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Taconut
 */
public class Utils { 
    private static final AtomicLong LAST_TIME_MS = new AtomicLong();
    
    public static String unique() {
        long now = System.currentTimeMillis();
        while(true) {
            long lastTime = LAST_TIME_MS.get();
            if (lastTime >= now) {
                now = lastTime+1;
            }
            if (LAST_TIME_MS.compareAndSet(lastTime, now)) {
                return String.valueOf(now)
                        .replace('0', 'a')
                        .replace('1', 'b')
                        .replace('2', 'c')
                        .replace('3', 'd')
                        .replace('4', 'e')
                        .replace('5', 'f')
                        .replace('6', 'g')
                        .replace('7', 'h')
                        .replace('8', 'i')
                        .replace('9', 'j');
            }
        }
    }
}
