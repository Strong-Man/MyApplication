package com.example.administrator.myapplication;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.myapplication.mvp.presenter.IPresenter;
import com.example.administrator.myapplication.mvp.views.BaseActivity;
import com.example.administrator.myapplication.wxapi.OnResponseListener;
import com.example.administrator.myapplication.wxapi.WXShare;

public class MainActivity extends BaseActivity {
    WebView mContentWv;
    Button mTestBtn;
    WXShare wxShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






        mTestBtn = findViewById(R.id.bt_test);
        mTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wxShare.share("这是要分享的文字");
            }
        });



        mContentWv = findViewById(R.id.wv_content);
        WebSettings webSettings = mContentWv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        JsInterface jsInterface = new JsInterface(MainActivity.this);
        mContentWv.loadUrl("file:///android_asset/test.html");
        mContentWv.addJavascriptInterface(jsInterface, "jsInterface");



        wxShare = new WXShare(this);
        wxShare.setListener(new OnResponseListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this,"wo huidiaochenggongle(Main)",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onFail(String message) {

            }
        });

    }

    @Override
    protected void onStart() {
        wxShare.register();
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        wxShare.unregister();
        super.onDestroy();
    }

    @Override
    public IPresenter setPresenter() {
        return null;
    }

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_main;
    }
}
