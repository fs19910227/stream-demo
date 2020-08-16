package com.fs.example.function.convert;

import com.fs.example.function.error.ExceptionProcessor;

import java.util.List;
import java.util.function.Supplier;

/**
 * converter 构建器
 *
 * @author zhaofushan
 * @date 2020/8/16 0016 2:34
 */
public class ConverterBuilder<C extends BaseConverter<From, To>, From, To> {
    /**
     * 异常处理器
     */
    private ExceptionProcessor<ConvertExceptionInfo> exceptionProcessor;
    /**
     * 基础转换器
     */
    private C converter;
    /**
     * source
     */
    private From source;

    /**
     * source
     */
    private List<From> sourceList;

    public ConverterBuilder(Supplier<C> converterProvider) {
        this.converter = converterProvider.get();
    }


    public ConverterBuilder<C, From, To> exceptionProcessor(ExceptionProcessor<ConvertExceptionInfo> exceptionProcessor) {
        this.exceptionProcessor = exceptionProcessor;
        return this;
    }

    public ConverterBuilder<C, From, To> source(From source) {
        this.source = source;
        return this;
    }

    public ConverterBuilder<C, From, To> source(List<From> sourceList) {
        this.sourceList = sourceList;
        return this;
    }

    public C build() {
        if (exceptionProcessor == null) {
            exceptionProcessor = exception -> {
                throw exception.getException();
            };
        }
        converter.setExceptionProcessor(exceptionProcessor);
        return converter;
    }
}
