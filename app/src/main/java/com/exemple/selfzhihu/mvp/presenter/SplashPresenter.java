package com.exemple.selfzhihu.mvp.presenter;

import com.exemple.selfzhihu.api.ApiManger;
import com.exemple.selfzhihu.api.CommonApi;
import com.exemple.selfzhihu.bean.LaunchImage;
import com.exemple.selfzhihu.mvp.view.ISplashView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jasper on 2017/4/20.
 */

public class SplashPresenter {
    private ISplashView splashView;
    private CommonApi api;
    private Disposable disposable;

    public SplashPresenter(ISplashView splashView) {
        this.splashView = splashView;
        api = ApiManger.getCommonApi();
    }

    public void getLaunchImage(){

        api.getLaunchImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LaunchImage>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(LaunchImage launchImage) {
                        splashView.getLaunchImage(launchImage);
                    }

                    @Override
                    public void onError(Throwable e) {
                        splashView.onRequestError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
