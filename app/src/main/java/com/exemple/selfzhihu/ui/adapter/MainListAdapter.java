package com.exemple.selfzhihu.ui.adapter;

import android.content.Context;

import com.exemple.selfzhihu.bean.BaseItem;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by Jasper on 2017/4/22.
 */

public class MainListAdapter extends MultiItemTypeAdapter<BaseItem> {
    public MainListAdapter(Context context, List<BaseItem> datas) {
        super(context, datas);
        addItemViewDelegate(new MainSectionDelegate());
        addItemViewDelegate(new MainItemDelegate());
    }
}
