package com.juhezi.emoticon.main.tabs.dynamic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juhezi.emoticon.R;
import com.juhezi.emoticon.main.tabs.TabFragment;

/**
 * Created by qiao1 on 2016/11/17.
 */
public class DynamicFragment extends TabFragment implements DynamicContract.View {
    private static String TAG = "DynamicFragment";

    private DynamicContract.Presenter mPresenter;

    public DynamicFragment(String tabName) {
        super(tabName);
    }

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_dynamic, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.tv_frag_dynamic_show);
        textView.setText(tabName);
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

    @Override
    public void setPresenter(DynamicContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
