package webserver.request;

import webserver.response.HttpResponse;

interface IHttpRequestHandler {

    HttpResponse processRequest(HttpRequest request);


}
