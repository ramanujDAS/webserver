package webserver.resource;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ResourceHolder {

    private static Map<String, Integer> resources = new HashMap<>();
    private static Map<Integer, String> pageHolder = new HashMap<>();
    private static FileHandler fileHandler = FileHandler.getInstance();
    ;

    public ResourceHolder() {
        resources.put("/index.html", 0);
        resources.put("/home/index.html", 1);
        pageHolder.put(0, "index.html");
        pageHolder.put(1, "index2.html");

    }

    public boolean isContain(String uri) {
        return resources.containsKey(uri);
    }

    public int getValue(String uri) {
        return resources.get(uri);
    }

    public File getPage(String uri) {
        if (!isContain(uri)) {
            System.out.println("returning default error page as file address not found");
            return new File("error.html");
        }
        Optional<File> fileOPT = fileHandler.findFile(pageHolder.get(getValue(uri)));
        return fileOPT.orElseGet(() -> new File("error.html"));

    }
}
