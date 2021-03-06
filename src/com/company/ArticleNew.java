package com.company;

import java.util.ArrayList;

public class ArticleNew{
    private String title;
    private ArrayList<Observer> editorSubscribers = new ArrayList<>();
    private ArrayList<Observer> readerSubscribers = new ArrayList<>();
    private Dispatcher dispatcher;

    public ArticleNew(String title){
        this.title = title;
        this.dispatcher = new Dispatcher();
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
        dispatcher.notifyAll("Titlul a fost modificat",true);

    }

    public Dispatcher getDispatcher(){
        return this.dispatcher;
    }

    public void sendEvent(String eventType) {
        this.dispatcher.sendEvent(eventType, this);
    }
}
