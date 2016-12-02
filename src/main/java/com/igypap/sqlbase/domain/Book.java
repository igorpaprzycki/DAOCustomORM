package com.igypap.sqlbase.domain;

/**
 * Created by igypap on 27.11.16.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public int getPages() {
        return pages;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
}
