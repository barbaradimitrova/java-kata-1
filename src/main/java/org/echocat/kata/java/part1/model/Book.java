package org.echocat.kata.java.part1.model;

public class Book extends Publishable{
    String description;

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString(){

        String authorsString = getAuthors().stream().map(e -> e.toString()).reduce(",", String::concat);
        return "Book title: "+ getTitle() + ", isbn: "+ getIsbn()+ ", description: "+ getDescription()
                +", authors: " + authorsString;

    }

}
