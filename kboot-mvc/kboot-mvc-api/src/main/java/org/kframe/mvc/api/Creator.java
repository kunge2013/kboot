package org.kframe.mvc.api;

/**
 * @author fangkun
 * @date 2020/9/29 14:45
 * @description: 对象 构造工厂
 */
public interface Creator<T> {
    Request create(T channel);
}
