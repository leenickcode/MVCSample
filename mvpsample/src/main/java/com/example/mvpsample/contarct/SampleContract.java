package com.example.mvpsample.contarct;

import com.example.mvpsample.callback.Callback;
import com.example.mvpsample.entity.ListBanner;
import com.example.mvpsample.model.SampleModel;
import com.example.mvpsample.presenter.BasePresenter;
import com.example.mvpsample.view.BaseView;

/**
 * Created by Administrator on 2019/6/6 0006.
 *
 * @author Administrator
 */
public class SampleContract {
    public static class SamplePresenter implements BasePresenter{
        public void getBanner(Callback<ListBanner> callback){
            SampleModel sampleModel=new SampleModel();
            sampleModel.getBanner(callback);
        }
    }


    public   interface SampleView extends BaseView{
            void setDataToView(ListBanner listBanner);
    }
}
