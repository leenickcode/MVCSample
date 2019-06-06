package com.example.administrator.mvcsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.administrator.mvcsample.callback.Callback;
import com.example.administrator.mvcsample.entity.BannerBean;
import com.example.administrator.mvcsample.entity.ListBanner;
import com.example.administrator.mvcsample.model.SampleModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView tv_name;
    SampleModel sampleModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_name=findViewById(R.id.tv_name);
        sampleModel=new SampleModel();
        sampleModel.getBanner( new Callback<ListBanner>() {
            @Override
            public void callback(ListBanner listBanner) {
                Log.d(TAG, Thread.currentThread().getName()+"--setDataToView: "+listBanner.getData().get(0).getTitle());
                setDataToView(listBanner.getData().get(0));

            }
        });
    }
    private void setDataToView(final BannerBean banner){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_name.setText(banner.getTitle());

            }
        });
    }

}
