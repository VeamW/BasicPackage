package com.miaoyi.work.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.miaoyi.work.R;

/**
 * Created by administrato on 2016/8/23.
 */
public class MainFragment extends BaseFragment {


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        Button button = (Button) view.findViewById(R.id.btn_add_Fragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(SecondFragment.newInstance(), "第二个");
            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

}
