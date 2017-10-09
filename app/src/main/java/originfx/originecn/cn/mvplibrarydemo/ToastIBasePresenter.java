package originfx.originecn.cn.mvplibrarydemo;

import originfx.originecn.cn.mvplibrary.BaseIBasePresenter;

/**
 * Created by Administrator on 2017/10/9.
 */

public class ToastIBasePresenter extends BaseIBasePresenter<ToastIbseView> {
    public void ToastMSG() {
        getView().goToast("发送一个消息");
    }
}
