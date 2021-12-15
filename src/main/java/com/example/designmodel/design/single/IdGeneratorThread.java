package com.example.designmodel.design.single;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 线程唯一的单例类
 */
public class IdGeneratorThread {
    private static final ConcurrentHashMap<Long, IdGeneratorThread> instance = new ConcurrentHashMap<>();

    public IdGeneratorThread() {
    }

    public static IdGeneratorThread getInstance() {
        Long currentThreadId = Thread.currentThread().getId();
        instance.putIfAbsent(currentThreadId, new IdGeneratorThread());
        return instance.get(currentThreadId);
    }

}
