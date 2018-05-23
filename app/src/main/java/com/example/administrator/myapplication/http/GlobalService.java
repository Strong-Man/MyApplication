package com.example.administrator.myapplication.http;

import com.example.administrator.myapplication.http.service.UserService;

/**
 * Created by zpw on 2018/5/23.
 */

public class GlobalService {
    private static UserService mUserService;


    public static UserService getUserService() {
        if (mUserService == null) {
            synchronized (GlobalService.class) {
                if (mUserService == null) {
                    mUserService = NetManager.getInstance().getRetrofit().create(UserService.class);
                }
            }
        }
        return mUserService;
    }

}
