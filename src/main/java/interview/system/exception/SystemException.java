package interview.system.exception;

/**
 * 系统异常，该异常做debuge级别的日志记录 @see WebMvcConfigurer
 */
public class SystemException extends RuntimeException {
    /**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
