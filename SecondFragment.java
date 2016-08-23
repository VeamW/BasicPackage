package com.miaoyi.work.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.miaoyi.work.R;

/**
 * Created by administrato on 2016/8/23.
 */
public class SecondFragment extends BaseFragment {

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        Button button = (Button) view.findViewById(R.id.btn_add_Fragment);
      /*  ImageView img = (ImageView) view.findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeFragment();
            }
        });*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(ThirdFragment.newInstance(), "第三个");
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_second;
    }

}
