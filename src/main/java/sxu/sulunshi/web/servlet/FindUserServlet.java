package sxu.sulunshi.web.servlet;

import sxu.sulunshi.domin.User;
import sxu.sulunshi.service.UserService;
import sxu.sulunshi.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取id
        String id = request.getParameter("id");
        //2、调用Service查询
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);
        //3、将user存入request
        request.setAttribute("user",user);
        //4、转发到update.jsp
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
