package by.karpovich.helloservlet.homework.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/hw_login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter("hw_login");
        var password = req.getParameter("hw_password");
        var currentLogin = req.getServletContext().getInitParameter("init_login");
        var currentPassword = req.getServletContext().getInitParameter("init_password");
        if (login.equals(currentLogin) && password.equals(currentPassword)){
            req.getSession().setAttribute("name", req.getParameter("hw_login"));
            req.getRequestDispatcher("success.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("error.html").forward(req, resp);
        }
//        req.getSession().setAttribute("name", req.getParameter("hw_login"));
//        req.getRequestDispatcher("success.html").forward(req, resp);


        }
    }

