package org.kframe.rpc.client;

import org.kframe.rpc.dto.RpcClientAttribute;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 2:36 下午
 * @description:
 */
public class RemoteClientImpl {
    private Map<String, RpcClientAttribute> RpcServiceRegistryMap = new ConcurrentHashMap<>();
}
