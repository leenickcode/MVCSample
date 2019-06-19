package com.example.mvvmsample.model;




import com.example.mvvmsample.callback.Callback;
import com.example.mvvmsample.databinding.ActivityMainBinding;
import com.example.mvvmsample.entity.BannerBean;
import com.example.mvvmsample.entity.ListBanner;
import com.example.mvvmsample.http.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;


/**
 * Created by Administrator on 2019/6/6 0006.
 *
 * @author Administrator
 */
public class SampleModel {

    public void getBanner(okhttp3.Callback callback){
            new HttpUtils().getBanner(callback);
    }

}
