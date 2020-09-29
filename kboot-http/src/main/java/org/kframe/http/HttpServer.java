package org.kframe.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

/**
 * @author fangkun
 * @date 2020/9/29 11:40
 * @description: httpserver 配置
 */
public class HttpServer extends Server {

    static final boolean SSL = System.getProperty("ssl") != null;
    static final int PORT = Integer.parseInt(System.getProperty("port", SSL? "8443" : "8080"));

    int port ;

    Creator<Request> requestCreator = null;

    public HttpServer(int port){
        this.port = port;
        this.requestCreator = new Creator<Request>() {
            @Override
            public Request create(Object... params) {
                final Request request = new Request();
                request.setChannel(params);
                return request;
            }
        };
    }

    public HttpServer(int port, Creator<Request> requestCreator) {
        this.port = port;
        this.requestCreator = requestCreator;
    }

    public void start() throws Exception{
        ServerBootstrap bootstrap = new ServerBootstrap();
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        bootstrap.group(boss,work)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .channel(NioServerSocketChannel.class)
                .childHandler(new HttpServerInitializer(null));

        ChannelFuture f = bootstrap.bind(new InetSocketAddress(port)).sync();
        System.out.println(" server start up on port : " + port);
        f.channel().closeFuture().sync();

    }


    public static void main(String[] args) throws Exception {
        new HttpServer(8888).start();
    }

    @Override
    protected Request createReq(ChannelHandlerContext channelContext) {
        return requestCreator.create(channelContext);
    }
}
