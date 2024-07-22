package webserver.headers;

public enum HeadersKey {

    CONTENT_TYPE("content-type"),
    USER_AGENT("User-Agent"),
    CONNECTION_TYPE("Connection");
    private String keyString;

    private HeadersKey(String keys) {
        this.keyString = keys;
    }

    @Override
    public String toString() {
        return this.keyString;
    }
}
