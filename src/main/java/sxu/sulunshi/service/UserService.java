package sxu.sulunshi.service;

import sxu.sulunshi.domin.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    List<User> findAll();

    User login(User user);

    void addUser(User user);

    void deleteUser(String id);

    User findUserById(String id);

    void updateUser(User user);
}
