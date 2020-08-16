package com.fs.example.function.convert;

import com.fs.example.function.start.FromType;
import com.fs.example.function.start.ToType;

/**
 * 实例 converter
 *
 * @author zhaofushan
 * @date 2020/8/16 0016 0:06
 */
public class SomeConverter extends BaseConverter<FromType, ToType> {
    public SomeConverter() {
        //可以在子类指定异常处理器
//        setExceptionProcessor(null);
    }

    @Override
    protected ToType doConvert(FromType fromType) {
        return null;
    }


    /**
     * 自定义转换器
     *
     * @param o
     * @return
     */
    public ToType convertForList(FromType o) {
        return null;
    }

}
