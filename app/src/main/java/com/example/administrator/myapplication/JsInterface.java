package com.example.administrator.myapplication;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by coolzpw on 2018/5/8.
 */

public class JsInterface {
    private Context context;

    public JsInterface(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void showToast(String content) {

        Toast.makeText(context, "js调用Android中的方法:" + content, Toast.LENGTH_LONG).show();

    }

}
