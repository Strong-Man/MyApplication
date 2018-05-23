package com.example.administrator.myapplication.http.observer;

import com.example.administrator.myapplication.http.entity.HttpResult;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zpw on 2018/5/23.
 */

public abstract class HttpRxObserver<T> implements Observer<HttpResult<T>> {

    @Override
    public void onSubscribe(Disposable d) {
        onStart(d);
    }

    @Override
    public void onNext(HttpResult<T> response) {
        if (response.getRetcode().equals("00")) {
            onSuccess(response.getData());
        }
    }

    @Override
    public void onError(Throwable e) {
        onError();
    }

    @Override
    public void onComplete() {

    }

    protected abstract void onStart(Disposable d);

    /**
     * 错误/异常回调
     *
     * @author ZhongDaFeng
     */
    protected abstract void onError();

    /**
     * 成功回调
     *
     * @author ZhongDaFeng
     */
    protected abstract void onSuccess(T response);
}
