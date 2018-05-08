package com.example.administrator.myapplication.views;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.administrator.myapplication.contract.UserInfoContract;
import com.example.administrator.myapplication.model.UserInfoModel;
import com.example.administrator.myapplication.presenter.BasePresenter;
import com.example.administrator.myapplication.presenter.UserInfoPresenter;

/**
 * Created by Administrator on 2018/4/25.
 */

public class UserInfoActivity extends BaseActivity implements UserInfoContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public BasePresenter setPresenter() {
        return new UserInfoPresenter(this);
    }

    @Override
    public int getContentLayoutID() {
        return 0;
    }

    @Override
    public void showUserInfo(UserInfoModel userInfoModel) {

    }

    @Override
    public String loadUserId() {
        return "test";
    }

}
