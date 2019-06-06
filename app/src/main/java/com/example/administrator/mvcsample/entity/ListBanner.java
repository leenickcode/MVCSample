package com.example.administrator.mvcsample.entity;

import java.util.List;

/**
 * Created by Administrator on 2019/6/6 0006.
 *
 * @author Administrator
 */
public class ListBanner extends BaseBean {
    List<BannerBean> data;

    public List<BannerBean> getData() {
        return data;
    }

    public void setData(List<BannerBean> data) {
        this.data = data;
    }
}
