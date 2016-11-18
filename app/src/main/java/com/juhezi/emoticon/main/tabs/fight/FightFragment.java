package com.juhezi.emoticon.main.tabs.fight;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juhezi.emoticon.R;
import com.juhezi.emoticon.abs.AbsFragment;
import com.juhezi.emoticon.main.tabs.TabFragment;

/**
 * Created by qiao1 on 2016/11/17.
 */
public class FightFragment extends TabFragment implements FightContract.View {
    private static String TAG = "FightFragment";

    private FightFragment(String tabName) {
        super(tabName);
    }

    private static FightFragment sInstance;

    public static FightFragment getInstance(String tabName) {
        if (sInstance == null) {
            sInstance = new FightFragment(tabName);
        }
        return sInstance;
    }

    private FightContract.Presenter mPresenter;

    @Override
    public void setPresenter(FightContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_fight, container, false);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.start();
        }
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.destroy();
        }
        super.onDestroy();
    }
}
