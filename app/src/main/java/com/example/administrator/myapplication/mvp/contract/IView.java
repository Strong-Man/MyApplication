package com.example.administrator.myapplication.mvp.contract;

import android.app.Activity;

/**
 * Created by Administrator on 2018/4/25.
 */

public interface IView {
    void showLoading();//展示加载框

    void dismissLoading();//取消加载框展示

    Activity getActivity();

}
