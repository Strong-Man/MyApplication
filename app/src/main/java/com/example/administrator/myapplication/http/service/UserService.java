package com.example.administrator.myapplication.http.service;

import com.example.administrator.myapplication.http.entity.HttpResult;
import com.example.administrator.myapplication.http.entity.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zpw on 2018/5/23.
 */

public interface UserService {
    @FormUrlEncoded
    @POST("mallmobile/bsemployeeinfo/getUserExtraInfo")
    Observable<HttpResult<User>> getUser(@Field("eeid") Integer eeid);
}
