package org.echocat.kata.java.part1.Service;


import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.model.Publishable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.SyncFailedException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessService {

    @Nonnull
    private final BookParcer bookParcer;
    @Nonnull
    private final MagazineParcer magazineParcer;
    @Nonnull
    private final AuthorParcer authorParcer;

    @Value("${isnbTesting:5454-5587-3210}")
    private String isnbTesting;

    @Value("${emailTesting:null-walter@echocat.org}")
    private String emailTesting;

    @Autowired
    public ProcessService(@Nonnull BookParcer bookParcer, @Nonnull  MagazineParcer magazineParcer,
                          @Nonnull  AuthorParcer authorParcer) {
        this.bookParcer = bookParcer;
        this.magazineParcer = magazineParcer;
        this.authorParcer = authorParcer;

    }

    public void processAll() {
        final Path pathBooks = getPath("books.csv");
        final Path pathMagazines = getPath("magazines.csv");
        final Path pathAuthors = getPath("authors.csv");

        try {
            List<Book> books =new LinkedList<>();
            List<Magazine> magazines =new LinkedList<>();
            List<Author> authors =new LinkedList<>();

            bookParcer.processBooks(pathBooks, book -> books.add(book));
            magazineParcer.processMagazines(pathMagazines, magazine -> magazines.add(magazine));
            authorParcer.processAuthors(pathAuthors, author -> authors.add(author));

            Stream<Publishable> booksAndMagazines = Stream.concat(books.stream(),magazines.stream());

            authors.stream().map(x->x.toString()).forEach(System.out::println);
            booksAndMagazines.map(x->x.toString()).forEach(System.out::println);


            findByIsbn(booksAndMagazines,isnbTesting);

            findByEmail(booksAndMagazines,emailTesting);

            sortByTitle(booksAndMagazines);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   public void findByIsbn(Stream<Publishable> publishables, String isbn){
       Publishable result = publishables
               .filter(p->p.getIsbn().equals(isbn))
               .findFirst().orElse(null);
       System.out.println("Isbn:"+ isbn+"is titled:"+ result.getTitle());
   }

    public void findByEmail(Stream<Publishable>  publishables, String email){
        publishables
                .flatMap(publishable -> publishable.getAuthors().stream())
                .filter(author-> author.equals(email))
                .forEach(u -> System.out.println());
    }

    public void sortByTitle(Stream<Publishable>  publishables){
        publishables
                .sorted((o1, o2)->o1.getTitle().compareTo(o2.getTitle()))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private Path getPath(String fileName) {
        return Paths.get(this.getClass().getResource(fileName).getPath());
    }
}
