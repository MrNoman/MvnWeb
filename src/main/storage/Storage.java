package main.storage;

import java.util.*;

public class Storage {
    private static volatile Storage instance;

    private List<String> names = new LinkedList<String>();

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
                returnString.append(s.trim() + "!");
            } else returnString.append(s.trim() + ", ");
            i++;
        }
        returnString.insert(0,"Hello ");
        return returnString.toString();
    }

    public void addName(String name){
        names.add(name);
    }

}
