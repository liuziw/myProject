package com.zw.zXing;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/4/26 14:10
 */
public class CommonException extends RuntimeException{
    public static final long serialVersionUID = -7034897190745766939L;
    public static final Integer DEFAULT_CODE = new Integer(500);
    private Integer code;
    private String msg;

    private CommonException(String msg) {
        super(msg);
        this.code = DEFAULT_CODE;
        this.msg = msg;
    }

    private CommonException(String msg, Throwable e) {
        super(msg, e);
        this.code = DEFAULT_CODE;
        this.msg = msg;
    }

    private CommonException(String msg, Integer code) {
        super(msg);
        this.code = DEFAULT_CODE;
        this.msg = msg;
        this.code = code;
    }

    private CommonException(String msg, Integer code, Throwable e) {
        super(msg, e);
        this.code = DEFAULT_CODE;
        this.msg = msg;
        this.code = code;
    }

    public static CommonException exception(String msg) {
        return new CommonException(msg);
    }

    public static CommonException paramException(String msg) {
        return new CommonException(msg, CommonErrorCode.PARAM_ERROR_CODE);
    }

    public static CommonException exception(String msg, Throwable e) {
        return new CommonException(msg, e);
    }

    public static CommonException exception(String msg, Integer code) {
        return new CommonException(msg, code);
    }

    public static CommonException exception(Integer code, String msg) {
        return new CommonException(msg, code);
    }

    public static CommonException exception(String msg, Integer code, Throwable e) {
        return new CommonException(msg, code, e);
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return this.code.intValue();
    }

    public void setCode(int code) {
        this.code = Integer.valueOf(code);
    }
}
