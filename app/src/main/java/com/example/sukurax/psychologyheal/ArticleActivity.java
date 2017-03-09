package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by sukurax on 2017/3/9.
 */

public class ArticleActivity extends AppCompatActivity {
    ImageView articleBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        innerArticleActivity();
        getWidgetId();
        setClickListener();
    }

    private void innerArticleActivity() {
        Intent intent =getIntent();
        String whichlayout=intent.getStringExtra("whichlayout");
        switch (whichlayout){
            case "1":
                setContentView(R.layout.activity_article1);
                break;
            case "2":
                setContentView(R.layout.activity_article2);
                break;
            case "3":
                setContentView(R.layout.activity_article3);
                break;
            case "4":
                setContentView(R.layout.activity_article4);
                break;
            case "5":
                setContentView(R.layout.activity_article5);
                break;
            default:
                setContentView(R.layout.activity_article1);
                break;
        }


    }

    private void getWidgetId() {
        articleBackBtn=(ImageView)findViewById(R.id.articleBackBtn);
    }
    private void setClickListener() {
        articleBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArticleActivity.super.onBackPressed();
            }
        });
    }
    
}
