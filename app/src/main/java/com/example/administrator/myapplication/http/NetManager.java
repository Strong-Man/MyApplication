package com.example.administrator.myapplication.http;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zpw on 2018/5/9.
 */

public class NetManager {
    public static final int DEFAULT_CONNECT_TIMEOUT_SECOND = 5;
    public static final int DEFAULT_READ_TIMEOUT_SECOND = 10;
    public static final int DEFAULT_WRITE_TIMEOUT_SECOND = 10;
//    private Context mContext;

    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;

    private NetManager() {
        initOkHttpClient();
        initRetrofitClient();
    }

    private void initOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT_SECOND, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIMEOUT_SECOND, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIMEOUT_SECOND, TimeUnit.SECONDS);
                //todo
                // sslSocketFactory(sslSocketFactory);
                //addInterceptor();

        mOkHttpClient = builder.build();
    }

    private void initRetrofitClient() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(NetConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkHttpClient)
                .build();

    }

    private static class NetManagerHolder {
        private static final NetManager INSTANCE = new NetManager();
    }

    public static NetManager getInstance() {
        return NetManagerHolder.INSTANCE;
    }


}
