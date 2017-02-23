package com.example.sukurax.psychologyheal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

/**
 * Created by sukurax on 2017/2/18.
 */

public class MyOrderActivity extends AppCompatActivity {
    ImageView myOrderBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);

        innerMyOrderActivity();
        getWidgetId();
        setClickListener();
    }


    private void innerMyOrderActivity() {
        TabHost host = (TabHost)findViewById(R.id.tabHost2);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("完成");
        spec.setContent(R.id.tab1);
        spec.setIndicator("完成");
        host.addTab(spec);

        spec = host.newTabSpec("完善");
        spec.setContent(R.id.tab2);
        spec.setIndicator("完善");
        host.addTab(spec);

        spec = host.newTabSpec("进行");
        spec.setContent(R.id.tab3);
        spec.setIndicator("进行");
        host.addTab(spec);

        spec = host.newTabSpec("处方");
        spec.setContent(R.id.tab4);
        spec.setIndicator("处方");
        host.addTab(spec);

        spec = host.newTabSpec("评价");
        spec.setContent(R.id.tab5);
        spec.setIndicator("评价");
        host.addTab(spec);

    }

    private void getWidgetId() {
        myOrderBackBtn=(ImageView)findViewById(R.id.myOrderBackBtn);
    }
    private void setClickListener() {
        myOrderBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOrderActivity.super.onBackPressed();
            }
        });
    }
}
