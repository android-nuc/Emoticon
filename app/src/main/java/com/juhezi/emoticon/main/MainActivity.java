package com.juhezi.emoticon.main;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.juhezi.emoticon.R;

public class MainActivity extends AppCompatActivity {

    private MainFragment mFragment;
    private MainPresenter mPresenter;

    private Toolbar mTbMain;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        initActionBar();

        initFragment();

    }

    private void initActionBar() {
        mTbMain = (Toolbar) findViewById(R.id.tb_main);
        setSupportActionBar(mTbMain);
        mActionBar = getSupportActionBar();
    }

    private void initFragment() {
        mFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.rl_main_frag);
        if (mFragment == null) {
            mFragment = MainFragment.getInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.rl_main_frag, mFragment)
                    .commit();
        }
        mPresenter = new MainPresenter(mFragment);
        MainViewModel viewModel = new MainViewModel(getApplicationContext(), mPresenter);
        mFragment.setViewModel(viewModel);

    }


}
