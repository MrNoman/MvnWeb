package main.service;

import main.storage.Storage;
import org.json.JSONObject;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class HelloService {
    private static HelloService INSTANCE;

    private static Logger log = Logger.getLogger(HelloService.class.getPackage().getName());

    private void loggerInit(){
        try
        {
            LogManager.getLogManager().readConfiguration(HelloService.class.getResourceAsStream("/logger.properties"));
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    public static HelloService getInstance() {
        if (INSTANCE == null) {
            synchronized (HelloService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HelloService();
                }
            }
        }
        return INSTANCE;
    }

    public void saveToStorage(JSONObject json) {
        Storage.getInstance().addName(json.toString());
    }

    public void saveToStorage(String name){
        loggerInit();
        log.log(Level.INFO, "called HelloService.saveToStorage() method to save name '" + name+"'");
        Storage.getInstance().addName(name);
    }

    public String getReturnString(){
        loggerInit();
        String returnString = Storage.getInstance().returnGreetingString();
        log.log(Level.INFO, "called Service.getReturnString() method, method returned: '" + returnString+"'");
        return returnString;
    }


    public String getStartPageContext(){
        loggerInit();
        String returnString = Storage.getInstance().returnGreetingString();
        if (returnString.isEmpty()) {
            log.log(Level.INFO, "called HelloService.getStartPageContext() method, returned empty string");
            return "";
        } else {
            log.log(Level.INFO, "called HelloService.getStartPageContext() method, returned '" + returnString+"'");
            return returnString;
        }

    }
}
