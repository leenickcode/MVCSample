package com.example.mvpsample;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpsample.contarct.IContract;

/**
 * Created by Administrator on 2019/6/14 0014.
 *
 * @author Administrator
 */
public abstract class BaseActivity<P extends IContract.IPresenter> extends AppCompatActivity implements IContract.IView {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        mPresenter = (P) initPresenter();
        if (mPresenter!=null){
            mPresenter.attch(this);
        }
        initView(savedInstanceState);
        initVariable();
        setListener();
        processLogic(savedInstanceState);
    }


    @Override
    public void clearPresenter() {
        mPresenter = null;
    }

    abstract IContract.IPresenter initPresenter();

    @Override
    protected void onDestroy() {
        //取消所有该标记的请求
//        CallServer.getRequestInstance().cancelBySign(this);
        if (mPresenter != null)
            mPresenter.destroy();
        clearPresenter();
        super.onDestroy();
    }

    public abstract int getContentViewId();

    /**
     * 初始化布局以及View控件
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化变量
     */
    protected abstract void initVariable();

    /**
     * 给View控件添加事件监听器
     */
    protected abstract void setListener();

    /**
     * 处理业务逻辑，状态恢复等操作
     */
    protected abstract void processLogic(Bundle savedInstanceState);

}
