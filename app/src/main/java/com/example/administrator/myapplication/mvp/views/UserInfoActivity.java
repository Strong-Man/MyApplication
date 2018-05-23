package com.example.administrator.myapplication.mvp.views;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.http.entity.User;
import com.example.administrator.myapplication.mvp.contract.UserInfoContract;
import com.example.administrator.myapplication.mvp.model.UserModel;
import com.example.administrator.myapplication.mvp.presenter.IPresenter;
import com.example.administrator.myapplication.mvp.presenter.UserInfoPresenter;

/**
 * Created by Administrator on 2018/4/25.
 */

public class UserInfoActivity extends BaseActivity<UserInfoPresenter> implements UserInfoContract.View {
    private final String TAG = "UserInfoActivity";
    private TextView mUserNameTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mBasePresenter.requestUser(1);

    }

    @Override
    protected void initView() {
        super.initView();
        mUserNameTv = findViewById(R.id.tv_user_name);
        mUserNameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBasePresenter.requestUser(1);
            }
        });

    }

    @Override
    public UserInfoPresenter setPresenter() {
        return new UserInfoPresenter(this, new UserModel());
    }

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_user;
    }


    @Override
    public void showUserInfo(User user) {

        mUserNameTv.setText(user.getNickname());
    }

    @Override
    public String loadUserId() {
        return "test";
    }

    @Override
    public Activity getActivity() {
        return super.getActivity();
    }
}
