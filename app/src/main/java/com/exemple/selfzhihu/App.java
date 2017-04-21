package com.exemple.selfzhihu;

import android.app.Application;
import android.content.Context;

/**
 * Created by Jasper on 2017/4/21.
 */

public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
