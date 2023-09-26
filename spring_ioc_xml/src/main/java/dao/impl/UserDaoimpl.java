package dao.impl;

import dao.UserDao;

public class UserDaoimpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
