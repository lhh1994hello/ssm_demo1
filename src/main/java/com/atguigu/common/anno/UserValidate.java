package com.atguigu.common.anno;

import java.lang.annotation.*;

/**
 * @author lhh
 * @date 2019/4/12 11:26
 * @Description: 自定义注解，检查用户
 */
@Documented
@Inherited //继承
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserValidate {
    public int min() default 1;

    public int max() default 10;

    public boolean isNotNull() default true;
}
