package by.karpovich.helloservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value = "/third")
public class ThirdServlet extends HttpServlet {
    private int value = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //request
        req.getAttribute("regAttr");
        req.setAttribute("reqAttr", "123");
        req.getAttribute("regAttr");
        //session

        value = req.getSession().getAttribute("sessAttr") == null ? 0 : (Integer)req.getSession().getAttribute("sessAttr");
        req.getSession().setAttribute("sessAttr", value++);
        req.getSession().getAttribute("sessAttr");

        //application
        var appVar = req.getServletContext().getAttribute("appAttr");
        var result = appVar == null ? 0: (Integer) appVar + 1;
        req.getServletContext().setAttribute("appAttr", result);
    }
}
