package org.echocat.kata.java.part1.model;

public class Author {
    String email;
    String firstName;
    String lastName;

    public String getLastName() {
        return lastName;
    }

    public Author setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Author setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Author setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public String toString(){

        return "Authors email: "+ getEmail() + ", first name: "+ getFirstName()+ ", last name: "+ getLastName();

    }


}
