package org.kboot.rpc.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 7:26 下午
 * @description:
 */
public class RpcClientBeanRegister implements ResourceLoaderAware, BeanPostProcessor, ApplicationListener<RpcEvent> {

    private ResourceLoader resourceLoader;

    private final ConfigurableApplicationContext applicationContext;

    public RpcClientBeanRegister(ResourceLoader resourceLoader, ConfigurableApplicationContext applicationContext) {
        this.resourceLoader = resourceLoader;
        this.applicationContext = applicationContext;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public ClassPathClientScanner registerScanner() {
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) applicationContext.getBeanFactory();
        ClassPathClientScanner clientScanner = new ClassPathClientScanner(registry);
        return clientScanner;
    }


    @Override
    public void onApplicationEvent(RpcEvent event) {
        registerScanner();
    }
}
