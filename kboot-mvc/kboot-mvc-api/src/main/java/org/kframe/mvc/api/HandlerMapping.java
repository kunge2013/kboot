package org.kframe.mvc.api;

/**
 * @author fangkun
 * @date 2020/10/24 11:02
 * @description:
 */
public interface HandlerMapping {
    HandlerExecutionChain  getHandler(Request request);
}
