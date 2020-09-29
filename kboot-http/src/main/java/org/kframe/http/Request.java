package org.kframe.http;

/**
 * @author fangkun
 * @date 2020/9/29 14:46
 * @description: 请求
 */
public  class Request<T> {

    protected  T channel;

    public T getChannel() {
        return channel;
    }

    public void setChannel(T channel) {
        this.channel = channel;
    }

    public Request(T channel) {
        this.channel = channel;
    }

    public Request() {
    }
}
