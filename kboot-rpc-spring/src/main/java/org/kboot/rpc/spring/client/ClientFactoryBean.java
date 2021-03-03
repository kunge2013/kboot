package org.kboot.rpc.spring.client;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 7:05 下午
 * @description:
 */
public class ClientFactoryBean<T> implements FactoryBean<T>, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public  void setApplicationContext(ApplicationContext applicationContext) {
        ClientFactoryBean.applicationContext = applicationContext;

    }

    @Override
    public T getObject() throws Exception {
        return null;
    }


    @Override
    public Class<?> getObjectType() {
        return null;
    }

}
