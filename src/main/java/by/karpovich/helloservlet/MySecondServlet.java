package by.karpovich.helloservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

@WebServlet(value = "/hi/*")
public class MySecondServlet extends HttpServlet {
    private int counter;

    @Override
    public void init() throws ServletException {
        counter = 100;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getServletPath());
        System.out.println(req.getRequestURI());
        System.out.println(req.getParameter("my"));
        HttpSession session = req.getSession();
        Integer currentParam = (Integer) session.getAttribute("count");
        System.out.println(currentParam);
        if (currentParam == null) currentParam = counter;
        session.setAttribute("count", currentParam + 1);
        //System.out.println("headers: " + req.getHeaderNames());
        PrintWriter writer = resp.getWriter();
        writer.println("This is my second response" + ". " + currentParam);
        /*Iterator<String> headersIterator = req.getHeaderNames().asIterator();
        while (headersIterator.hasNext()){
            writer.println("\nheaders: " + req.getHeaderNames());
        }*/
        writer.println("\nhost: " + req.getHeader("host"));
        resp.setHeader("myHeader", "bhb");
        writer.println("\ncookies" + Arrays.asList(req.getCookies())
                .stream().map(cookie -> cookie.getName() + " " + cookie.getValue() + " " + cookie.getMaxAge()).collect(Collectors.toList()));
        //resp.sendRedirect("/here");
        if (currentParam > 105){
            resp.setStatus(500);
            resp.sendError(500, "too much");
        }

    }
}
