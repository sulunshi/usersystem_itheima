package sxu.sulunshi.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import sxu.sulunshi.domin.User;
import sxu.sulunshi.service.UserService;
import sxu.sulunshi.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、设置编码
        request.setCharacterEncoding("utf-8");
        //2、获取map
        Map<String, String[]> map = request.getParameterMap();
        //3、封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4、调用Service修改
        UserService service = new UserServiceImpl();
        service.updateUser(user);
        //5、跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
