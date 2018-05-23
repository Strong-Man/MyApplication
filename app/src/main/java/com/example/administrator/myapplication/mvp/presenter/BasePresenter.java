package com.example.administrator.myapplication.mvp.presenter;

import com.example.administrator.myapplication.mvp.contract.IView;
import com.example.administrator.myapplication.mvp.model.IModel;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2018/4/25.
 */

public class BasePresenter<M extends IModel, V extends IView> implements IPresenter {
    private WeakReference<V> mView;
    private M mModel;

    public BasePresenter(V view, M model) {
        mView = new WeakReference<V>(view);
        mModel = model;
    }

    public void detachView() {
        if (null != mView) {
            mView.clear();
            mView = null;
        }
    }

    public void detachModel() {
        if (null != mModel) {
            mModel.onDestroy();
            mModel = null;
        }
    }


    public V getView() {
        return isViewAttached() ? mView.get() : null;
    }

    public M getModel() {
        return mModel;
    }

    private boolean isViewAttached() {
        return null != mView && null != mView.get();
    }

    @Override
    public void onDestroy() {
        detachModel();
        detachView();
    }

    @Override
    public void onStart() {

    }
}
