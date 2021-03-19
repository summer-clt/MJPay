package com.mujin.annotation;

import java.lang.annotation.*;

/**
 * Description:
 *
 * @Author: 伍成林
 * @Date： 2021年 03月18日
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PropertyKey {
    /**
     * 配置文件的key
     */
    String value();
}
