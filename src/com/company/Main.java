package com.company;

public class Main {

    public static void main(String[] args) {
	Editor editor = new Editor();
	ArticleNew article = editor.createArticle("Test1");
	Reader reader = new Reader("Fernando");
	article.getDispatcher().subscribe(reader);
	editor.ModifyArticle("Test1","Shawarma");
	editor.DeleteArticle("Shawarma");
    }
}
