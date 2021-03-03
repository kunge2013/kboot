package org.kframe.rpc.server;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 1:50 下午
 * @description:
 */
public abstract class AbstractRpcServer implements RpcServer {

    public void initService(String... packages) {

    }

    public void start() {

    }


    public abstract void initServerPort(int port);

    @Override
    public void init() {
        try {
            initService();
            initServerPort(8989);
            start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
