package com.miaoyi.work.activity;

import android.content.Intent;

import com.miaoyi.work.fragment.BaseFragment;
import com.miaoyi.work.fragment.MainFragment;

public class IndexActivity extends AppActivity {

    @Override
    protected BaseFragment getFirstFragment() {
        return MainFragment.newInstance();
    }

    @Override
    protected void handleIntent(Intent intent) {
        super.handleIntent(intent);
        if (null != intent) {
            String title = intent.getStringExtra("title");
            setTitle(title);
        }
    }
}
