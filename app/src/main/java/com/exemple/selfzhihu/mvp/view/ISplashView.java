package com.exemple.selfzhihu.mvp.view;

import com.exemple.selfzhihu.bean.LaunchImage;

import io.reactivex.disposables.Disposable;

/**
 * Created by OO on 2017/3/11.
 */

public interface ISplashView {
    void onRequestError(Disposable disposable);

    void getLaunchImage(LaunchImage launchImage, Disposable disposable);

    void onRequestEnd();
}
