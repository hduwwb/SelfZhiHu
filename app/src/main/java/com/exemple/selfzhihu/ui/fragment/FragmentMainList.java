package com.exemple.selfzhihu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.exemple.selfzhihu.App;
import com.exemple.selfzhihu.R;
import com.exemple.selfzhihu.bean.BaseItem;
import com.exemple.selfzhihu.bean.BeforeStories;
import com.exemple.selfzhihu.bean.LatestStories;
import com.exemple.selfzhihu.mvp.presenter.MainPresenter;
import com.exemple.selfzhihu.mvp.view.IMainView;
import com.exemple.selfzhihu.ui.adapter.MainListAdapter;
import com.exemple.selfzhihu.ui.adapter.MainSection;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by Jasper on 2017/4/21.
 */

public class FragmentMainList extends Fragment implements IMainView {
    private RecyclerView recyclerView;
    private MainPresenter presenter;
    private List<BaseItem> itemList = new ArrayList<>();
    private String date;
    private LoadMoreWrapper loadMoreWrapper;
    private Disposable d;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_list,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        initData();
        initView();

    }

    private void initData(){
        presenter = new MainPresenter(this);
        MainListAdapter adapter = new MainListAdapter(App.getContext(),itemList);
        loadMoreWrapper = new LoadMoreWrapper(adapter);
    }
    private void initView(){
        loadMoreWrapper.setLoadMoreView(R.layout.default_loading);
        loadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (date != null){
                    presenter.loadBeforeStories(date);
                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(loadMoreWrapper);
        presenter.loadLatestStories();
    }

    @Override
    public void onRequstError(Disposable disposable) {
        d = disposable;
        Toast.makeText(getContext(), "加载失败，请检查网络连接", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoadLatestStories(LatestStories latestStories,Disposable disposable) {
        d = disposable;
        date = latestStories.getDate();
        itemList.add(new MainSection(date));
        itemList.addAll(latestStories.getStories());
        loadMoreWrapper.notifyDataSetChanged();
    }

    @Override
    public void loadBeforeStories(BeforeStories beforeStories, Disposable disposable) {
        d = disposable;
        date = beforeStories.getDate();
        itemList.add(new MainSection(date));
        itemList.addAll(beforeStories.getStories());
        loadMoreWrapper.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        d.dispose();
        itemList.clear();
        super.onDestroy();
    }
}
