package webserver;

public enum ResponseHttpStatus {
    OK("200", "OK"),
    CREATED("201", "CREATED"),
    ACCEPTED("202", "ACCEPTED"),
    NON_AUTH_INFO("203", "Non-Authoritative Information"),
    NO_CONTENT("204", "NO CONTENT"),
    MULTIPLE_CHOICE("300", "Multiple Choices"),
    MOVED_PERM("301", "Moved Permanently"),
    BAD_REQUEST("400", "BAD REQUEST"),
    UNAUTHORISED("401", "UNAUTHORISED"),
    FORBIDDEN("403", "FORBIDDEN"),
    NOT_FOUND("404", "NOT FOUND"),
    INTERNAL_SERVER_ERROR("500", "Internal Server Error");


    private String httpResponseCode;
    private String httpStatus;

    private ResponseHttpStatus(String code, String status) {
        this.httpResponseCode = code;
        this.httpStatus = status;
    }

    @Override
    public String toString() {
        return this.httpResponseCode + " " + this.httpStatus;
    }

    public String code() {
        return this.httpResponseCode;
    }

    public String getStatus() {
        return this.httpStatus;
    }
}
