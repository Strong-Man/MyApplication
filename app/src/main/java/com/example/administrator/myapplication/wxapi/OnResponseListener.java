package com.example.administrator.myapplication.wxapi;

/**
 * Created by zpw on 2018/5/19.
 */

public interface OnResponseListener {
    //分享成功的回调
    void onSuccess();

    //分享取消的回调
    void onCancel();

    //分享失败的回调
    void onFail(String message);
}
