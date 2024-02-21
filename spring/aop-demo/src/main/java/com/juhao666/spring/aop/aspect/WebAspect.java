package com.juhao666.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class WebAspect {

    //controller 包下所有类的所有方法的任意参数
    @Pointcut("execution(public * com.juhao666.spring.aop.controller.*.*(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //请求路径
        String requestPath = request.getServletPath();
        //class name
        String className = joinPoint.getTarget().getClass().getName();
        //method name
        String methodName = joinPoint.getSignature().getName();
        //parameter values
        Object[] args = joinPoint.getArgs();
        //parameter name
        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        //parameter
        Map<String, Object> parameterMap = new HashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            parameterMap.put(parameterNames[i], args[i]);
        }
        log.info("before path: {}", requestPath);
        log.info("before class name: {}", className);
        log.info("before method name: {}", methodName);
        log.info("before args: {}", parameterMap.toString());
    }

    @After(value = "pointCut()")
    public void after(JoinPoint joinPoint) {
        //method name
        String methodName = joinPoint.getSignature().getName();
        log.info("after method name: {}", methodName);
    }

    @AfterReturning(value = "pointCut()", returning = "returnValue")
    public void afterReturn(JoinPoint joinPoint, Object returnValue) {
        String methodName = joinPoint.getSignature().getName();
        log.info("after method name: {}  return value: {} ", methodName, returnValue);
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        log.info("after throwing method name: {} exception message: {} ", methodName, e.getMessage());
    }

    @Around(value = "pointCut()") // 目标方法需要花费一定时间执行时会触发Around aspect
    public Object around(ProceedingJoinPoint joinPoint) {
        log.info("around start....");
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("around encounter error:{}",e.getMessage());
        }
        long end = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        log.info("around method name: {} execution time: {} ms ", methodName, end-start);
        log.info("around end....");
        return result;
    }
}
