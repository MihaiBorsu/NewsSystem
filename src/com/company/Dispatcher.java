package com.company;

import jdk.jfr.EventType;

import java.util.ArrayList;

public class Dispatcher {

    private ArrayList<Observer> editorSubscribers = new ArrayList<>();
    private ArrayList<Observer> readerSubscribers = new ArrayList<>();

    public void subscribe(Observer observer) {
        if(observer instanceof Editor){
            editorSubscribers.add(observer);
        }else{
            readerSubscribers.add(observer);
        }
    }

    public void unsubscribe(Observer observer) {
        if(observer instanceof Editor){
            editorSubscribers.remove(observer);
        }else{
            readerSubscribers.remove(observer);
        }
    }

    public void notifyAllReaders(String message) {

        if (readerSubscribers != null){
            for(Observer o: readerSubscribers){
                o.update("notificare: " + message );
            }
        }

        if (editorSubscribers != null)
            for(Observer o: editorSubscribers){
            o.update("stire");
        }

    }

    public void sendEvent(String eventType){
        if (eventType.equals("modify")) {

        }
    }

}
