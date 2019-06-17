package com.example.mvpsample.contarct;

import android.util.Log;

import com.example.mvpsample.callback.Callback;
import com.example.mvpsample.entity.ListBanner;
import com.example.mvpsample.model.SampleModel;

/**
 * Created by Administrator on 2019/6/6 0006.
 *
 * @author Administrator
 */
public class SampleContract {
    private static final String TAG = "SampleContract";
    public static class SamplePresenter extends BasePrensenter {
        public void getBanner(final SampleView sampleView){
            SampleModel sampleModel=new SampleModel();
            sampleModel.getBanner(new Callback<ListBanner>() {
                @Override
                public void callback(ListBanner listBanner) {
                    Log.d(TAG, "callback: ");
                    sampleView.setDataToView(listBanner);
                }
            });
        }

    }


    public  interface SampleView extends IContract.IView{
            void setDataToView(ListBanner listBanner);
    }
}
