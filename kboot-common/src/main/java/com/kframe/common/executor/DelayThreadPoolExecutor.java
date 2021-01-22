package com.kframe.common.executor;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangkun
 * @version 1.0
 * @date 2021/1/21 8:40 下午
 * @href <href>https://kunge2013.github.io</href>
 * @description: 延迟队列线程池实现
 */
public class DelayThreadPoolExecutor extends ThreadPoolExecutor implements ScheduledMessageExecutorService {


    public DelayThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public DelayThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public DelayThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public DelayThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    public void scheduledMessage(ScheduledMessage message) {

    }

    static class ScheduledMsgFutureTask<V>  extends FutureTask<V> implements RunnableScheduledFuture<V> {

        public ScheduledMsgFutureTask(Callable<V> callable) {
            super(callable);
        }

        public ScheduledMsgFutureTask(Runnable runnable, V result) {
            super(runnable, result);
        }

        public boolean isPeriodic() {
            return false;
        }

        public long getDelay(TimeUnit unit) {
            return 0;
        }

        public int compareTo(Delayed o) {
            return 0;
        }
    }


    static class DelayMessageQueue extends AbstractQueue<Runnable> implements BlockingQueue<Runnable>{

        private final ReentrantLock lock = new ReentrantLock();

        private static final int INITIAL_CAPACITY = 10;

        private ScheduledMsgFutureTask<?>[] queue = new ScheduledMsgFutureTask<?>[INITIAL_CAPACITY];

        public Iterator<Runnable> iterator() {
            return null;
        }

        public int size() {
            return 0;
        }

        public boolean offer(Runnable runnable) {
            return false;
        }

        /*blkq */
        public void put(Runnable runnable) throws InterruptedException {

        }

        public boolean offer(Runnable runnable, long timeout, TimeUnit unit) throws InterruptedException {
            return false;
        }

        public Runnable take() throws InterruptedException {
            return null;
        }

        public Runnable poll(long timeout, TimeUnit unit) throws InterruptedException {
            return null;
        }

        public int remainingCapacity() {
            return 0;
        }

        public int drainTo(Collection<? super Runnable> c) {
            return 0;
        }

        public int drainTo(Collection<? super Runnable> c, int maxElements) {
            return 0;
        }

        public Runnable poll() {
            return null;
        }

        public Runnable peek() {
            return null;
        }
    }

}
