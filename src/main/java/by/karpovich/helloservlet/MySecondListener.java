package by.karpovich.helloservlet;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MySecondListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("Context attribute added ");
        System.out.println("event " + event.getName() + " " + event.getValue());
    }
}
