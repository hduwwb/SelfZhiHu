package com.exemple.selfzhihu.api;

/**
 * Created by Jasper on 2017/4/20.
 */

public class ApiManger {

    public static CommonApi getCommonApi(){
        return RetrofitClient.getRetrofit().create(CommonApi.class);
    }
}
