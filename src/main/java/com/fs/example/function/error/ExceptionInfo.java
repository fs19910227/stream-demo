package com.fs.example.function.error;

/**
 * 异常信息
 *
 * @author zhaofushan
 * @date 2020/8/16 0016 1:21
 */
public abstract class ExceptionInfo {
    /**
     * 异常信息
     */
    private RuntimeException exception;

    public RuntimeException getException() {
        return exception;
    }

    public void setException(RuntimeException exception) {
        this.exception = exception;
    }
}
