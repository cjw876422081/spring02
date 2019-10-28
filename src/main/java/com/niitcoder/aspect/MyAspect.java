package com.niitcoder.aspect;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyAspect implements MethodInterceptor {
    public  void check_Permissions(){
        System.out.println("权限");
    }
    public  void log(){
        System.out.println("模拟日志");
    }


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        check_Permissions();
        Object obj = methodInvocation.proceed();
        log();
        return obj ;
    }
}
