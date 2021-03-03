package org.kframe.rpc.server;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 1:50 下午
 * @description:
 */
public abstract class AbstractRpcServer implements RpcServer {

    @Override
    public void initService(String... packages) {

    }

    @Override
    public void init() {
        try {
            initService();
            initServerType(8989);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
