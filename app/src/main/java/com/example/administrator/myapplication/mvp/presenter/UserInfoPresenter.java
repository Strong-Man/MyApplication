package com.example.administrator.myapplication.mvp.presenter;

import android.util.Log;

import com.example.administrator.myapplication.http.entity.User;
import com.example.administrator.myapplication.http.observer.HttpRxObserver;
import com.example.administrator.myapplication.mvp.contract.UserInfoContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/4/25.
 */

public class UserInfoPresenter extends BasePresenter<UserInfoContract.Model, UserInfoContract.View> {
    private final String TAG = "UserInfoPresenter";

    public UserInfoPresenter(UserInfoContract.View view, UserInfoContract.Model model) {
        super(view, model);
    }

    public void requestUser(Integer eeid) {
        getModel().getUser(eeid).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new HttpRxObserver<User>() {
            @Override
            protected void onStart(Disposable d) {

            }

            @Override
            protected void onError() {

            }

            @Override
            protected void onSuccess(User response) {
                getView().showUserInfo(response);
            }
        });
    }

}
