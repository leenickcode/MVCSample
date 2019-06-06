package com.example.mvpsample.model;


import com.example.mvpsample.callback.Callback;
import com.example.mvpsample.entity.BannerBean;
import com.example.mvpsample.entity.ListBanner;
import com.example.mvpsample.http.HttpUtils;

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
    public void getBanner(final Callback<ListBanner> callback){
            new HttpUtils().getBanner(new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        List<BannerBean> list=new ArrayList<>();
                        JSONObject jsonObject=new JSONObject(response.body().string());
                        ListBanner banner=new ListBanner();
                        JSONArray jsonArray=jsonObject.getJSONArray("data");
                        for (int i = 0; i <jsonArray.length() ; i++) {
                          JSONObject jsonObject1=  jsonArray.getJSONObject(i);
                          BannerBean bannerBean=new BannerBean();
                          bannerBean.setTitle(jsonObject1.getString("title"));
                            list.add(bannerBean);
                        }
                        banner.setData(list);
                        callback.callback(banner);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });

    }

}
