package webserver.request;

import webserver.HttpBody;
import webserver.ResponseHttpStatus;
import webserver.request.method.IMethodExecutor;
import webserver.request.method.MethodFactory;
import webserver.response.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class HttpRequestHandler implements IHttpRequestHandler {


    @Override
    public HttpResponse processRequest(HttpRequest request) {
        MethodFactory factory = MethodFactory.getInstance();
        HttpResponse response = new HttpResponse();
        IMethodExecutor methodExecutor = factory.getExecutor(request.getMethod());
        try {
            HttpBody body = methodExecutor.processRequest(request);
            response.setBody(body);
            response.setHttpStatus(ResponseHttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println("got some exception in HttpRequestHandler");
            response.setHttpStatus(ResponseHttpStatus.BAD_REQUEST);
            response.setBody(new HttpBody("error found"));
            //set the proper response and httpCode
        }
        return response;
    }

    private boolean isActionValid(HttpRequest action) {


        return false;
    }

    private byte[] getByte(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }
}
