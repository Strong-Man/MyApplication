package com.example.administrator.myapplication.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.contract.BaseView;
import com.example.administrator.myapplication.presenter.BasePresenter;

/**
 * Created by Administrator on 2018/4/25.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    private BasePresenter mBasePresenter;
    private LinearLayout mDectorLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mBasePresenter = setPresenter();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    abstract public BasePresenter setPresenter();

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
