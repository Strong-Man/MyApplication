package com.example.administrator.myapplication.http.entity;

/**
 * Created by zpw on 2018/5/23.
 */

public class HttpResult<T> {


    //用来模仿Data
    private T data;

    private String retcode;

    private String retmsg;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "data=" + data +
                ", retcode='" + retcode + '\'' +
                ", retmsg='" + retmsg + '\'' +
                '}';
    }
}
