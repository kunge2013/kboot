package org.kframe.rpc.server;

import java.io.IOException;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 1:36 下午
 * @description:
 */
public interface RpcServer extends Server{

    void initService(String... packages);

    void init();
}
