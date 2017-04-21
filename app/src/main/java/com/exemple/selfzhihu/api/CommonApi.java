package com.exemple.selfzhihu.api;

import com.exemple.selfzhihu.bean.LaunchImage;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Jasper on 2017/4/20.
 */

public interface CommonApi {
    @GET("/api/7/prefetch-launch-images/1080*1920")
    Observable<LaunchImage> getLaunchImage();
}
