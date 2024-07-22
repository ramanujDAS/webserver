package webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PortRequestHandler {
    private final boolean async = false;

    public void startListener(List<ServerSocket> socketList) {
        for (ServerSocket socket : socketList) {
            listen(socket);
        }
    }

    private void listen(ServerSocket serverSocket) {
        try {
            startThread(serverSocket);
        } catch (Exception e) {
            System.out.println("error in port accept PortRequestHandler::listen  " + e.getMessage());

        }
    }

    private void startThread(ServerSocket serverSocket) {
        Runnable task = () -> {
            if (async) {
                System.out.println("starting Aysnc call");
                startAsyncThread(serverSocket);
            } else {
                Socket connection;
                ExecutorService executor = Executors.newFixedThreadPool(5);
                try {
                    serverSocket.setReuseAddress(true);
                    while (true) {
                        connection = serverSocket.accept();
                        connection.setReuseAddress(true);
                        executor.execute(new ClientHandler(connection));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(task).start();
    }

    private void startAsyncThread(ServerSocket serverSocket) {
        try {

            Socket connection;
            while (true) {
                connection = serverSocket.accept();
                Socket finalConnection = connection;
                CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> new Thread(new ClientHandler(finalConnection)).start());
            }
        } catch (IOException ie) {
            System.out.println(ie.getClass());
        }
    }


}
