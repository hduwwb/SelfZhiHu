package com.exemple.selfzhihu.mvp.presenter;

import com.exemple.selfzhihu.api.ApiService;
import com.exemple.selfzhihu.api.ApiUtil;
import com.exemple.selfzhihu.bean.BeforeStories;
import com.exemple.selfzhihu.bean.LatestStories;
import com.exemple.selfzhihu.mvp.view.IMainView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jasper on 2017/4/22.
 */

public class MainPresenter {
    private Disposable disposable;
    private IMainView mainView;
    private ApiService service;

    public MainPresenter(IMainView mainView) {
        this.mainView = mainView;
        service = ApiUtil.getApiService();
    }
    public void loadLatestStories(){
        service.getLatestStories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LatestStories>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(LatestStories latestStories) {
                        mainView.LoadLatestStories(latestStories,disposable);

                    }

                    @Override
                    public void onError(Throwable e) {
                        mainView.onRequstError(disposable);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void loadBeforeStories(final String date){
        service.getBeforeStories(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeforeStories>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(BeforeStories beforeStories) {
                        mainView.loadBeforeStories(beforeStories,disposable);

                    }

                    @Override
                    public void onError(Throwable e) {
                        mainView.onRequstError(disposable);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
