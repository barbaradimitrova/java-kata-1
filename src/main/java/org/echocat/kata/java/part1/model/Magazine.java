package org.echocat.kata.java.part1.model;


import java.time.LocalDate;

public class Magazine extends Publishable{
    LocalDate publishedAt;

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public Magazine setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
        return this;
    }
    @Override
    public String toString(){

        String authorsString = getAuthors().stream().map(e -> e.toString()).reduce(",", String::concat);
        return "Magazine title: "+ getTitle() + ", isbn: "+ getIsbn()+ ", published at: "+ getPublishedAt().toString()
                +", authors: " + authorsString;

    }
}
