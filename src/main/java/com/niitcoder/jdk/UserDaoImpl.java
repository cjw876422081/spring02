package com.niitcoder.jdk;

public class UserDaoImpl implements UserDao{
    @Override
    public void addUser() {
        System.out.println("增加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
