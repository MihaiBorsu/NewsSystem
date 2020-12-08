package com.company;

import java.util.ArrayList;

public class Dispatcher {

    private ArrayList<Observer> editorSubscribers = new ArrayList<>();
    private ArrayList<Observer> readerSubscribers = new ArrayList<>();

    public int getArraySize() {
        return readerSubscribers.size();
    }

    public void subscribe(Observer observer) {
        if(observer instanceof Editor){
            editorSubscribers.add(observer);
        }else{
            readerSubscribers.add(observer);
            this.notifyAll("the ammount of readers has been modiefied to " + getArraySize(),false);
        }
    }

    public void unsubscribe(Observer observer) {
        if(observer instanceof Editor){
            editorSubscribers.remove(observer);
        }else{
            readerSubscribers.remove(observer);
        }
    }

    public void notifyAll(String message, boolean notifyReaders) {

        if (notifyReaders){
            for(Observer o: readerSubscribers){
                o.update("notificare: " + message );
            }
        }

        else {
            for(Observer o: editorSubscribers){
                o.update("stire" + message);
            }
        }

    }

    public void sendEvent(String eventType, ArticleNew article){
        if (eventType.equals("modify")) {
            article.setTitle("modifyiedTitle");
            this.notifyAll("titlus a fost modificat",true);
        }
        else if (eventType.equals("delete")) {
            this.notifyAll(article.getTitle() + "articolul a fost sters",true);
            article = null;
        }
        else if (eventType.equals("read")) {
            this.notifyAll("articolul a fost modificat",true);
        }
    }

}
