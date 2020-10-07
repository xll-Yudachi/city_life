package com.yudachi.citylife.res;

/**
 * @Author Yudachi
 * @Description
 * @Date 2019/11/10 17:39
 * @Version 1.0
 **/
public interface ResultCode {
    //操作是否成功
    boolean success();

    //操作代码
    int code();

    //提示信息
    String message();
}