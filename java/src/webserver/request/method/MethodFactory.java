package webserver.request.method;


import webserver.RequestMethod;

public class MethodFactory {
    private MethodFactory() {

    }

    private static MethodFactory methodFactory = null;

    public IMethodExecutor getExecutor(RequestMethod method) {
        System.out.println("selecting Method for " + method);
        switch (method) {
            case GET:
                return new GET();
            case PUT:
                return new PUT();
            case POST:
                return new POST();
            case DELETE:
                return new DELETE();

        }
        return null;
    }

    public static MethodFactory getInstance() {
        if (methodFactory == null) {
            methodFactory = new MethodFactory();
            return methodFactory;
        } else {
            return methodFactory;
        }
    }
}
