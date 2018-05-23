package com.example.administrator.myapplication.mvp.contract;

import com.example.administrator.myapplication.http.entity.HttpResult;
import com.example.administrator.myapplication.http.entity.User;
import com.example.administrator.myapplication.mvp.model.IModel;
import com.example.administrator.myapplication.mvp.model.UserModel;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/4/25.
 */

public interface UserInfoContract {
    interface View extends IView {
        void showUserInfo(User user);//将网络请求得到的用户信息回调

        String loadUserId();//假设接口请求需要一个userId
    }

    interface Model extends IModel {
        Observable<HttpResult<User>> getUser(Integer eeid);
    }
}
