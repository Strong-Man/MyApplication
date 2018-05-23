package com.example.administrator.myapplication.mvp.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.administrator.myapplication.http.GlobalService;
import com.example.administrator.myapplication.http.entity.HttpResult;
import com.example.administrator.myapplication.http.entity.User;
import com.example.administrator.myapplication.mvp.contract.UserInfoContract;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/4/25.
 */

public class UserModel extends BaseModel implements UserInfoContract.Model {
    private final String TAG = "UserModel";

    public UserModel() {
    }

    @Override
    public Observable<HttpResult<User>> getUser(Integer eeid) {
        Log.d(TAG, "getUser");
        Observable<HttpResult<User>> observable = GlobalService.getUserService().getUser(eeid);
        return observable;

//        return Observable.just(GlobalService.getUserService().getUser(eeid)).map(new Function<Observable<User>).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());

    }
}
