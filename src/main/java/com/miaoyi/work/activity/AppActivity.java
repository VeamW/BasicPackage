package com.miaoyi.work.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.miaoyi.work.R;
import com.miaoyi.work.fragment.BaseFragment;

public abstract class AppActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set content view
        setContentView(getContentViewId());
        if (null != getIntent()) {
            handleIntent(getIntent());
        }
        if (null == getSupportFragmentManager().getFragments()) {
            BaseFragment fragment = getFirstFragment();
            if (null != fragment) {
                addFragment(fragment, "首页");
            }
        }

        ((ImageView) findViewById(R.id.back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeFragment();
            }
        });
    }


    @Override
    protected int getContentViewId() {
        return R.layout.activity_app;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.activity_app_container;
    }

    @Override
    protected TextView getTopView() {
        return (TextView) findViewById(R.id.tx_title);
    }

    /**
     * get the first fragment
     */
    protected abstract BaseFragment getFirstFragment();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                removeFragment();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Handler for data
     *
     * @param intent
     */
    protected void handleIntent(Intent intent) {

    }

}
