package com.kframe.common.executor;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

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

        /** The time the task is enabled to execute in nanoTime units */
        private long time;

        public ScheduledMsgFutureTask(Callable<V> callable) {
            super(callable);
        }

        public ScheduledMsgFutureTask(Runnable runnable, V result) {
            super(runnable, result);
            this.time = System.nanoTime();
        }

        public ScheduledMsgFutureTask(Runnable runnable, V result, long time) {
            super(runnable, result);
            this.time = time;
        }

        public boolean isPeriodic() {
            return false;
        }

        public long getDelay(TimeUnit unit) {
            System.out.println(time);
            System.out.println(now());
            return unit.convert(time - now() , NANOSECONDS);
        }

        final long now() {
            return System.nanoTime();
        }

        public int compareTo(Delayed o) {
            return 0;
        }
    }


    static class DelayMessageQueue extends AbstractQueue<Runnable> implements BlockingQueue<Runnable>{

        private final ReentrantLock lock = new ReentrantLock();

        private final Condition available = lock.newCondition();

        private static final int INITIAL_CAPACITY = 10;

        private int size;

        private ScheduledMsgFutureTask<?>[] queue = new ScheduledMsgFutureTask<?>[INITIAL_CAPACITY];

        public Iterator<Runnable> iterator() {
            return null;
        }

        public int size() {
            return 0;
        }

        public boolean offer(Runnable runnable) {
            if (runnable == null) throw new NullPointerException();
            final ReentrantLock lock = this.lock;
            lock.lock();
            try {
                ScheduledMsgFutureTask task = (ScheduledMsgFutureTask) runnable;
                int i = size;
                if (i >= queue.length) grow();
                size = i + 1;
                // 排列到最后
                queue[i] = task;
                // 如果是第一个元素 直接唤醒任务获取
                if (queue[0] == task) {
                    available.signal();
                }
            } finally {
                lock.unlock();
            }
            return false;
        }

        /**
         * 扩容
         */
        private void grow() {
            int oldCapacity = queue.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1); // grow 50%
            if (newCapacity < 0) // overflow
                newCapacity = Integer.MAX_VALUE;
            queue = Arrays.copyOf(queue, newCapacity);
        }

        /*blkq */
        public void put(Runnable runnable) throws InterruptedException {

        }

        public boolean offer(Runnable runnable, long timeout, TimeUnit unit) throws InterruptedException {
            return false;
        }

        public Runnable take() throws InterruptedException {
            final ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try {
                for (;;) {
                    ScheduledMsgFutureTask firstTask = queue[0];
                    if (firstTask == null) {
                        available.await();
                    } else {
                        // 获取时间差
                        long delay = firstTask.getDelay(NANOSECONDS);
                        if (delay <= 0) {
                            return finishPoll(firstTask);
                        }
                        firstTask = null;
                        // 等待 delay 纳秒
                        available.awaitNanos(delay);
                    }
                }
            } finally {
                lock.unlock();
            }
        }

        private ScheduledMsgFutureTask finishPoll(ScheduledMsgFutureTask futureTask) {
            int s = -- size;
            ScheduledMsgFutureTask task = queue[s];
            queue[s] = null;
            if (s != 0) {

            }
            return futureTask;
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
