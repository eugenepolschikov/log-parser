package logparser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReaderWriter {

    private static final Logger log = LoggerFactory.getLogger(ReaderWriter.class);
    private static final String LOG_FULL_FILEPATH_TXT_FILE = "D:\\exadel_projects\\2019-09(verint)\\java_repo\\log-parser\\logparser\\2223334445555.txt";
    private static final String MANAGER_USERNAME_OCCURENCY = "Login.c(158): username";
    private static final String TOTAL_RESOURCE_COUNT_FIELD = "totalResourceCount";


    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(LOG_FULL_FILEPATH_TXT_FILE);

        try (Scanner fileScanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains(MANAGER_USERNAME_OCCURENCY)) {
                    log.info(line);
                } else if (line.contains(TOTAL_RESOURCE_COUNT_FIELD)) {
                    log.info(line);
                    log.info("##################");
                }
            }
        }
    }
}
