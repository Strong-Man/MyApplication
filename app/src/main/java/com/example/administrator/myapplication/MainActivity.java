package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.administrator.myapplication.presenter.BasePresenter;
import com.example.administrator.myapplication.views.BaseActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity {
    WebView mContentWv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContentWv = findViewById(R.id.wv_content);
        WebSettings webSettings = mContentWv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        JsInterface jsInterface = new JsInterface(MainActivity.this);
        mContentWv.loadUrl("file:///android_asset/test.html");
        mContentWv.addJavascriptInterface(jsInterface,"jsInterface");
//        testView = findViewById(R.id.test);

//        Observable.intervalRange(0, 11, 0, 1, TimeUnit.SECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Long>() {
//                    private Disposable mDisposable;
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        mDisposable = d;
//                    }
//
//                    @Override
//                    public void onNext(Long value) {
////                         if(value == 60){
////                             mDisposable.dispose();
////                             return;
////                         }
//                        Log.d(TAG, "onNext");
//                        testView.setText(String.valueOf(10 - value));
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        testView.setText("倒计时完毕");
//                    }
//                });
    }

    @Override
    public BasePresenter setPresenter() {
        return null;
    }

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_main;
    }
}
