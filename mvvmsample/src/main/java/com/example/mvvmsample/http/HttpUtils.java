package com.example.mvvmsample.http;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2019/6/6 0006.
 *
 * @author Administrator
 */
public class HttpUtils {
    private static final String TAG = "HttpUtils";
    public void getBanner(Callback callback){
            //这里应该是网络请求得到数据
        String url = "https://www.wanandroid.com/banner/json";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);

    }
}
