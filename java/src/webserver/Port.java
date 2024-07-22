package webserver;

public enum Port {

    FTP(8080), DEFAULT_HTTP(80);

    @Override
    public String toString() {
        return String.valueOf(this.port);
    }

    private int port;

    private Port(int port) {
        this.port = port;
    }

    public int getPortNo() {
        return port;
    }

}
