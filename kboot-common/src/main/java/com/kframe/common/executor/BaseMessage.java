package com.kframe.common.executor;

/**
 * @author fangkun
 * @version 1.0
 * @date 2021/1/21 8:57 下午
 * @href <href>https://kunge2013.github.io</href>
 * @description:
 */
public abstract class BaseMessage {

    protected String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
