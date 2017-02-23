package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by sukurax on 2017/2/12.
 */

public class DoctorIfoActivity extends AppCompatActivity{
    Button orderBtn,followBtn,privateChatBtn;
    ImageView doctorIfoBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorifo);
        getWidgetId();
        setClickListener();
    }

    private void getWidgetId() {
        orderBtn=(Button)findViewById(R.id.orderBtn);
        doctorIfoBackBtn=(ImageView)findViewById(R.id.doctorIfoBackBtn);
        followBtn=(Button)findViewById(R.id.followBtn);
        privateChatBtn=(Button)findViewById(R.id.privateChat);
    }
    private void setClickListener() {
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
        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "点击关注",
                        Toast.LENGTH_SHORT).show();
            }
        });
        privateChatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "点击私信",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
