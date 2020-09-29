package org.kframe.mvc.api.annotation;

import java.lang.annotation.*;

/**
 * @author fangkun
 * @date 2020/9/29 15:19
 * @description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";

}
