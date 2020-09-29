package org.kframe.http;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;

/**
 * @author fangkun
 * @date 2020/9/29 11:40
 * @description: 基础server类
 */
public abstract class DispatcherServlet {

    Creator<Request> requestCreator = null;
    /**
     * 创建request对象
     * @param channel
     * @return
     */
    protected abstract Request createReq(ChannelHandlerContext channelContext, HttpRequest req);
    /**
     * 当前上下文容器对象
     */
    protected final HttpContext context = new HttpContext();


}
