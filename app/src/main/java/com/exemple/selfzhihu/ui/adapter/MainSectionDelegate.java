package com.exemple.selfzhihu.ui.adapter;

import com.exemple.selfzhihu.R;
import com.exemple.selfzhihu.bean.BaseItem;
import com.exemple.selfzhihu.utils.DateUtil;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by Jasper on 2017/4/22.
 */

public class MainSectionDelegate implements ItemViewDelegate<BaseItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.main_list_section;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof MainSection;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        MainSection mainSection = (MainSection)baseItem;
        if (position == 0){
            holder.setText(R.id.main_section,"今日热闻");
        }else {
            holder.setText(R.id.main_section, DateUtil.getFormatDate(mainSection.getDate()));
        }
    }
}
