package org.echocat.kata.java.part1.Service;


import org.echocat.kata.java.part1.Util.DsvUtil;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

public class MagazineParcer {
    public MagazineParcer() {
    }
    public List<Magazine> magazines;
    public void processMagazines(@Nonnull Path path, Consumer<Magazine> action) throws IOException {

        DsvUtil.parseDsvFile(path, (row) -> {


            Magazine magazine = new Magazine();
            magazine.setTitle(row[0]);
            magazine.setIsbn(row[1]);
            int i=2;
            while(row[i].contains("@")){
                magazine.setAuthors(row[i]);
                i++;
            }
            magazine.setPublishedAt(LocalDate.parse(row[i]));

            action.accept(magazine);

        }, ';');
    }
}
