package com.example.administrator.myapplication.http;

import com.example.administrator.myapplication.BuildConfig;

/**
 * Created by zpw on 2018/5/9.
 */

public class NetConstant {
    public static String BASE_URL;

    static {
        if (BuildConfig.DEBUG) {
            BASE_URL = BuildConfig.HTTP_DEBUG_BASE_URL;

        } else {

            BASE_URL = BuildConfig.HTTP_RELEAS_BASE_URL;
        }
    }
}
