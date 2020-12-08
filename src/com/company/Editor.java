package com.company;

import java.util.ArrayList;

public class Editor implements Observer{

    private ArrayList<ArticleNew> myNews = new ArrayList<ArticleNew>();

    @Override
    public void update(String mesaj) {
        System.out.println(mesaj);
    }

    public ArticleNew createArticle(String title){
        ArticleNew article = new ArticleNew(title);
        myNews.add(article);
        article.getDispatcher().subscribe(this);
        return article;
    }



    public void modifyArticle(String title, String newTitle){
        int flag = 0;
        for(ArticleNew article: myNews){
            if(article.getTitle().equals(title)){
                article.sendEvent("modify");
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Nothing has been modified because article " + title + " does nopt exist");
        }
    }

    public void deleteArticle(String title){
        ArticleNew a = null;
        for(ArticleNew article: myNews){
            if(article.getTitle().equals(title)){
                a = article;
                article.sendEvent("delete");
            }

        }
        myNews.remove(a);
    }
}
