package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by sukurax on 2017/2/12.
 */

public class DoctorIfoActivity extends AppCompatActivity{
    Button orderBtn,followBtn,privateChatBtn;
    LinearLayout doc1article,doc2article,doc3article;
    ImageView doctorIfoBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        innerDoctorIfoActivity();
        getWidgetId();
        setClickListener();
    }

    private void innerDoctorIfoActivity() {
        Intent intent =getIntent();
        String whichdoctor=intent.getStringExtra("whichdoctor");
        switch (whichdoctor){
            case "1":
                setContentView(R.layout.activity_doctorifo1);
                doc1article=(LinearLayout)findViewById(R.id.doc1article);
                break;
            case "2":
                setContentView(R.layout.activity_doctorifo2);
                doc2article=(LinearLayout)findViewById(R.id.doc2article);
                break;
            case "3":
                setContentView(R.layout.activity_doctorifo3);
                doc3article=(LinearLayout)findViewById(R.id.doc3article);
                break;
            default:
                setContentView(R.layout.activity_doctorifo1);
                break;
        }
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

//        doc1article.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(DoctorIfoActivity.this,ArticleActivity.class);
//                intent.putExtra("whichlayout", "1");
//                startActivity(intent);
//            }
//        });
//
//        doc2article.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(DoctorIfoActivity.this,ArticleActivity.class);
//                intent.putExtra("whichlayout", "2");
//                startActivity(intent);
//            }
//        });
//        doc3article.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(DoctorIfoActivity.this,ArticleActivity.class);
//                intent.putExtra("whichlayout", "5");
//                startActivity(intent);
//            }
//        });
    }
}
