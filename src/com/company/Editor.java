package com.company;

import java.util.ArrayList;

public class Editor implements Observer{

    private ArrayList<ArticleNew> myNews = new ArrayList<ArticleNew>();

    @Override
    public void update(String mesaj) {

    }

    public ArticleNew createArticle(String title){
        ArticleNew article = new ArticleNew(title);
        myNews.add(article);
        return article;
    }

    public void ModifyArticle(String title, String newTitle){
        for(ArticleNew article: myNews){
            if(article.getTitle().equals(title)){
                article.setTitle(newTitle);
                article.notify_all_readers();
            }
        }
    }

    public void DeleteArticle(String title){
        for(ArticleNew article: myNews){
            if(article.getTitle().equals(title)){
                myNews.remove(article);
                article.notify_all_readers();
            }
        }
    }
}
