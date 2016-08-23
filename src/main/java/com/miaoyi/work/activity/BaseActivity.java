package com.miaoyi.work.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.TextView;

import com.miaoyi.work.fragment.BaseFragment;

public abstract class BaseActivity extends AppCompatActivity {


    /**
     * get Layout View ID
     */
    protected abstract int getContentViewId();

    /**
     * get Fragment Content Id
     */
    protected abstract int getFragmentContentId();

    protected abstract TextView getTopView();

    /**
     * Add Fragment
     * We replace the content fragment you want by getFragmentContentId()
     *
     * @param fragment
     */
    public void addFragment(BaseFragment fragment, String title) {
        if (null != fragment) {
            if (getSupportFragmentManager().findFragmentByTag(fragment.getClass().getSimpleName()) != null) {
                return;
            }
            if (null != getTopView()) {
                getTopView().setText(title);
            }
            getSupportFragmentManager().beginTransaction().replace(getFragmentContentId(), fragment, title).addToBackStack(fragment.getClass().getSimpleName()).commitAllowingStateLoss();
        }
    }

    /**
     * remove Fragment
     * we check the back stack entry count first , and
     * if >1 , then we use fragment manger pop back,
     * else we could just finish this Activity
     */
    public void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
            requestTitle();
        } else {
            finish();
        }
    }

    /**
     * invalidate title
     */
    private void requestTitle() {
        int j = getSupportFragmentManager().getBackStackEntryCount();
        --j;
        getTopView().setText(getSupportFragmentManager().getFragments().get(j - 1).getTag());
    }

    /**
     * check app back
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
            requestTitle();
        }
        return super.onKeyDown(keyCode, event);
    }
}
