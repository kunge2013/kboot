package org.kframe.rpc.server;

import java.io.IOException;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 1:59 下午
 * @description:
 */
public interface Server {
    void startListener();

    void initServerType(int port) throws IOException;
}
