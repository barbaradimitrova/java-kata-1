package org.echocat.kata.java.part1.Service;

import org.echocat.kata.java.part1.Util.DsvUtil;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Consumer;

public class AuthorParcer {
    public AuthorParcer() {
    }
    public void processAuthors(@Nonnull Path path, Consumer<Author> action) throws IOException {

        DsvUtil.parseDsvFile(path, (row) -> {

            Author author = new Author();
            author.setEmail(row[0]);
            author.setFirstName(row[1]);
            author.setFirstName(row[2]);
            action.accept(author);

        }, ';');

    }

}
