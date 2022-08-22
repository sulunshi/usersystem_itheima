package sxu.sulunshi.service.impl;

import sxu.sulunshi.dao.UserDao;
import sxu.sulunshi.dao.impl.UserDaoImpl;
import sxu.sulunshi.domin.PageBean;
import sxu.sulunshi.domin.User;
import sxu.sulunshi.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.deleteUser(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleteUsers(String[] ids) {
        for (String id : ids) {
            dao.deleteUser(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //1、创建一个空的PageBean对象
        PageBean<User> pb = new PageBean<>();
        //2、设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3、调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4、调用dao查询list集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows, condition);
        pb.setList(list);
        //5、计算总页码
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}
