package com.niitcoder.jdk;

import com.niitcoder.aspect.MyAspect;
import jdk.nashorn.internal.lookup.MethodHandleFunctionality;

import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    public Object createProxy(Object target){
        //动态类
        Enhancer enhancer= new Enhancer() ;
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        MyAspect myAspect = new MyAspect() ;
        myAspect.check_Permissions();
        Object obj = methodProxy.invokeSuper(o ,objects) ;
        myAspect.log();
        return obj;
    }


}
