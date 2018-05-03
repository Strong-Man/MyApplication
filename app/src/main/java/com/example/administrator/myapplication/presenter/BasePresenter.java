package com.example.administrator.myapplication.presenter;

import com.example.administrator.myapplication.contract.BaseView;

/**
 * Created by Administrator on 2018/4/25.
 */

public interface BasePresenter {
    //    void start();
    void attachView(BaseView v);

    void detachView();

    BaseView getView();
}
