package com.juhezi.emoticon.main;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.LoginFilter;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.juhezi.emoticon.R;
import com.juhezi.emoticon.abs.AbsPresenter;
import com.juhezi.emoticon.abs.AbsViewModel;
import com.juhezi.emoticon.main.tabs.TabFragment;
import com.juhezi.emoticon.main.tabs.dynamic.DynamicFragment;
import com.juhezi.emoticon.main.tabs.dynamic.DynamicPresenter;
import com.juhezi.emoticon.main.tabs.dynamic.DynamicViewModel;
import com.juhezi.emoticon.main.tabs.fight.FightFragment;
import com.juhezi.emoticon.main.tabs.fight.FightPresenter;
import com.juhezi.emoticon.main.tabs.fight.FightViewModel;
import com.juhezi.emoticon.main.tabs.gif.GifFragment;
import com.juhezi.emoticon.main.tabs.gif.GifPresenter;
import com.juhezi.emoticon.main.tabs.gif.GifViewModel;
import com.juhezi.emoticon.main.tabs.lovely.LovelyFragment;
import com.juhezi.emoticon.main.tabs.lovely.LovelyPresenter;
import com.juhezi.emoticon.main.tabs.lovely.LovelyViewModel;
import com.juhezi.emoticon.main.tabs.pretendStrong.PretendFragment;
import com.juhezi.emoticon.main.tabs.pretendStrong.PretendPresenter;
import com.juhezi.emoticon.main.tabs.pretendStrong.PretendViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Toolbar mTbMain;
    private ActionBar mActionBar;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private FloatingActionButton mFabAdd;

    private VPTLAdapter mAdapter;
    private TabFragment.Builder mBuilder = new TabFragment.Builder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这里要进行数据还原

        Log.i(TAG, "onCreate: ??");

        setContentView(R.layout.act_main);

        initActionBar();

        initTabLayout();

        initDrawerlayout();

        initView();

        initEvent();
    }

    private void initDrawerlayout() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_act_main);
        mNavigationView = (NavigationView) findViewById(R.id.nav_act_main);
    }

    private void initActionBar() {
        mTbMain = (Toolbar) findViewById(R.id.tb_main);
        setSupportActionBar(mTbMain);
        mActionBar = getSupportActionBar();
        mActionBar.setTitle("");
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    /**
     * 配置Tablayout和Viewpager，这里要从Model中获取Tab的信息，并将其添加到List中，
     */
    private void initTabLayout() {
        mTabLayout = (TabLayout) findViewById(R.id.tl_act_main_tabs);
        mViewPager = (ViewPager) findViewById(R.id.vp_act_main);
        addTab(this, getString(R.string.pretend_strong),
                PretendFragment.class,
                PretendPresenter.class,
                PretendViewModel.class);
        addTab(this, getString(R.string.lovely),
                LovelyFragment.class,
                LovelyPresenter.class,
                LovelyViewModel.class);
        addTab(this, getString(R.string.gif),
                GifFragment.class,
                GifPresenter.class,
                GifViewModel.class);
        addTab(this, getString(R.string.fight),
                FightFragment.class,
                FightPresenter.class,
                FightViewModel.class);
        addTab(this, "刘看山",
                DynamicFragment.class,
                DynamicPresenter.class,
                DynamicViewModel.class);
        addTab(this, "刘看山1",
                DynamicFragment.class,
                DynamicPresenter.class,
                DynamicViewModel.class);
        addTab(this, "刘看山2",
                DynamicFragment.class,
                DynamicPresenter.class,
                DynamicViewModel.class);

        mAdapter = new VPTLAdapter(new ArrayList<TabFragment>(
                TabFragment.Builder.getFragmentPool().values()),
                getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initView() {
        mFabAdd = (FloatingActionButton) findViewById(R.id.fab_frag_main_add);
    }

    private void initEvent() {
        mFabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabFragment fragment = addTab(MainActivity.this, "Hello",
                        DynamicFragment.class,
                        DynamicPresenter.class,
                        DynamicViewModel.class);
                mAdapter.setFragments(new ArrayList<TabFragment>(
                        TabFragment.Builder.getFragmentPool().values()));

            }
        });
    }

    /**
     * 添加Tab
     *
     * @param context
     * @param tabName
     * @param fragClazz
     * @param preClazz
     * @param vimoClazz
     */
    public TabFragment addTab(Context context, String tabName,
                              Class<? extends TabFragment> fragClazz,
                              Class<? extends AbsPresenter> preClazz,
                              Class<? extends AbsViewModel> vimoClazz) {
        if (mBuilder == null) {
            return null;
        }
        return mBuilder.setTabName(tabName)
                .setContext(context)
                .setFragmentClazz(fragClazz)
                .setPresenterClazz(preClazz)
                .setViewModelClazz(vimoClazz)
                .build();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
