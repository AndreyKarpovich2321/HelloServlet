package by.karpovich.helloservlet.homework.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var path = ((HttpServletRequest)servletRequest).getServletPath();
        var login = ((HttpServletRequest)servletRequest).getSession().getAttribute("login");
        var currentLogin = servletRequest.getParameter("login");
        if ("/".equals(path) || login != null){
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (currentLogin != null) {
            ((HttpServletRequest)servletRequest).getSession().setAttribute("login", currentLogin);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher("index.html").forward(servletRequest, servletResponse);
        }
    }
}
