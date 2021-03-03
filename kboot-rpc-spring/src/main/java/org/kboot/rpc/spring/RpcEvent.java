package org.kboot.rpc.spring;

import org.springframework.context.ApplicationEvent;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 8:01 下午
 * @description:
 */
public class RpcEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public RpcEvent(Object source) {
        super(source);
    }
}
