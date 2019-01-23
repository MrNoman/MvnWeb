package listener;

import main.log.LoggerInitializer;
import servlet.HelloServlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

@WebListener
public class HelloListener implements ServletContextListener {

    private static Logger log = Logger.getLogger(HelloServlet.class.getPackage().getName());

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LoggerInitializer.getInstance();
        log.info("Logging started.");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        log.info("Logging closed.");
    }
}
