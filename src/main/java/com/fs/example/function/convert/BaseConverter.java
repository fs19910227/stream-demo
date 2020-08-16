package com.fs.example.function.convert;

import com.fs.example.function.error.ExceptionProcessor;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 抽象 From->To Converter
 *
 * @author zhaofushan
 * @date 2020/8/16 0016 0:03
 */
public abstract class BaseConverter<From, To> implements Converter<From, To> {
    /**
     * 异常处理器
     */
    private ExceptionProcessor<ConvertExceptionInfo> exceptionProcessor;

    protected BaseConverter() {
    }

    void setExceptionProcessor(ExceptionProcessor<ConvertExceptionInfo> exceptionProcessor) {
        this.exceptionProcessor = exceptionProcessor;
    }


    @Override
    public To convert(From from) {
        return convert(from, this::doConvert, ConvertOperate.SINGLE, exceptionProcessor);
    }

    private To convert(From from,
                       Converter<From, To> converterMethod,
                       ConvertOperate convertOperate,
                       ExceptionProcessor<ConvertExceptionInfo> exceptionProcessor) {
        if (from == null) {
            return null;
        }
        try {
            return converterMethod.convert(from);
        } catch (RuntimeException exception) {
            exceptionProcessor.processException(new ConvertExceptionInfo(convertOperate, exception));
        }
        return null;
    }

    abstract protected To doConvert(From from);

    /**
     * 列表转换
     * 使用默认的异常处理方案，即直接抛出异常
     * 使用子类的类型转换方法
     *
     * @param fromList source 列表
     * @return
     */
    @Override
    public List<To> convert(List<From> fromList) {
        return convert(fromList, this::doConvert, exceptionProcessor);
    }

    /**
     * 列表转换
     * 使用默认的异常处理方案，即直接抛出异常
     *
     * @param fromList  source 列表
     * @param converter 转换方法
     * @return
     */
    @Override
    public List<To> convert(List<From> fromList, Converter<From, To> converter) {
        return convert(fromList, this::doConvert, exceptionProcessor);
    }

    /**
     * 列表转换
     *
     * @param fromList           source 列表
     * @param converter          转换方法
     * @param exceptionProcessor 异常处理器
     * @return
     */
    public List<To> convert(List<From> fromList,
                            Converter<From, To> converter,
                            ExceptionProcessor<ConvertExceptionInfo> exceptionProcessor) {
        if (fromList == null) {
            return Collections.emptyList();
        }
        return fromList.stream()
                .map(from -> convert(from, converter, ConvertOperate.LIST, exceptionProcessor))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
