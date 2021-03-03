package org.kframe.rpc.server;


import org.kframe.rpc.annotations.RpcService;

import org.kframe.rpc.dto.RpcServerAttribute;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 2:04 下午
 * @description: Rpc 服务注册表
 */
public class ServiceRegistryImpl implements RpcServiceRegistry {

    private  Map<String, RpcServerAttribute> rpcServiceRegistryMap = new ConcurrentHashMap<>();

    public void registryService(Class service) {
         Object rpcService = service.getAnnotation(RpcService.class);
         if (rpcService == null) {
             return;
         }
        RpcService rpcServiceInfo = (RpcService) rpcService;
        rpcServiceRegistryMap.put(rpcServiceInfo.name(), null);
    }
}
