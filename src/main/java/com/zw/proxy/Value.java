package com.zw.proxy;

import java.lang.annotation.*;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/5/10 17:19
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();
}
