package by.karpovich.helloservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(value = "/dow")
public class DayOfWeekServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var date = LocalDate.parse(req.getParameter("date"));
        var outputText = "";
        switch (date.getDayOfWeek().getValue()){
            case 1 -> outputText = "Monday";
            case 2 -> outputText = "Tuesday";
            case 3 -> outputText = "Wednesday";
            case 4 -> outputText = "Thursday";
            case 5 -> outputText = "Friday";
            case 6 -> outputText = "Saturday";
            case 7 -> outputText = "Sunday";
        }
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Day of week</h1>");
        out.println("<p>" + outputText + "</p>");
        out.println("<h1>Day of year</h1>");
        out.println("<p>" + date.getDayOfYear() + "</p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
