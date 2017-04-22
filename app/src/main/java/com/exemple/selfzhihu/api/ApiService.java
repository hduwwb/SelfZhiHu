package com.exemple.selfzhihu.api;

import com.exemple.selfzhihu.bean.BeforeStories;
import com.exemple.selfzhihu.bean.LatestStories;
import com.exemple.selfzhihu.bean.LaunchImage;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Jasper on 2017/4/20.
 */

public interface ApiService {
    @GET("/api/7/prefetch-launch-images/1080*1920")
    Observable<LaunchImage> getLaunchImage();
    @GET("/api/4/news/latest")
    Observable<LatestStories> getLatestStories();
    @GET("/api/4/news/before/{date}")
    Observable<BeforeStories> getBeforeStories(@Path("date") String date);
}
