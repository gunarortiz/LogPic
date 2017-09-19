package com.goc.logpic;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ShowActivity extends AppCompatActivity {
    //private GridLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("algo");
        setSupportActionBar(toolbar);

        Intent i=getIntent();
        String ids=(String) i.getSerializableExtra("ids");

        //lLayout = new GridLayoutManager(ShowActivity.this, 4);

        RecyclerView recyclerShow=(RecyclerView)findViewById(R.id.lista_show);
        recyclerShow.setLayoutManager(new GridLayoutManager(this,3));

        //recyclerShow.setLayoutManager(lLayout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
