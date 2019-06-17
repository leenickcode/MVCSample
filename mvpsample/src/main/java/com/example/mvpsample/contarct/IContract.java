package com.example.mvpsample.contarct;

/**
 * Created by Administrator on 2019/6/14 0014.
 *
 * @author Administrator
 */
public interface IContract {
    interface IPresenter{


        void attch(IView view);
        /**
         * 坐一些解绑操作，activity destory时p和View要相互取消引用
         */
        void destroy();
    }

    interface IView{

        /**
         * 取消引用
         */
        void clearPresenter();
    }
}
