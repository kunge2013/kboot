package org.kframe.rpc.server;


import org.kframe.rpc.annotations.RpcService;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 2:04 下午
 * @description: Rpc 服务注册表
 */
public class ServiceRegistryImpl implements RpcServiceRegistry {

    private  Map<String, Object> RpcServiceRegistryMap = new ConcurrentHashMap<>();

    public void registryService(Class service) {
         Object rpcService = service.getAnnotation(RpcService.class);
         if (rpcService == null) {
             return;
         }
        RpcService rpcServiceInfo = (RpcService) rpcService;
        RpcServiceRegistryMap.put(rpcServiceInfo.name(), "");
    }
}
