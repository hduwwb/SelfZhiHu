package com.exemple.selfzhihu.api;

/**
 * Created by Jasper on 2017/4/20.
 */

public class ApiUtil {

    public static ApiService getApiService(){
        return RetrofitClient.getRetrofit().create(ApiService.class);
    }
}
