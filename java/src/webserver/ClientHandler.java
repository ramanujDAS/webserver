package webserver;

import webserver.headers.HeadersKey;
import webserver.headers.HeadersValue;
import webserver.request.HttpRequestHandler;
import webserver.response.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

class ClientHandler implements Runnable {

    private final Socket socket;
    private String COLON = ": ";

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            sendToOutputStream(socket);
        } catch (IOException e) {
            System.out.println("some error in current thread ::" + Thread.currentThread().getName());
        } finally {
            Thread.currentThread().interrupt();
        }
    }

    public void sendToOutputStream(Socket connection) throws IOException {
        try {
            Thread.sleep(2000);
            HttpResponse response = handleRequest(connection);
            connection.getOutputStream().write(((DefaultResponse.HTTPPROTOCOL
                    + getHttpCode(response)
                    + getHeaders(response)).getBytes()));
            connection.getOutputStream().write(getBody(response));
        } catch (Exception e) {
            System.out.println("some error :: " + e.getMessage());
        }
        connection.shutdownOutput();
        connection.close();
        System.out.println("connection ::" + connection.getPort() + " " + Thread.currentThread().getName());
    }

    private String getHttpCode(HttpResponse response) {
        if (response.getHttpStatus() == null) {
            return ResponseHttpStatus.INTERNAL_SERVER_ERROR + System.lineSeparator();
        }
        return response.getHttpStatus().toString() + System.lineSeparator();
    }

    private String getHeaders(HttpResponse response) {
        String headers = HeadersKey.CONTENT_TYPE + COLON;
        if (response.getBody().getFile() != null) {
            headers = headers + HeadersValue.HTML;
        } else headers = headers + HeadersValue.TEXT;

        headers += System.lineSeparator() + System.lineSeparator();
        return headers;
    }

    private byte[] getBody(HttpResponse response) throws IOException {
        byte[] responseBody;
        if (response.getBody().getFile() != null)
            responseBody = Files.readAllBytes(response.getBody().getFile().toPath());
        else {
            responseBody = response.getBody().getBody().getBytes();
        }
        return responseBody;
    }

    private HttpResponse handleRequest(Socket connection) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        List<String> parseString = new ArrayList<>();
        String line;
        HttpResponse response = null;
        ParseHttpRequest parser = new ParseHttpRequest();
        HttpRequestHandler requestHandler = new HttpRequestHandler();
        while ((line = bf.readLine()) != null && !line.isEmpty()) {
            parseString.add(line);
        }
        if (!parseString.isEmpty()) {
            response = requestHandler.processRequest(parser.parsePlainRequest(parseString));
        }

        return response;
    }

}
