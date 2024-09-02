package com.cbank.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zhelang
 * @date 2024/9/2 11:55
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    public static final String SUCCESS = "0";
    public static final String ERROR = "-1";

    // 存放成功与否的表示
    private String code;
    // 错误信息
    private String msg;
    // 数据
    private Object data;


    /**
     * 成功
     * @return 成功结果
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 错误
     * @param msg 错误信息
     * @return 错误信息
     */
    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(ERROR);
        result.setMsg(msg);
        result.setData(msg);
        return result;
    }

    /**
     * 错误，无参
     * @return 错误信息
     */
    public static Result error() {
        Result result = new Result();
        result.setCode(ERROR);
        return result;
    }

}
