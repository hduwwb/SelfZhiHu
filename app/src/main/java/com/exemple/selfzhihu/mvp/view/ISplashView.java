package com.exemple.selfzhihu.mvp.view;

import com.exemple.selfzhihu.bean.LaunchImage;

/**
 * Created by OO on 2017/3/11.
 */

public interface ISplashView {
    void onRequestError();

    void getLaunchImage(LaunchImage launchImage);

    void onRequestEnd();
}
