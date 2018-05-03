package com.example.administrator.myapplication.presenter;

import com.example.administrator.myapplication.contract.BaseView;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2018/4/25.
 */

public class BasePresenterImp implements BasePresenter {
    private WeakReference<BaseView> mView;

    @Override
    public void attachView(BaseView v) {
        mView = new WeakReference(v);
    }

    @Override
    public void detachView() {
        if (null != mView) {
            mView.clear();
            mView = null;
        }
    }

    @Override
    public BaseView getView() {
        return isViewAttached() ? mView.get() : null;
    }

    private boolean isViewAttached() {
        return null != mView && null != mView.get();
    }
}
