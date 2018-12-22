package main.log;

import main.storage.Storage;
import servlet.HelloServlet;

import java.io.IOException;
import java.util.logging.LogManager;

public class LoggerInitializer {
    private static volatile LoggerInitializer instance;

    private LoggerInitializer (){}

    public static LoggerInitializer getInstance(){
        if (instance == null) {
            synchronized (LoggerInitializer.class) {
                if (instance == null) {
                    instance = new LoggerInitializer();
                    instance.loggerInit();
                }
            }
        }
        return instance;
    }

    private void loggerInit(){
        try
        {
            LogManager.getLogManager().readConfiguration(HelloServlet.class.getResourceAsStream("/logger.properties"));
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }


}
