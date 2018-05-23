package com.example.administrator.myapplication.mvp.presenter;

import com.example.administrator.myapplication.mvp.contract.IView;

/**
 * Created by Administrator on 2018/4/25.
 */

public interface IPresenter {
    //    void start();
//    void attachView(IView v);
//
//    void detachView();
//
//    IView getView();
    void onDestroy();
    void onStart();
}
