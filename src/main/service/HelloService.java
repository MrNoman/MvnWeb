package main.service;

import main.storage.Storage;
import org.json.JSONObject;

import java.awt.*;

public class HelloService {
    private static HelloService INSTANCE;


    public void save(JSONObject json) {
        Storage.getInstance().addName(json.toString());
    }

    public void save(String name){
        Storage.getInstance().addName(name);
    }
/*
    public ArtistDto findOne(Long id) {
        Artist foundArtist = ArtistDao.getInstance().findOne(id);
        if (foundArtist == null) {
            return null;
        }
        return new ArtistDto(foundArtist.getId(), foundArtist.getName());
    }
*/
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
