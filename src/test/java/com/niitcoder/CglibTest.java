package com.niitcoder;

import com.niitcoder.jdk.*;

public class CglibTest {
    public static void main(String[] args) {
        CglibProxy cglibProxy= new CglibProxy();
        //原本的实例对象
        UserDao2 userDao = new UserDao2();

        UserDao2 userDao1 = (UserDao2) cglibProxy.createProxy(userDao);
        userDao1.addUser();
        userDao1.deleteUser();
    }
}
