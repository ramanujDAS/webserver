package webserver.resource;

import java.io.File;
import java.util.Optional;

public class FileHandler {
    private static FileHandler fileHandler;

    private FileHandler() {
    }

    public static synchronized FileHandler getInstance() {
        if (fileHandler == null) {
            fileHandler = new FileHandler();
            return fileHandler;
        } else return fileHandler;
    }

    public Optional<File> findFile(String filePath) {
        try {
            File file = new File(filePath);
            return Optional.of(file);
        } catch (Exception e) {
            System.out.println("no file found for ::" + filePath);
            return Optional.empty();
        }
    }
}
