package sxu.sulunshi.service;

import sxu.sulunshi.domin.PageBean;
import sxu.sulunshi.domin.User;

import java.util.List;
import java.util.Map;

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

    void deleteUsers(String[] ids);

    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
