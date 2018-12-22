package main.log;

import main.storage.Storage;
import servlet.HelloServlet;

import java.io.IOException;
import java.util.logging.LogManager;

public class LoggerInitializer {
    private static volatile LoggerInitializer instance;
    //private boolean isInit = false;

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
            //isInit = true;
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
            //isInit = false;
        }
    }


}
