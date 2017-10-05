package org.echocat.kata.java.part1;


import org.echocat.kata.java.part1.Service.AuthorParcer;
import org.echocat.kata.java.part1.Service.BookParcer;
import org.echocat.kata.java.part1.Service.MagazineParcer;
import org.echocat.kata.java.part1.Service.ProcessService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;


@SuppressWarnings("UseOfSystemOutOrSystemErr")
@SpringBootConfiguration
@Import({
        ServiceConfig.class
})
public class ServiceApp implements CommandLineRunner {


    private final static Logger LOG = LoggerFactory.getLogger(ServiceApp.class);

    @Autowired
    private final ProcessService processService;

    public ServiceApp(ProcessService processService) {
        this.processService = processService;
    }

    @Override
    public void run(String... strings) throws Exception {
        LOG.info("Starting with kata process...");
        processService.processAll();
        LOG.info("Finshed with kata process.");
    }

    public static void main(String[] args) throws Exception {
        final SpringApplication app = new SpringApplication(ServiceApp.class);
        app.setLogStartupInfo(false);
        app.run(args);
    }
}


