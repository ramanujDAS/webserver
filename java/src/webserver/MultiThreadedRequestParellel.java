package webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedRequestParellel {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        MultiThreadedRequestParellel obj = new MultiThreadedRequestParellel();
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                public void run() {
                    try {
                        obj.handleRequest(connection);
                        connection.getOutputStream().write(("HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n\r\n" + "<html><head></head><body><h1>Hello</h1></body></html>").getBytes());

                        connection.shutdownOutput();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            new Thread(task).start();
        }
    }

    public void handleRequest(Socket connection) throws InterruptedException {

        int x = 0;
        // System.out.println("handle request called");

        System.out.println(" socket  : " + connection.toString() + " thread : " + Thread.currentThread().getName());
        System.out.println("handle request finished : value " + ++x);
    }


}
