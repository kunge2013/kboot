package org.kframe.rpc.server;

import java.io.IOException;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 1:36 下午
 * @description:
 */
public interface RpcServer {

    void startListener();

    void initServerType(int port) throws IOException;

    void initService(String... packages);

    void init();
}
