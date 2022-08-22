package sxu.sulunshi.web.servlet;

import sxu.sulunshi.domin.PageBean;
import sxu.sulunshi.domin.User;
import sxu.sulunshi.service.UserService;
import sxu.sulunshi.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//设置编码！！！！！！！！！！！！！！！！！！！！！

        //1、获取参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        if (Integer.parseInt(currentPage) < 1) {
            currentPage = "1";
        }
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();

        //2、调用Service查询
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage, rows,condition);

        //3、将PageBean存入request
        request.setAttribute("pb", pb);

        //4、转发到list页面
        request.getRequestDispatcher("/list.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
