package com.kframe.common.executor;

/**
 * @author fangkun
 * @version 1.0
 * @date 2021/1/21 8:57 下午
 * @href <href>https://kunge2013.github.io</href>
 * @description:
 */
public class ScheduledMessage extends BaseMessage {

    private long traggertime;

    public long getTraggertime() {
        return traggertime;
    }

    public void setTraggertime(long traggertime) {
        this.traggertime = traggertime;
    }
}
