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



    public void modifyArticle(String title, String newTitle){
        for(ArticleNew article: myNews){
            if(article.getTitle().equals(title)){
                article.sendEvent("modify");
            }
        }
    }

//    public void deleteArticle(String title){
//        ArticleNew a = null;
//        for(ArticleNew article: myNews){
//            if(article.getTitle().equals(title)){
//                article.getDispatcher().notifyAllReaders("Titlul a fost sters");
//                a = article;
//            }
//        }
//        myNews.remove(a);
//    }
}
