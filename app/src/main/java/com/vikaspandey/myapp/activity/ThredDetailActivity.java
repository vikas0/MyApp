package com.vikaspandey.myapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.vikaspandey.myapp.R;
import com.vikaspandey.myapp.adapter.ThreadDetailAdapter;

public class ThredDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thred_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getIntent().getStringExtra("title"));
        ((TextView)findViewById(R.id.tv_topic_title)).setText(getIntent().getStringExtra("title"));
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.left_48px);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        (ThredDetailActivity.this).onBackPressed();
                    }
                });

        Long topic_id=getIntent().getLongExtra("topic_id",-1);
        RecyclerView rvThreadDetail = (RecyclerView)findViewById(R.id.rv_thread_detail);
        rvThreadDetail.setLayoutManager(new LinearLayoutManager(this));
        rvThreadDetail.setAdapter(new ThreadDetailAdapter(this,topic_id));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.thread_detail_menu, menu);
        return true;
    }
}
