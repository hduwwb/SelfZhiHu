package com.exemple.selfzhihu.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.exemple.selfzhihu.R;
import com.exemple.selfzhihu.ui.fragment.FragmentMainList;

/**
 * Created by Jasper on 2017/4/22.
 */

public class MainActivity extends BaseActivity {

    private DrawerLayout drawerLayout;
    private FragmentMainList fragmentMainList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toobar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        }
        initFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.notifications:
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.night_mode:
                Toast.makeText(this, "night_mode", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
            default:
        }
        return true;
    }
    private void initFragment(){
        fragmentMainList = new FragmentMainList();
        switchFragment(fragmentMainList,"首页");
    }
    public void switchFragment(Fragment fragment,String title){
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container,fragment)
                .commit();
        setTitle(title);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityCollector.finishAll();
    }
}
