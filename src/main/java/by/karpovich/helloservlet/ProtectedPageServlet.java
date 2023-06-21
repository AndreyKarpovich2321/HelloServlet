package by.karpovich.helloservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(value = "/hw-login")
public class ProtectedPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter("hwlogin");
        var password = req.getParameter("hw_password");
        var currLogin = req.getServletContext().getInitParameter("hw_login");
        var currPass = req.getServletContext().getInitParameter("hw_password");
        if (login.equals(currLogin) && password.equals(currPass)) {
            req.getSession().setAttribute("allowedLogin", login);
            resp.sendRedirect("success.html");
        } else {
            resp.sendRedirect("error.html");
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            System.out.println("Login " + login);
            System.out.println("Password " + password);

        }
    }
}
