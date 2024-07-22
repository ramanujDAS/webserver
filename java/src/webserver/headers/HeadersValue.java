package webserver.headers;

public enum HeadersValue {
    TEXT("text/plain"), HTML("text/html");

    private String value;

    private HeadersValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
