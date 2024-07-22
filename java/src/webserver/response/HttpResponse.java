package webserver.response;

import webserver.HttpBody;
import webserver.ResponseHttpStatus;

public class HttpResponse {
    protected ResponseHttpStatus httpStatus;

    @Override
    public String toString() {
        return "HttpResponse{" +
                "httpStatus=" + httpStatus +
                ", body=" + body +
                '}';
    }

    public ResponseHttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(ResponseHttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpBody getBody() {
        return body;
    }

    public void setBody(HttpBody body) {
        this.body = body;
    }

    protected HttpBody body;

    public static HttpResponse builder() {
        return new HttpResponse();
    }

    public HttpResponse status(ResponseHttpStatus status) {
        this.httpStatus = httpStatus;
        return this;
    }

    public HttpResponse body(HttpBody body) {
        this.body = body;
        return this;
    }

    public HttpResponse build() {
        return this;
    }
}
