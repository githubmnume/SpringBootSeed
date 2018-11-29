package interview.system.util;

/**
 * 响应码枚举，参考HTTP状态码的语义
 * https://express.servicenow.com/support/documentation/rest-http-response-codes-exp/
 */
public enum ResultCode{
    SUCCESS(200),//Success with response body.
    CREATED(201),//Success with response body.
    BAD_REQUEST(400),//The request URI does not match the APIs in the system, or the operation failed for unknown reasons. Invalid headers can also cause this error.
    UNAUTHORIZED(401),//The user is not authorized to use the API.
    FORBIDDEN(402),//The requested operation is not permitted for the user. This error can also be caused by ACL failures, or business rule or data policy constraints.
    SC_FORBIDDEN(403),
    NOT_FOUND(404),//The requested resource was not found. This can be caused by an ACL constraint or if the resource does not exist.
    METHOD_NOT_ALLOWED(405),//The HTTP action is not allowed for the requested REST API, or it is not supported by any API.
    NOT_ACCEPTABLE(406),//The endpoint does not support the response format specified in the request Accept header.
    INTERNAL_SERVER_ERROR(500);//internal server error

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
