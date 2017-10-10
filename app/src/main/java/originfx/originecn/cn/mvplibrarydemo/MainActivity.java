package originfx.originecn.cn.mvplibrarydemo;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import originfx.originecn.cn.mvplibrary.BaseActivity;
import originfx.originecn.cn.navigationlayout.NavigationLayout;

public class MainActivity extends BaseActivity<ToastIbseView, ToastIBasePresenter> implements ToastIbseView {
    ImageView img1, img2, img3, img4, img5;
    public List<ImageView> list_img = new ArrayList<>();
    ValueAnimator mAnimator;
    public int viewId;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationLayout Navigation = (NavigationLayout) findViewById(R.id.NavigationLayout);
        ArrayList<Bitmap> bitmaps = new ArrayList<>();
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.img1);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.img2);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.mipmap.img3);
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.mipmap.img4);
        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.mipmap.img5);
        bitmaps.add(bitmap1);
        bitmaps.add(bitmap2);
        bitmaps.add(bitmap3);
        bitmaps.add(bitmap4);
        bitmaps.add(bitmap5);
        Navigation.setListImageView(bitmaps, this);


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
