package Servlet;

import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String email = req.getParameter("email");
       String password = req.getParameter("password");

        LoginService loginService = new LoginService();
        boolean isSuccess = loginService.checkLogin(email,password);
        int roleId= loginService.checkRole(email,password);
        System.out.println("kiem tra = "+isSuccess);

        if(isSuccess){
            HttpSession session = req.getSession();
            session.setAttribute("roleId",roleId);
            session.setAttribute("email",email);
            session.setAttribute("password",password);
            resp.sendRedirect(req.getContextPath()+"/tasks");
        }else{
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
