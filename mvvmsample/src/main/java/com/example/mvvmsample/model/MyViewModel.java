package com.example.mvvmsample.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmsample.entity.BannerBean;
import com.example.mvvmsample.entity.ListBanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2019/6/19 0019.
 *
 * @author Administrator
 */
public class MyViewModel extends ViewModel {
        private MutableLiveData<ListBanner> data =new MutableLiveData<>();
        public LiveData<ListBanner> getBanner(){
            SampleModel sampleModel=new SampleModel();

            sampleModel.getBanner(new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        List<BannerBean> list=new ArrayList<>();
                        JSONObject jsonObject=new JSONObject(response.body().string());
                        ListBanner  banner =new ListBanner();
                        JSONArray jsonArray=jsonObject.getJSONArray("data");
                        for (int i = 0; i <jsonArray.length() ; i++) {
                            JSONObject jsonObject1=  jsonArray.getJSONObject(i);
                            BannerBean bannerBean=new BannerBean();
                            bannerBean.setTitle(jsonObject1.getString("title"));
                            list.add(bannerBean);
                        }
                        banner.setData(list);

                        data.postValue(banner);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });

        return data;
        }

}
