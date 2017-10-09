package originfx.originecn.cn.mvplibrary;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import originfx.originecn.cn.mvplibrary.mvpbase.Base;
import originfx.originecn.cn.mvplibrary.mvpbase.IBasePresenter;
import originfx.originecn.cn.mvplibrary.mvpbase.IBaseView;

/**
 * Created by Administrator on 2017/10/9.
 */

public abstract class BaseActivity<V extends IBaseView, T extends IBasePresenter> extends AppCompatActivity implements Base, IBaseView {
  public   T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = initBasePresenter();
        presenter.attachView((V) this);
    }

    public abstract T initBasePresenter();

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showDialog() {
    }

    @Override
    public void setting() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
