package com.kframe.common.executor;

import java.util.concurrent.ExecutorService;

/**
 * @author fangkun
 * @version 1.0
 * @date 2021/1/21 8:56 下午
 * @href <href>https://kunge2013.github.io</href>
 * @description:
 */
public interface ScheduledMessageExecutorService extends ExecutorService {

    public void scheduledMessage(ScheduledMessage message);


}
