package main.storage;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Storage {
    private static volatile Storage instance;

    private static Logger log = Logger.getLogger(Storage.class.getPackage().getName());

    private List<String> names = new LinkedList<String>();
   // private

    private Storage (){}

    public static Storage getInstance(){
        if (instance == null) {
            synchronized (Storage.class) {
                if (instance == null) {
                    instance = new Storage();
                }
            }
        }
        return instance;
    }

    public String returnGreetingString(){
        StringBuffer returnString = new StringBuffer();
        int i =0;
        for (String s : names){
            if (i == names.size()-1) {
                returnString.append("\nHello " + s.trim() + "!");
            } else returnString.append("\nHello " + s.trim() + "!");
            i++;
        }
      //  returnString.insert(0, isEmpty() ? "" : "Hello ");

        log.log(Level.INFO, "Stroage returned string: " + returnString);
        return returnString.toString();
    }

    public void addName(String name){
        log.log(Level.INFO, "Adding name: '" + name + "' to storage");
        names.add(name);
    }

    public boolean isEmpty(){
        log.log(Level.INFO,"called Storage.isEmpty() method, return " + names.isEmpty());
       return names.isEmpty();
    }

}
