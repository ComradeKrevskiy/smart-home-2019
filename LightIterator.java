package src.ru.sbt.mipt.oop;

import java.util.Collection;
import java.util.Iterator;

public class LightIterator {
    private Iterator<Room> roomIt;
    private Iterator<Light> lightIt;


    public boolean hasNext(){
        return lightIt != null && lightIt.hasNext();
    }

    private void next_(){
        if(roomIt.hasNext()) {
            lightIt = roomIt.next().getLights().iterator();
        }
        else{
            lightIt = null;
        }
    }


    Light next(){
        Light light = lightIt.next();
        if(!lightIt.hasNext()){
            next_();
        }
        return light;
    }

    public LightIterator(SmartHome smartHome){
        Collection<Room> rooms = smartHome.getRooms();
        roomIt = rooms.iterator();
        next_();
    }
}
