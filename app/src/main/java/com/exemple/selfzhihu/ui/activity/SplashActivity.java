package com.exemple.selfzhihu.ui.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.exemple.selfzhihu.App;
import com.exemple.selfzhihu.R;
import com.exemple.selfzhihu.bean.LaunchImage;
import com.exemple.selfzhihu.mvp.presenter.SplashPresenter;
import com.exemple.selfzhihu.mvp.view.ISplashView;
import com.exemple.selfzhihu.utils.SharedPreferencesUtils;

import io.reactivex.disposables.Disposable;

/**
 * Created by Jasper on 2017/4/20.
 */

public class SplashActivity extends BaseActivity implements ISplashView {

    private ImageView launchImage;
    private String imgUrl;
    private SplashPresenter splashPresenter;
    private Disposable disposable;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 666){
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }
    };

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
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }

    @Override
    public void onRequestError(Disposable disposable) {
        this.disposable = disposable;
        imgUrl = (String) SharedPreferencesUtils.get(App.getContext(), "launch_image", "");
        if (!TextUtils.isEmpty(imgUrl)) {
            Glide.with(this)
                    .load(imgUrl)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(launchImage);
        }
        AnimatorSet animatorSet = new AnimatorSet();//组合动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(launchImage, "scaleX", 1f, 1.2f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(launchImage, "scaleY", 1f, 1.2f);

        animatorSet.setDuration(3000);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.play(scaleX).with(scaleY);//两个动画同时开始
        animatorSet.start();
    }

    @Override
    public void getLaunchImage(LaunchImage image, Disposable disposable) {
        this.disposable = disposable;
        imgUrl = image.getCreatives().get(0).getUrl();
        Glide.with(this)
                .load(imgUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(launchImage);
        SharedPreferencesUtils.put(App.getContext(),"launch_image",imgUrl);
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
        Message message = new Message();
        message.what = 666;
        handler.sendMessageDelayed(message,0);
    }
}
