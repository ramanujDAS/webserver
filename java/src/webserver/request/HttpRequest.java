package webserver.request;

import webserver.HttpBody;
import webserver.RequestMethod;

public class HttpRequest {
    private RequestMethod method;

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method=" + method +
                ", requestBody=" + requestBody +
                ", uri='" + uri + '\'' +
                '}';
    }

    private HttpBody requestBody;
    private String uri;

    public String getUri() {
        return uri;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public HttpBody getRequestBody() {
        return requestBody;
    }

    public static HttpRequest builder() {
        return new HttpRequest();
    }


    public HttpRequest uri(String uri) {
        this.uri = uri;
        return this;
    }

    public HttpRequest body(HttpBody body) {
        this.requestBody = body;
        return this;
    }

    public HttpRequest method(RequestMethod method) {
        this.method = method;
        return this;
    }

    public HttpRequest build() {
        return this;
    }
}
