package originfx.originecn.cn.mvplibrarydemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import originfx.originecn.cn.mvplibrary.BaseActivity;

public class MainActivity extends BaseActivity<ToastIbseView, ToastIBasePresenter> implements ToastIbseView, View.OnClickListener {
    ImageView img1, img2, img3, img4, img5;
    public List<ImageView> list_img = new ArrayList<>();
    ValueAnimator mAnimator;
    public int viewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        list_img.add(img1);
        list_img.add(img2);
        list_img.add(img3);
        list_img.add(img4);
        list_img.add(img5);


        presenter.ToastMSG();
    }

    private void setImageSize(final ImageView image) {
        mAnimator = ValueAnimator.ofInt(50, 100);
        //2.为目标对象的属性变化设置监听器
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 3.为目标对象的属性设置计算好的属性值
                int animatorValue = (int) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = image.getLayoutParams();
                layoutParams.height = dip2px(MainActivity.this, animatorValue);
                image.setLayoutParams(layoutParams);
            }
        });
        //4.设置动画的持续时间、是否重复及重复次数等属性
        mAnimator.setDuration(200);
        mAnimator.setRepeatCount(0);
        mAnimator.setRepeatMode(ValueAnimator.REVERSE);
        //5.为ValueAnimator设置目标对象并开始执行动画
        mAnimator.setTarget(image);
        mAnimator.start();


    }

    @Override
    public ToastIBasePresenter initBasePresenter() {
        return new ToastIBasePresenter();
    }

    @Override
    public void goToast(String msg) {
        showToast(msg);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < list_img.size(); i++) {

            if (view.getId() == list_img.get(i).getId()) {
                if (viewId != view.getId())
                    setImageSize(list_img.get(i));
                viewId = view.getId();
            } else {
                ViewGroup.LayoutParams layoutParams = list_img.get(i).getLayoutParams();
                layoutParams.height = dip2px(MainActivity.this, 48);
                list_img.get(i).setLayoutParams(layoutParams);
            }
        }

    }
}
