package com.miaoyi.work;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //设置collapsing
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.main_ctl);
        collapsingToolbarLayout.setTitle("HELLO THERE");
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.DKGRAY);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        final NestedScrollView nsv = (NestedScrollView) findViewById(R.id.main_nsv);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.main_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nsv.fullScroll(NestedScrollView.FOCUS_UP);
                Snackbar.make(collapsingToolbarLayout, "回到顶部", Snackbar.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(MainActivity.this, "BACK IS CLICKED", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;

    }
}
