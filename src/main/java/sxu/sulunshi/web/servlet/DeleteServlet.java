package sxu.sulunshi.web.servlet;

import sxu.sulunshi.service.UserService;
import sxu.sulunshi.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取id
        String id = request.getParameter("id");
        //2、调用Service
        UserService service = new UserServiceImpl();
        service.deleteUser(id);

        //3、跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
