package com.juhezi.emoticon.main.tabs.allType;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juhezi.emoticon.R;
import com.juhezi.emoticon.main.tabs.TabFragment;
import com.juhezi.emoticon.util.ConfigKt;

/**
 * Created by qiao1 on 2016/11/24.
 */
public class AllTypeFragment extends TabFragment implements AllTypeContract.View {
    private static String TAG = "AllTypeFragment";

    private AllTypeFragment(String tabName) {
        super(tabName);
    }

    private AllTypeContract.Presenter mPresenter;

    @Override
    public void setPresenter(AllTypeContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    private static final class AllTypeFragmentHolder {
        private static final AllTypeFragment sInstance = new AllTypeFragment(ConfigKt.ALL_TYPE);
    }

    public static AllTypeFragment getInstance(String no) {
        return AllTypeFragmentHolder.sInstance;
    }

    private View rootView;
    private RecyclerView mRecyclerView;
    private int spanCount = 2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_all_type, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_frag_all_type);
        initRecyclerView();
        return rootView;
    }

    private void initRecyclerView() {
        RecyclerView.LayoutManager layoutManager =
                new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
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
