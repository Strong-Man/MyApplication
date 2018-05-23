package com.example.administrator.myapplication.mvp.views;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.LinearLayout;


import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.mvp.contract.IView;
import com.example.administrator.myapplication.mvp.presenter.IPresenter;

/**
 * Created by Administrator on 2018/4/25.
 */

public abstract class BaseActivity<T extends IPresenter> extends AppCompatActivity implements IView {
    protected T mBasePresenter;
    protected LinearLayout mRootLayout;
    protected Toolbar mTitleToolBar;
    protected LayoutInflater mLayoutInflater;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mLayoutInflater = LayoutInflater.from(this);
        initView();

        mBasePresenter = setPresenter();
    }

    protected void initView() {
        mRootLayout = findViewById(R.id.ll_root);
        mTitleToolBar = findViewById(R.id.toolbar);
        mTitleToolBar.setNavigationIcon(R.drawable.navigation_back_button_selector);
        mTitleToolBar.setTitle("");
        setSupportActionBar(mTitleToolBar);
        setInnerContentView(getContentLayoutID());
    }

    private void setInnerContentView(int layoutID){
        mLayoutInflater.inflate(layoutID,mRootLayout,true);
//        mRootLayout.addView(layoutID);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public Activity getActivity() {
        return this;
    }

    abstract public T setPresenter();

    abstract public int getContentLayoutID();

    public IPresenter getPresenter() {
        return mBasePresenter;
    }

    public void removePresenter() {
        mBasePresenter = null;
    }

    @Override
    protected void onDestroy() {
//        m
        if (null != mBasePresenter) {
            mBasePresenter.onDestroy();
            removePresenter();
        }
        super.onDestroy();
    }

}
