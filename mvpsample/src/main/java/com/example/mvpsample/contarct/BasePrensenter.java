package com.example.mvpsample.contarct;

/**
 * Created by Administrator on 2019/6/17 0017.
 *
 * @author Administrator
 */
public class BasePrensenter implements IContract.IPresenter {
    IContract.IView view;
    @Override
    public void attch(IContract.IView view) {
        this.view=view;
    }

    @Override
    public void destroy() {
        view = null;
    }
}
