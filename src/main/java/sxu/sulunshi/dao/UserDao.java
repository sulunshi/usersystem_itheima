package sxu.sulunshi.dao;

import sxu.sulunshi.domin.User;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface UserDao {
    List<User> findAll();
}