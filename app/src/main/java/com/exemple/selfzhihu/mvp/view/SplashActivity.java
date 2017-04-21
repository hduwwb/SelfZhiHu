package com.exemple.selfzhihu.mvp.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.exemple.selfzhihu.R;
import com.exemple.selfzhihu.bean.LaunchImage;
import com.exemple.selfzhihu.mvp.presenter.SplashPresenter;

/**
 * Created by Jasper on 2017/4/20.
 */

public class SplashActivity extends AppCompatActivity implements ISplashView{

    private ImageView launchImage;
    private String imgUrl;
    private SplashPresenter splashPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        launchImage = (ImageView)findViewById(R.id.launch_image);
        splashPresenter = new SplashPresenter(this);
        splashPresenter.getLaunchImage();
    }

    @Override
    public void onRequestError() {

    }

    @Override
    public void getLaunchImage(LaunchImage image) {
        imgUrl = image.getCreatives().get(0).getUrl();
        Glide.with(this)
                .load(imgUrl)
                .into(launchImage);
        AnimatorSet animatorSet = new AnimatorSet();//组合动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(launchImage, "scaleX", 1f, 1.2f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(launchImage, "scaleY", 1f, 1.2f);

        animatorSet.setDuration(3000);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.play(scaleX).with(scaleY);//两个动画同时开始
        animatorSet.start();
    }

    @Override
    public void onRequestEnd() {

    }
}
