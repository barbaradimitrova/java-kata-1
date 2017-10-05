package org.echocat.kata.java.part1.model;


import java.util.List;

public class Publishable {
    String title;
    String isbn;
    List<String> authors;

    public List<String> getAuthors() {
        return authors;
    }

    public Publishable setAuthors(String authors) {
        this.authors.add(authors);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Publishable setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Publishable setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }


}
