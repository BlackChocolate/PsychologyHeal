package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by sukurax on 2017/2/12.
 */

public class DoctorIfoActivity extends AppCompatActivity{
    Button orderBtn;
    ImageView doctorIfoBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorifo);
        orderBtn=(Button)findViewById(R.id.orderBtn);
        doctorIfoBackBtn=(ImageView)findViewById(R.id.doctorIfoBackBtn);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(DoctorIfoActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });
        doctorIfoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoctorIfoActivity.super.onBackPressed();
            }
        });
    }
}
