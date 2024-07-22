package webserver;

import java.io.File;
import java.io.Serializable;

public class HttpBody implements Serializable {
    @Override
    public String toString() {
        return "HttpBody{" +
                "body='" + body + '\'' +
                ", file=" + file +
                '}';
    }

    public HttpBody() {

    }

    private String body;
    private File file;

    public HttpBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public File getFile() {
        return file;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
