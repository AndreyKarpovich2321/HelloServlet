package by.karpovich.helloservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class HelloFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String firstValue = servletRequest.getServletContext().getInitParameter("first");
        System.out.println("my first value " + firstValue);
        System.out.println("this is y filter");
        if (servletRequest.getParameter("name") == null)
            servletRequest.getRequestDispatcher("error.jsp").forward(servletRequest,servletResponse);
        else {
            System.out.println("hello " + servletRequest.getParameter("name"));
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
