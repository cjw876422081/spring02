package com.niitcoder;

import com.niitcoder.jdk.JdkProxy;
import com.niitcoder.jdk.UserDao;
import com.niitcoder.jdk.UserDaoImpl;

public class JdKTest {
    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        //原本的实例对象
        UserDao userDao = new UserDaoImpl();
        //代理后的实例化对象  增强其方法 代理的好处一个代理类大规模公共事务
        UserDao userDao1 = (UserDao) jdkProxy.createProxy(userDao);
        userDao1.addUser();
        userDao1.deleteUser();
    }
}
