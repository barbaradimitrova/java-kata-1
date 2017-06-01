package org.echocat.kata.java.part1;
import java.util.ArrayList; import java.util.List;

/**
 * Created by goeuro on 01/06/17.
 */
public class Book extends Publishable {


    private String description;

    public Book(String title, String isbn, String authors, String description){
        this.description = description;

    }

    public String description() {
    return description;
}





}
