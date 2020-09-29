package org.kframe.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;

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
        request.setChannel(channelContext);
        if (req instanceof DefaultHttpRequest) {
            DefaultHttpRequest httpRequest = (DefaultHttpRequest) req;
            request.setRequestURI(httpRequest.uri());
            request.setProtocol(httpRequest.protocolVersion().protocolName());
            httpRequest.headers().get("");
        }

        return request;
    }

}
