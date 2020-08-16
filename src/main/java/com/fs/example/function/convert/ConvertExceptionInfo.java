package com.fs.example.function.convert;

import com.fs.example.function.error.ExceptionInfo;

/**
 * 装换异常信息
 *
 * @author zhaofushan
 * @date 2020/8/16 0016 1:53
 */
public class ConvertExceptionInfo extends ExceptionInfo {
    private ConvertOperate convertOperate;

    public ConvertExceptionInfo(ConvertOperate convertOperate, RuntimeException exception) {
        super.setException(exception);
        this.convertOperate = convertOperate;
    }

    public ConvertOperate getConvertOperate() {
        return convertOperate;
    }

    public void setConvertOperate(ConvertOperate convertOperate) {
        this.convertOperate = convertOperate;
    }
}
