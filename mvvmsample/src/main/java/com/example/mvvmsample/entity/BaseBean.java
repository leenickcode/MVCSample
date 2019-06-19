package com.example.mvvmsample.entity;

/**
 * Created by Administrator on 2019/6/6 0006.
 *
 * @author Administrator
 */
public class BaseBean {
    private int errorCode;
    private String errorMsg;

    public void setErrorcode(int errorcode) {
        this.errorCode = errorcode;
    }
    public int getErrorcode() {
        return errorCode;
    }


    public void setErrormsg(String errormsg) {
        this.errorMsg = errormsg;
    }
    public String getErrormsg() {
        return errorMsg;
    }
}
