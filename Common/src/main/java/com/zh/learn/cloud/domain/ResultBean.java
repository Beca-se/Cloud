package com.zh.learn.cloud.domain;

import com.zh.learn.cloud.constant.ResponseCode;

/**
 * @author zhouhu
 * @Class Name ResultBean
 * @Desc TODO
 * @create: 2019-09-05 14:26
 **/
public class ResultBean {
    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static ResultBean isOK(String message) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(ResponseCode.OK.getCode());
        resultBean.setMessage(message);
        resultBean.setData(null);
        return resultBean;
    }

    public static ResultBean isOK(String message, Object object) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(ResponseCode.OK.getCode());
        resultBean.setMessage(message);
        resultBean.setData(object);
        return resultBean;
    }

    public static ResultBean isBad(String message) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(ResponseCode.BAD_REQUEST.getCode());
        resultBean.setMessage(message);
        return resultBean;
    }

    public static ResultBean isBad(String message, String field) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(ResponseCode.BAD_REQUEST.getCode());
        resultBean.setMessage(message);
        resultBean.setData(field);
        return resultBean;
    }

    public static ResultBean isError(String message) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(ResponseCode.INTERNAL_SERVER_ERROR.getCode());
        resultBean.setMessage(message);
        resultBean.setData(null);
        return resultBean;
    }

    public static ResultBean isError() {
        return isError("SYSTEM ERROR");
    }

}
