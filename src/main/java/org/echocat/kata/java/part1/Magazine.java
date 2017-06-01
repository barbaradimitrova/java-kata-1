package org.echocat.kata.java.part1;

import java.util.List;

/**
 * Created by goeuro on 01/06/17.
 */
public class Magazine extends Publishable {
    private String publishedAt;

    public Magazine(String title, String isbn, String authors, String publishedAt) {
        this.publishedAt = publishedAt;
    }
    public String publishedAt() {
        return publishedAt;
    }
}
