package originfx.originecn.cn.mvplibrary.mvpbase;

/**
 * Created by Administrator on 2017/10/9.
 */

public interface IBasePresenter<V extends IBaseView> {
    /**
     * 附加页面视图
     *
     * @param mvpView 页面视图
     */
    void attachView(V mvpView);

    /**
     * 分离视图
     */
    void detachView();
}
