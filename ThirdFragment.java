package com.miaoyi.work.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.miaoyi.work.R;

/**
 * Created by administrato on 2016/8/23.
 */
public class ThirdFragment extends BaseFragment {


    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        //设置toolbar
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.main_toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        getHoldingActivity().setSupportActionBar(toolbar);
        getHoldingActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //设置collapsing
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.main_ctl);
        collapsingToolbarLayout.setTitle("个人中心");
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.GRAY);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        final NestedScrollView nsv = (NestedScrollView) view.findViewById(R.id.main_nsv);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.main_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nsv.fullScroll(NestedScrollView.FOCUS_UP);
                Snackbar.make(collapsingToolbarLayout, "回到顶部", Snackbar.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_third;
    }

}
