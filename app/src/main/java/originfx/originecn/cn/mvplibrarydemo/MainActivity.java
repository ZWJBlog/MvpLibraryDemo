package originfx.originecn.cn.mvplibrarydemo;

import android.os.Bundle;

import originfx.originecn.cn.mvplibrary.BaseActivity;

public class MainActivity extends BaseActivity<ToastIbseView, ToastIBasePresenter> implements ToastIbseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.ToastMSG();
    }

    @Override
    public ToastIBasePresenter initBasePresenter() {
        return new ToastIBasePresenter();
    }

    @Override
    public void goToast(String msg) {
        showToast(msg);
    }
}
