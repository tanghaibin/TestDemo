package top.tanghaibin.exception;

/**
 * Created by 唐海斌 on 2016/8/24.
 *
 * 自定义  运行时异常
 */
public class BizException extends RuntimeException{

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }
}
