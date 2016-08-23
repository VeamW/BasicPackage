package com.miaoyi.work.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.miaoyi.work.R;
import com.miaoyi.work.activity.BaseActivity;

/**
 * Created by administrato on 2016/8/23.
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view, savedInstanceState);
        return view;
    }


    /**
     * init view
     *
     * @param view               parent
     * @param savedInstanceState saved parameters
     */
    protected abstract void initView(View view, Bundle savedInstanceState);

    /**
     * get Layout Id
     *
     * @return int ID
     */
    protected abstract int getLayoutId();

    /**
     * get holding activity
     *
     * @return BaseActivity
     */
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }

    /**
     * add Fragment
     *
     * @param fragment
     */
    protected void addFragment(BaseFragment fragment, String title) {
        if (null != fragment) {
            getHoldingActivity().addFragment(fragment, title);
        }
    }

    /**
     * remove Fragment
     */
    protected void removeFragment() {
        getHoldingActivity().removeFragment();
    }

}
