package com.zh.learn.cloud.constant;

/**
 * @author Administrator
 * @Class Name ResponseCode
 * @Desc The restful response code
 * @create: 2021-06-18 09:40
 **/
public enum ResponseCode {
    /**
     * ok
     */
    OK(90200, "Successfully"),
    BAD_REQUEST(90400, "Successfully"),
    NOT_FOUND(90404, "Successfully"),
    INTERNAL_SERVER_ERROR(90500, "Successfully"),
    ;

    private int code;
    private String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String
    toString() {
        final StringBuilder sb = new StringBuilder("ResponseCode{");
        sb.append("code=").append(code);
        sb.append(", desc='").append(desc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
