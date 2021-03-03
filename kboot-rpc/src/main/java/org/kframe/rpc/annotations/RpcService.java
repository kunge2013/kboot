package org.kframe.rpc.annotations;

import java.lang.annotation.*;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 1:30 下午
 * @description:
 */

@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RpcService {
    String name();
}
