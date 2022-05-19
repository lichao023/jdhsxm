package com.jdhs.project.font.page.controller;

import com.jdhs.common.utils.StringUtils;
import com.jdhs.common.utils.redis.RedisCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 权限AOP注解切片处理
 * @author 秦晓宇
 * @date: 2020年10月18日 上午12:00:57
 * @record:
 */
@Aspect
@Component
public class PermissionAnnotationAspect {

    @Autowired
    private RedisCache redisCache;

    @Pointcut("@annotation(com.jdhs.project.font.page.controller.PermissionAnnotation)")
    public void point(){

    }
    @Before("point()")
    public void begin() throws Exception{
        System.out.println("begin");
    }
    @AfterReturning("point()")
    public void after(){
        System.out.println("commit");
    }

    @Around(value = "@annotation(d)")
    public Object  around(ProceedingJoinPoint joinPoint, PermissionAnnotation d) throws Throwable{
        // 正常校验 获取request和response
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null || requestAttributes.getResponse() == null) {
            // 如果不是从前段过来的，没有request，则直接放行
            return joinPoint.proceed(joinPoint.getArgs());
        }

        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();
        // 获取token
        String token = request.getHeader("token");
        if(StringUtils.isNull(token)){
            throw new RuntimeException("请登录");
        }
        return joinPoint.proceed(joinPoint.getArgs());
    }
}
