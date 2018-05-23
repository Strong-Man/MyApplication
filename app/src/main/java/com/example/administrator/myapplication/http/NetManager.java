package com.example.administrator.myapplication.http;

import android.content.Context;

import com.example.administrator.myapplication.R;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

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
//                 .sslSocketFactory(getSSLSocketFactory_Certificate(contextWeakReference.get(), "BKS", R.raw.ca););
        //todo log打印
        //addInterceptor();

        mOkHttpClient = builder.build();
    }

    private void initRetrofitClient() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://120.119.110.77:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkHttpClient)
                .build();

    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    private static class NetManagerHolder {
        private static final NetManager INSTANCE = new NetManager();
    }

    public static NetManager getInstance() {
        return NetManagerHolder.INSTANCE;
    }

    private static SSLSocketFactory getSSLSocketFactory_Certificate(Context context, String keyStoreType, int keystoreResId)

            throws CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException, KeyManagementException

    {

        CertificateFactory cf = CertificateFactory.getInstance("X.509");


        InputStream caInput = context.getResources().openRawResource(keystoreResId);

        Certificate ca = cf.generateCertificate(caInput);

        caInput.close();

        if (keyStoreType == null || keyStoreType.length() == 0) {

            keyStoreType = KeyStore.getDefaultType();

        }

        KeyStore keyStore = KeyStore.getInstance(keyStoreType);

        keyStore.load(null, null);

        keyStore.setCertificateEntry("ca", ca);

        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);

        tmf.init(keyStore);

        TrustManager[] wrappedTrustManagers = getWrappedTrustManagers(tmf.getTrustManagers());

        SSLContext sslContext = SSLContext.getInstance("TLS");

        sslContext.init(null, wrappedTrustManagers, null);

        return sslContext.getSocketFactory();

    }

    private static TrustManager[] getWrappedTrustManagers(TrustManager[] trustManagers) {

        final X509TrustManager originalTrustManager = (X509TrustManager) trustManagers[0];

        return new TrustManager[]{

                new X509TrustManager() {

                    public X509Certificate[] getAcceptedIssuers() {

                        return originalTrustManager.getAcceptedIssuers();

                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {

                        try {

                            originalTrustManager.checkClientTrusted(certs, authType);

                        } catch (CertificateException e) {

                            e.printStackTrace();

                        }

                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {

//                        try {
//
//                            originalTrustManager.checkServerTrusted(certs, authType);
//
//                        } catch (CertificateException e) {
//
//                            e.printStackTrace();
//
//                        }

                    }

                }

        };

    }
}
