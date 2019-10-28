package com.niitcoder;

import com.niitcoder.jdk.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyFactoryBeanTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Bean.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("proxy");
        userDao.deleteUser();
        userDao.addUser();

    }
}
