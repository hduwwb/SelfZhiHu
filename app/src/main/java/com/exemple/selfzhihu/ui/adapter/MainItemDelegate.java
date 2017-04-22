package com.exemple.selfzhihu.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.exemple.selfzhihu.App;
import com.exemple.selfzhihu.R;
import com.exemple.selfzhihu.bean.BaseItem;
import com.exemple.selfzhihu.bean.Stories;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by Jasper on 2017/4/22.
 */

public class MainItemDelegate implements ItemViewDelegate<BaseItem> {
    private Context context;
    @Override
    public int getItemViewLayoutId() {
        return R.layout.main_list_item;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof Stories;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        Stories stories = (Stories)baseItem;
        context = App.getContext();
        holder.setText(R.id.item_title,stories.getTitle());
        Glide.with(context)
                .load(stories.getImages().get(0))
                .centerCrop()
                .into((ImageView)holder.getView(R.id.item_image));
    }
}
