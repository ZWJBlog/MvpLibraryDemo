package originfx.originecn.cn.navigationlayout;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */

public class NavigationLayout extends LinearLayout implements View.OnClickListener {
    Context context;
    ValueAnimator mAnimator;
    public List<ImageView> list_img = new ArrayList<>();
    public int viewId;

    public NavigationLayout(Context context) {
        super(context);
    }

    public NavigationLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(HORIZONTAL);
        setGravity(Gravity.BOTTOM);
        setClipChildren(false);
    }

    public NavigationLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * wwwwwww
     *
     * @param list_bitmap 图片集合
     * @param context
     */
    public void setListImageView(List<Bitmap> list_bitmap, Context context) {
        this.context = context;
        for (int i = 0; i < list_bitmap.size(); i++) {
            ImageView imageView = new ImageView(context);
            imageView.setId(i);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageBitmap(list_bitmap.get(i));
            imageView.setOnClickListener(this);
            addView(imageView);
            list_img.add(imageView);
            if (i == (list_bitmap.size() - 1) / 2) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.height = dip2px(context, 100);
                imageView.setLayoutParams(layoutParams);
            }
        }
        postInvalidate();
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
                layoutParams.height = dip2px(context, 48);
                list_img.get(i).setLayoutParams(layoutParams);
            }
        }
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
                layoutParams.height = dip2px(context, animatorValue);
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

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
