package main.service;

import main.storage.Storage;
import org.json.JSONObject;

public class HelloService {
    private static HelloService INSTANCE;

    public void saveToStorage(JSONObject json) {
        Storage.getInstance().addName(json.toString());
    }

    public void saveToStorage(String name){
        Storage.getInstance().addName(name);
    }

    public String getReturnString(){
        return Storage.getInstance().returnGreetingString();
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
}
