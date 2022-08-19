package sxu.sulunshi.service.impl;

import sxu.sulunshi.dao.UserDao;
import sxu.sulunshi.dao.impl.UserDaoImpl;
import sxu.sulunshi.domin.User;
import sxu.sulunshi.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }
}