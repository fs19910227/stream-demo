package com.fs.example.function.error;

/**
 * 异常处理器
 *
 * @author zhaofushan
 * @date 2020/8/16 0016 0:39
 */
@FunctionalInterface
public interface ExceptionProcessor<T extends ExceptionInfo> {

    /**
     * 异常处理
     *
     * @param exception
     */
    void processException(T exception);
}
