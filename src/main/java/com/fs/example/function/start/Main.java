package com.fs.example.function.start;

import com.fs.example.function.convert.ConverterBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaofushan
 * @date 2020/8/16 0016 0:11
 */
public class Main {
    public static void main(String[] args) {

        ConverterBuilder<SomeConverter, FromType, ToType> builder = new ConverterBuilder<>(SomeConverter::new);

        //构建时可以指定异常处理器,会覆盖子类的定义
//        builder.setExceptionProcessor(null);
        SomeConverter someConverter = builder.build();


        FromType singleSource = new FromType();
        ArrayList<FromType> listSource = new ArrayList<>();
        listSource.add(new FromType());

        //单实例
        someConverter.convert(singleSource);


        //多实例 默认实现 使用默认的转换器
        someConverter.convert(listSource);
        //多实例 匿名 lambda 传入指定的converter
        someConverter.convert(listSource, fromType -> {
            return new ToType();
        });
        //多实例 使用指定的converter方法
        List<ToType> convert = someConverter.convert(listSource, someConverter::convertForList);
        //多实例 使用默认的convert方法，指定异常处理器
        someConverter.convert(listSource, someConverter, exception -> {
            //do nothing;
        });


    }
}
