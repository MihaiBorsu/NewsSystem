package com.company;

import javax.crypto.spec.PSource;

public class NewsArticle {

    private int date;
    private int last_modification_date;
    private String source;
    private Editor author;
    private int no_of_reads;

    public NewsArticle(int date, int last_modification_date, String source, Editor author, int no_of_reads){
        this.date = date;
        this.last_modification_date = last_modification_date;
        this.source = source;
        this.author = author;
        this.no_of_reads = no_of_reads;
    }

}
