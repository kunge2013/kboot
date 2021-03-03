package org.kboot.rpc.spring;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 玄策
 * @version 1.0
 * @date 2021/3/3 7:55 下午
 * @description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({RpcClientBeanRegister.class})
public @interface RpcScan {

    String[] value() default {};

    String configuration() default "";

    String[] basePackages() default {};

    Class<?>[] basePackageClasses() default {};
}
