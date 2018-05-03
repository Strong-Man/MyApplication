package com.example.administrator.myapplication.contract;

import com.example.administrator.myapplication.model.UserInfoModel;
import com.example.administrator.myapplication.presenter.BasePresenter;
import com.example.administrator.myapplication.presenter.BasePresenterImp;

/**
 * Created by Administrator on 2018/4/25.
 */

public interface UserInfoContract {
    interface View extends BaseView {


        void showUserInfo(UserInfoModel userInfoModel);//将网络请求得到的用户信息回调

        String loadUserId();//假设接口请求需要一个userId
    }

    abstract class Presenter extends BasePresenterImp {
        public abstract void loadUserInfo();
    }


}
