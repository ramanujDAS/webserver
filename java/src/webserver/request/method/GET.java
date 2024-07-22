package webserver.request.method;

import webserver.HttpBody;
import webserver.request.HttpRequest;
import webserver.resource.ResourceHolder;

import java.io.File;

public class GET implements IMethodExecutor {
    @Override
    public HttpBody processRequest(HttpRequest request) {
        ResourceHolder resourceHolder = new ResourceHolder();
        File fileResponse = resourceHolder.getPage(request.getUri());
        HttpBody body = new HttpBody();
        body.setFile(fileResponse);
        return body;
    }
}
