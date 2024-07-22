package webserver.request.method;

import webserver.HttpBody;
import webserver.request.HttpRequest;

public interface IMethodExecutor {

    HttpBody processRequest(HttpRequest body);


}
