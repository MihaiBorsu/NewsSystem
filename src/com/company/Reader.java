package com.company;

public class Reader implements Observer{

    private String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update(String mesaj) {
        System.out.println(mesaj);
    }

    public void read(ArticleNew article){

    }
}
