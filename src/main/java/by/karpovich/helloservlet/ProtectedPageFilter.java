package by.karpovich.helloservlet;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class ProtectedPageFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        var attribute = req.getSession().getAttribute("allowedLogin");
        if (attribute != null && servletRequest.getParameter("hwlogin").equals(attribute)){
            servletRequest.getRequestDispatcher("error.html").forward(servletRequest, servletResponse);
        } else {
            //servletRequest.getRequestDispatcher("success.html").forward(servletRequest, servletResponse);
            filterChain.doFilter(servletRequest, servletResponse);
        }
        System.out.println("ATTRIBUTE -- " + req.getSession().getAttribute("allowedLogin"));
    }
}
