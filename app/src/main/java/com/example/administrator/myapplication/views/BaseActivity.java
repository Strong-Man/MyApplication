package com.example.administrator.myapplication.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.LinearLayout;


import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.contract.BaseView;
import com.example.administrator.myapplication.presenter.BasePresenter;

/**
 * Created by Administrator on 2018/4/25.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    protected BasePresenter mBasePresenter;
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

    private void initView() {
        mRootLayout = findViewById(R.id.ll_root);
        mTitleToolBar = findViewById(R.id.toolbar);
        mTitleToolBar.setNavigationIcon(R.drawable.navigation_back_button_selector);
        mTitleToolBar.setTitle("");
        setSupportActionBar(mTitleToolBar);
        innerSetContentView(getContentLayoutID());
    }

    private void innerSetContentView(int layoutID){
        mLayoutInflater.inflate(layoutID,mRootLayout,true);
//        mRootLayout.addView(layoutID);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    abstract public BasePresenter setPresenter();

    abstract public int getContentLayoutID();

    public BasePresenter getPresenter() {
        return mBasePresenter;
    }

    public void removePresenter() {
        mBasePresenter = null;
    }

    @Override
    protected void onDestroy() {
//        m
        if (null != mBasePresenter) {
            mBasePresenter.detachView();
            removePresenter();
        }
        super.onDestroy();
    }

}
