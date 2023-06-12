package by.karpovich.helloservlet;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.ServletContextListener;
@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("application stopped");
    }
}
