package org.echocat.kata.java.part1.Service;


import org.echocat.kata.java.part1.Util.DsvUtil;
import org.echocat.kata.java.part1.model.Book;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;

public class BookParcer {
    public BookParcer() {
    }

    public void processBooks(@Nonnull Path path, Consumer<Book> action) throws IOException {

        DsvUtil.parseDsvFile(path, (row) -> {

            Book book = new Book();
            book.setTitle(row[0]);
            book.setIsbn(row[1]);
            int i=2;
            while(row[i].contains("@")){
                book.setAuthors(row[i]);
                i++;
            }
            book.setDescription(row[i]);
            action.accept(book);

        }, ';');
    }
}
