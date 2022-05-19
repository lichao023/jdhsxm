package com.jdhs.project.font.page.controller;


import java.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;

/**
 * 定义权限注解
 * @author 秦晓宇
 * @date: 2020年10月18日 上午12:22:41
 * @record:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//最高优先级
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface PermissionAnnotation {

    /**
     * @Description: 权限名称
     * @Title: permissionName
     * @return String
     * @author qin
     * @date 2020年10月18日上午12:16:43
     */
    String permissionName() default "";

}
