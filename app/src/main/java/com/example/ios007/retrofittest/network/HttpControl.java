package com.example.ios007.retrofittest.network;

import android.content.Context;
import android.util.Log;

import com.example.ios007.retrofittest.app.ParamsUtils;
import com.example.ios007.retrofittest.app.config.APPConfig;
import com.example.ios007.retrofittest.app.config.AppApplication;
import com.example.ios007.retrofittest.model.entry.User;
import com.example.ios007.retrofittest.network.cookieJar.ClearableCookieJar;
import com.example.ios007.retrofittest.network.cookieJar.PersistentCookieJar;
import com.example.ios007.retrofittest.network.cookieJar.cache.SetCookieCache;
import com.example.ios007.retrofittest.network.cookieJar.persistence.SharedPrefsCookiePersistor;
import com.example.ios007.retrofittest.util.Utils;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ios007 on 2017/7/4.
 */

public class HttpControl {
    private static HttpControl instance;
    private ApiService mService;
    private ClearableCookieJar cookieJar;
    private long over_time=2000;

    public HttpControl() {
    }

    public static HttpControl getInstance(Context context){
        if(instance==null){
            synchronized (HttpControl.class){
                if(instance==null){
                    instance=new HttpControl();
                }
            }
        }
        return instance;
    }

    public ApiService getDefaltService(){
        if(mService==null){
            OkHttpClient okHttpClient=trustAllHosts(Utils.mApplicationContent);
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(APPConfig.API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
            mService=createService(ApiService.class,retrofit);
        }
        return mService;
    }
    public  <T> T createService(Class<T> clz,Retrofit retrofit){
        return retrofit.create(clz);
    }
    private OkHttpClient trustAllHosts(final Context context) {
        cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if(Utils.DEBUG){
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }else{
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        final String TAG = "trustAllHosts";
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[]{};
            }

            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                Log.i(TAG, "checkClientTrusted");
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                Log.i(TAG, "checkServerTrusted");
            }
        }};

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(over_time, TimeUnit.MILLISECONDS)
                    .connectTimeout(over_time, TimeUnit.MILLISECONDS)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            String token="";
                            String userId="";
                            User user = AppApplication.getInstance().getUser();
                            if(user!=null){
                                token = user.getToken();
                                userId = user.getUserId();
                            }
                            Request request = chain.request().newBuilder()
                                    .addHeader(ParamsUtils.user_id, userId)
                                    .addHeader(ParamsUtils.token, token)
                                    .addHeader(ParamsUtils.device_id, Utils.getDeviceId())
                                    .addHeader(ParamsUtils.vendor, Utils.getChannel())
                                    .addHeader("User-Agent", "android_"+ Utils.getAppVersionName())
                                    .build();
                            return  chain.proceed(request);
                        }
                    })
                    .addInterceptor(logging)
                    .cookieJar(cookieJar).sslSocketFactory(sc.getSocketFactory(), (X509TrustManager) trustAllCerts[0])
                    .hostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            return true;

                        }
                    }).build();
            return okHttpClient;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
