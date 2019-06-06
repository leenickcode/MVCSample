package com.example.mvpsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mvpsample.callback.Callback;
import com.example.mvpsample.contarct.SampleContract;
import com.example.mvpsample.entity.ListBanner;
import com.example.mvpsample.presenter.BasePresenter;

public class MainActivity extends AppCompatActivity implements SampleContract.SampleView {
    private SampleContract.SamplePresenter samplePresenter;
    private static final String TAG = "MainActivity";
    TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_title=findViewById(R.id.tv_title);
        setPresenter(new SampleContract.SamplePresenter());
        samplePresenter.getBanner(new Callback<ListBanner>() {
            @Override
            public void callback(ListBanner listBanner) {
                Log.d(TAG, "callback: "+listBanner.getData().get(0).getTitle());
                setDataToView(listBanner);
            }
        });
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        samplePresenter= (SampleContract.SamplePresenter) presenter;
    }

    @Override
    public void setDataToView(final ListBanner listBanner) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_title.setText(listBanner.getData().get(0).getTitle());
            }
        });
    }
}
