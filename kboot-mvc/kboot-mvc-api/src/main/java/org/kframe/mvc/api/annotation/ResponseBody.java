package org.kframe.mvc.api.annotation;

import java.lang.annotation.*;

/**
 * @author fangkun
 * @date 2020/9/29 15:20
 * @description:
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseBody {

}

