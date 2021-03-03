package org.kboot.rpc.spring;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 7:28 下午
 * @description:
 */
public class ClassPathClientScanner extends ClassPathBeanDefinitionScanner {

    public ClassPathClientScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public ClassPathClientScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);
    }

    public ClassPathClientScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters, Environment environment) {
        super(registry, useDefaultFilters, environment);
    }

    public ClassPathClientScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters, Environment environment, ResourceLoader resourceLoader) {
        super(registry, useDefaultFilters, environment, resourceLoader);
    }
}
