package com.example.administrator.myapplication.presenter;

import android.os.Handler;

import com.example.administrator.myapplication.contract.BaseView;
import com.example.administrator.myapplication.contract.UserInfoContract;
import com.example.administrator.myapplication.model.UserInfoModel;

/**
 * Created by Administrator on 2018/4/25.
 */

public class UserInfoPresenter extends UserInfoContract.Presenter {

    public UserInfoPresenter(UserInfoContract.View view) {
            attachView(view);
    }


    @Override
    public void loadUserInfo() {

    }
}
