package interview.system.util;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }
    
    public static Result genSuccessCreatedResult() {
        return new Result()
                .setCode(ResultHttpCode.SC_CREATED)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.BAD_REQUEST)
                .setMessage(message);
    }
    public static Result genErrorResult(String message) {
    	return new Result()
    			.setCode(ResultCode.INTERNAL_SERVER_ERROR)
    			.setMessage(message);
    }
    
    public static Result genResult(ResultCode resultCode,String message,Object data) {
    	return new Result()
    			.setCode(resultCode)
    			.setMessage(message)
    			.setData(data);
    }
}
