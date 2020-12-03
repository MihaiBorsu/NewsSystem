package com.company;

public interface Subject {
    public void subscribe(Observer observer);
    public void unsubscribe(Observer observer);
    public void notify_all_readers();
    public void notify_all_editors();
}
