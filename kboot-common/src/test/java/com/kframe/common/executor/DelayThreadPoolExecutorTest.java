package com.kframe.common.executor;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;


/**
 * @author fangkun
 * @version 1.0
 * @date 2021/1/22 10:52 上午
 * @href <href>https://kunge2013.github.io</href>
 * @description:
 */
class DelayThreadPoolExecutorTest {

    @Test
    public void testDelayThreadPoolQueue() throws InterruptedException {
        DelayThreadPoolExecutor.DelayMessageQueue queue = new DelayThreadPoolExecutor.DelayMessageQueue();
        DelayThreadPoolExecutor.ScheduledMsgFutureTask<DelayThreadPoolExecutor.DelayMessageQueue> task = new DelayThreadPoolExecutor.ScheduledMsgFutureTask(() -> {
            System.out.println("xxx");
        }, new DelayThreadPoolExecutor.DelayMessageQueue(), (System.nanoTime() + TimeUnit.SECONDS.convert(10l, TimeUnit.NANOSECONDS)));

        queue.offer(task);
        System.out.println("start time ==== " + System.currentTimeMillis());
        Runnable taskInfo = queue.take();
        System.out.println("end time ==== " + System.currentTimeMillis());
        taskInfo.run();
    }

    @Test
    public void testTime() {
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime() +  TimeUnit.SECONDS.convert(3, TimeUnit.NANOSECONDS));
    }
}