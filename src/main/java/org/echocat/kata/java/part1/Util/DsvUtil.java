package org.echocat.kata.java.part1.Util;


import java.io.*;
import java.nio.file.Path;
import java.util.Objects;
import java.util.function.Consumer;
import au.com.bytecode.opencsv.CSVReader;
import javax.annotation.Nonnull;

public class DsvUtil {
    public DsvUtil() {
    }

    public static void parseDsvFile(@Nonnull Path path, @Nonnull Consumer<String[]> rowProcessor, char separator) throws IOException {
        Objects.requireNonNull(path);
        Objects.requireNonNull(rowProcessor);
        File dsv = path.toFile();
        if (!dsv.exists()) {
            throw new IllegalArgumentException("No file path found: " + path.getFileName().toString());
        }
        try (final FileInputStream in = new FileInputStream(dsv)) {
            try (InputStream streamDsv = new BufferedInputStream(in)) {
                try (CSVReader reader = new CSVReader(new InputStreamReader(streamDsv), separator)) {
                    String[] line;
                    boolean isHeader = true;
                    while ((line = reader.readNext()) != null) {
                        if (isHeader) {
                            isHeader = false;
                            continue;
                        }
                        while ((line = reader.readNext()) != null) {
                            rowProcessor.accept(line);
                        }
                    }
                }
            }
        }
    }
}
