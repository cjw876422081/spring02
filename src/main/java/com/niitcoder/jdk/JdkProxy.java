package com.niitcoder.jdk;

import com.niitcoder.aspect.MyAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    private UserDao userDao ;
    public Object createProxy(UserDao userDao){
        this.userDao = userDao ;
        //类加载器
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        //被代理对象的所有对象
        Class[] classes = userDao.getClass().getInterfaces();
        //增强代理对象
        return Proxy.newProxyInstance(classLoader ,classes , this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyAspect myAspect = new MyAspect();
        myAspect.check_Permissions();
        Object object = method.invoke(userDao , args);
        myAspect.log();
        return object;
    }
}
