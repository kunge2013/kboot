package org.kframe.mvc.api;

/**
 * @author fangkun
 * @date 2020/9/29 14:46
 * @description: 响应
 */
public abstract class Response<T> {

    protected  T channel;

    public T getChannel() {
        return channel;
    }

    public void setChannel(T channel) {
        this.channel = channel;
    }
}
