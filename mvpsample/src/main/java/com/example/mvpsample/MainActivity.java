package com.example.mvpsample;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mvpsample.contarct.IContract;
import com.example.mvpsample.contarct.SampleContract;
import com.example.mvpsample.entity.ListBanner;

public class MainActivity extends BaseActivity<SampleContract.SamplePresenter> implements SampleContract.SampleView {
    private static final String TAG = "MainActivity";
    TextView tv_title;

    @Override
    IContract.IPresenter initPresenter() {
        return new SampleContract.SamplePresenter();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        tv_title=findViewById(R.id.tv_title);
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mPresenter.getBanner(this);
    }



    @Override
    public void setDataToView(final ListBanner listBanner) {
        Log.d(TAG, "setDataToView: ");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_title.setText(listBanner.getData().get(0).getTitle());
            }
        });
    }


}
