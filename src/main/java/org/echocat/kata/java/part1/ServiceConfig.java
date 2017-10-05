package org.echocat.kata.java.part1;


import org.echocat.kata.java.part1.Service.AuthorParcer;
import org.echocat.kata.java.part1.Service.BookParcer;
import org.echocat.kata.java.part1.Service.MagazineParcer;
import org.echocat.kata.java.part1.Service.ProcessService;
import org.springframework.context.annotation.Bean;


import javax.annotation.Nonnull;

public class ServiceConfig {
    @Bean
    public ProcessService processService(
            @Nonnull BookParcer bookParcer,
            @Nonnull MagazineParcer magazineParcer,
            @Nonnull AuthorParcer authorParcer) {
        return new ProcessService(bookParcer, magazineParcer, authorParcer);
    }
}
