package logparser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReaderWriter {

    protected static final Logger log = LoggerFactory.getLogger(ReaderWriter.class);


    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "D:\\exadel_projects\\2019-09(verint)\\java_repo\\logparser\\2223334445555.txt"; //this path is on my local
        InputStream inputStream = new FileInputStream(fileName);

        try (Scanner fileScanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains("Login.c(158): username")) {
                    log.info(line);
                } else if (line.contains("totalResourceCount")) {
                    log.info(line);
                    log.info("##################");
                }
            }
        }
    }
}
