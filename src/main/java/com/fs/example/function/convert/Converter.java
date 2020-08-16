package com.fs.example.function.convert;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 转换接口
 *
 * @author zhaofushan
 * @date 2020/8/15 0015 23:59
 */
@FunctionalInterface
public interface Converter<From, To> {

    /**
     * 列表转换
     *
     * @param fromList
     * @return
     */
    default List<To> convert(List<From> fromList) {
        return convert(fromList, this);
    }

    /**
     * 列表转换
     *
     * @param fromList
     * @param converter
     * @return
     */
    default List<To> convert(List<From> fromList, Converter<From, To> converter) {
        if (fromList == null) {
            return Collections.emptyList();
        }
        return fromList.stream()
                .map(converter::convert)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * 转换接口
     *
     * @param from source
     * @return target
     */
    To convert(From from);

}
