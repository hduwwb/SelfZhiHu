package com.exemple.selfzhihu.mvp.view;

import com.exemple.selfzhihu.bean.BeforeStories;
import com.exemple.selfzhihu.bean.LatestStories;

import io.reactivex.disposables.Disposable;

/**
 * Created by Jasper on 2017/4/21.
 */

public interface IMainView {
    void onRequstError(Disposable disposable);
    void LoadLatestStories(LatestStories latestStories,Disposable disposable);
    void loadBeforeStories(BeforeStories beforeStories, Disposable disposable);
}
