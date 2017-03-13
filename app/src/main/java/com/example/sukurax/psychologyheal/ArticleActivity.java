package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sukurax on 2017/3/13.
 */

public class ArticleActivity extends AppCompatActivity {
    ImageView articleBackBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        innerArticleActivity();
    }

    private void innerArticleActivity() {
        articleBackBtn=(ImageView)findViewById(R.id.articleBackBtn);
        articleBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArticleActivity.super.onBackPressed();
            }
        });
    }
    public void toArticle5(View view){
        Intent intent =new Intent(ArticleActivity.this,ArticleContentActivity.class);
        intent.putExtra("whichlayout", "5");
        startActivity(intent);
    }
}