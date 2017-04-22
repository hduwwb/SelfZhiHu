package com.exemple.selfzhihu.ui.adapter;

import com.exemple.selfzhihu.bean.BaseItem;

/**
 * Created by Jasper on 2017/4/22.
 */

public class MainSection implements BaseItem {
   private String date;
    public MainSection(String date) {
        this.date = date;
    }
    public String getDate(){
        if (date == null){
            return null;
        }
        return date;
    }
}
