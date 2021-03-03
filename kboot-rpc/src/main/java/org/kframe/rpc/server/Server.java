package org.kframe.rpc.server;

import java.io.IOException;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 1:59 下午
 * @description:
 */
public interface Server {
    /**
     * 启动监听
     */
    void startListener();

    /**
     * 初始化端口
     * @param port
     * @throws IOException
     */
    void initServerPort(int port) throws IOException;

}
