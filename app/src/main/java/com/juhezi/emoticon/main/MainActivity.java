package com.juhezi.emoticon.main;

import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.juhezi.emoticon.R;
import com.juhezi.emoticon.abs.AbsPresenter;
import com.juhezi.emoticon.abs.AbsViewModel;
import com.juhezi.emoticon.main.tabs.TabFragment;
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

    private Toolbar mTbMain;
    private ActionBar mActionBar;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private VPTLAdapter mAdapter;
    private TabFragment.Builder mBuilder = new TabFragment.Builder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        initActionBar();

        initTabLayout();
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
     * 配置Tablayout和Viewpager，太丑需要重构
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
        mAdapter = new VPTLAdapter(new ArrayList<TabFragment>(
                TabFragment.Builder.getFragmentPool().values()),
                getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
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
                              Class fragClazz,
                              Class preClazz,
                              Class vimoClazz) {
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
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
