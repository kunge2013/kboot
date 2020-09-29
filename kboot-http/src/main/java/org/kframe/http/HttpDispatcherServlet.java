package org.kframe.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import static io.netty.handler.codec.http.HttpHeaderNames.*;
import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderValues.*;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;

/**
 * @author fangkun
 * @date 2020/9/29 17:06
 * @description: http处理器
 */
public class HttpDispatcherServlet extends DispatcherServlet {

     static DispatcherServlet INSTANCE = new HttpDispatcherServlet();

     public static DispatcherServlet getInstance() {
         return INSTANCE;
     }

    public HttpDispatcherServlet() {
        this.requestCreator = new Creator<Request>() {
            @Override
            public Request create(Object... params) {
                return new Request();
            }
        };
    }

    @Override
    protected Request createReq(ChannelHandlerContext channelContext, HttpRequest req) {
        final Request request = requestCreator.create(channelContext);
        request.setMethod(req.method().name());
        boolean keepAlive = HttpUtil.isKeepAlive(req);
        request.setChannel(channelContext);
        if (req instanceof DefaultHttpRequest) {
            DefaultHttpRequest httpRequest = (DefaultHttpRequest) req;
            request.setRequestURI(httpRequest.uri());
            request.setProtocol(httpRequest.protocolVersion().protocolName());
            request.setHeaders(httpRequest.headers());
        }

        /*http处理*/
        ChannelHandlerContext channelHandlerContext = request.getChannel();
        FullHttpResponse response = new DefaultFullHttpResponse(req.protocolVersion(), OK,
                Unpooled.wrappedBuffer("CONTENT".getBytes()));
        response.headers()
                .set(CONTENT_TYPE, TEXT_PLAIN)
                .setInt(CONTENT_LENGTH, response.content().readableBytes());

        if (keepAlive) {
            if (!req.protocolVersion().isKeepAliveDefault()) {
                response.headers().set(CONNECTION, KEEP_ALIVE);
            }
        } else {
            // Tell the client we're going to close the connection.
            response.headers().set(CONNECTION, CLOSE);
        }

        /*返回数据*/
        final ChannelFuture f = channelHandlerContext.write(response);
        if (!keepAlive) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
        return request;
    }

}
