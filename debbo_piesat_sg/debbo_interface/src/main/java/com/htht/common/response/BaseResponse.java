package com.htht.common.response;

import com.htht.common.enums.StatusCode;
import java.io.Serializable;

/**
 * @program: debbo_piesat_sg
 * @description: 基础类
 * @author: Zhao Lianlian
 * @create: 2021-04-25 11:49
 */
public class BaseResponse<T> implements Serializable {
    private int status = 200;
    private String message;
    private T data;

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static BaseResponse success(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(StatusCode.SECCESS.getCode());
        baseResponse.setMessage(StatusCode.SECCESS.getMessage());
        return baseResponse;
    }

    public static <T> BaseResponse success(T data){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(StatusCode.SECCESS.getCode());
        baseResponse.setMessage(StatusCode.SECCESS.getMessage());
        baseResponse.setData(data);
        return baseResponse;
    }

    public static BaseResponse result(StatusCode statusCode){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(statusCode.getCode());
        baseResponse.setMessage(statusCode.getMessage());
        return baseResponse;
    }

    public static BaseResponse result(int status, String message){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(status);
        baseResponse.setMessage(message);
        return baseResponse;
    }

    public boolean isSuccess(){
        return this.status == 200;
    }

    public static <T> BaseResponse result(int errorCode,String msg,T data){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(errorCode);
        baseResponse.setMessage(msg);
        baseResponse.setData(data);
        return baseResponse;
    }

    public static BaseResponse error(String msg){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(StatusCode.ERROR.getCode());
        baseResponse.setMessage(msg);
        return baseResponse;
    }
}