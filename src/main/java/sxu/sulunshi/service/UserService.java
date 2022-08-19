package sxu.sulunshi.service;

import sxu.sulunshi.domin.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    List<User> findAll();
}
