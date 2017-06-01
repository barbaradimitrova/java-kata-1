package org.echocat.kata.java.part1;

/**
 * Created by goeuro on 01/06/17.
 */
public class Author{
    private String email;
    private String lastName;
    private String firstName;

    public Author(String email, String lastName, String firstName) {
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    public String email() {
        return email;
    };
    public String lastName() {
        return lastName;
    };
    public String firstName() {
        return firstName;
    };

}
