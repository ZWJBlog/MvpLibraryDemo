package originfx.originecn.cn.mvplibrary;

import originfx.originecn.cn.mvplibrary.mvpbase.IBasePresenter;
import originfx.originecn.cn.mvplibrary.mvpbase.IBaseView;

/**
 * Created by Administrator on 2017/10/9.
 */

public class BaseIBasePresenter<V extends IBaseView> implements IBasePresenter<V> {
    V mvpView;

    @Override
    public void attachView(V mvpView) {
        if (mvpView != null) {
            this.mvpView = mvpView;
        }
    }

    @Override
    public void detachView() {
        if (mvpView != null) {
            mvpView = null;
        }
    }

    public V getView() {
        return mvpView;
    }
}
