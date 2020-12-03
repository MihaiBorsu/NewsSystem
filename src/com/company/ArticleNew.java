package com.company;

import java.util.ArrayList;

public class ArticleNew implements Subject{
    private String title;
    private ArrayList<Observer> editorSubscribers = new ArrayList<>();
    private ArrayList<Observer> readerSubscribers = new ArrayList<>();

    public ArticleNew(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public void subscribe(Observer observer) {
        if(observer instanceof Editor){
            editorSubscribers.add(observer);
        }else{
            readerSubscribers.add(observer);
        }
    }

    @Override
    public void unsubscribe(Observer observer) {
        if(observer instanceof Editor){
            editorSubscribers.remove(observer);
        }else{
            readerSubscribers.remove(observer);
        }
    }

    @Override
    public void notify_all_readers() {
        if (readerSubscribers != null){
            for(Observer o: readerSubscribers){
                o.update("stirea: " + title);
            }
        }
    }

    @Override
    public void notify_all_editors() {
        for(Observer o: editorSubscribers){
            o.update("stire");
        }
    }
}
