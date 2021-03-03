package org.kframe.rpc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 1:30 下午
 * @description:
 */
@Target(ElementType.TYPE)
public @interface RpcService {
    String name();
}
