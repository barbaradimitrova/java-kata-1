package org.echocat.kata.java.part1;


import java.io.BufferedReader; import java.io.FileNotFoundException;
import java.io.FileReader; import java.io.IOException;
import java.util.ArrayList; import java.util.List;
import java.util.Scanner;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;



public class MainApp {

    public static void main(String[] args) {

        String file_path_books = "/Users/goeuro/java-kata-1/src/main/resources/org/echocat/kata/java/part1/data/authors.csv";
        List books = readCSV(file_path_books, 'b');

        String file_path_magazines = "/Users/goeuro/java-kata-1/src/main/resources/org/echocat/kata/java/part1/data/magazines.csv";
        List magazines = readCSV(file_path_magazines, 'm');

        String file_path_authors = "/Users/goeuro/java-kata-1/src/main/resources/org/echocat/kata/java/part1/data/authors.csv";
        List authors = readCSV(file_path_authors, 'a');

        String isbn = "5554-5545-4518";
        checkIsbn(isbn, books);
        checkIsbn(isbn, magazines);

        print(books);
        print(magazines);

    }


        public static List readCSV(String file_path,char type) throws FileNotFoundException, IOException {
            List items = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            String line = br.readLine();


            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] fields = line.split(";");

                String title = fields[0];
                String isbn = fields[1];
                String authors = fields[2];


                if (type =='b'){
                    String lastField = fields[3];
                    Book Book = new Book(title, isbn, authors, lastField);
                    items.add(Book);

                }else if (type =='m') {
                    String lastField = fields[3];
                    Magazine Magazine= new Magazine(title,isbn,authors,lastField);
                    items.add(Magazine);

                }else{
                    Author Author= new Author(email,lastName,firstName);
                }

            }
            br.close();
            return items;
        }

    public static void print(List items) {
        for(Publishable item : items) {
            System.out.println(item);
        }
    }

    public static void checkIsbn(String isbn, List list) {
        for (Publishable item : list){
            if (item.get("isbn") == isbn){
                System.out.println(item);
            }
        }
    }

    public static void getbyEmail(String email, List list) {
        for (Publishable item : list){
            if (item.get("author") == authors.get("lastName")){
                System.out.println(item);
            }
        }
    }


    }




        //print(books);
        //System.out.println("Parsing CSV file using CSVParser of Apache commons CSV");
       // parseCSV();


    }





}





