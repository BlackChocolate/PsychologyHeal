package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by sukurax on 2017/3/13.
 */

public class ColumnActivity extends AppCompatActivity {
    ImageView columnBackBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_column);
        innerColumnActivity();
    }

    private void innerColumnActivity() {
        columnBackBtn=(ImageView)findViewById(R.id.columnBackBtn);
        columnBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColumnActivity.super.onBackPressed();
            }
        });
    }

    public void toArticle1(View view){
        Intent intent =new Intent(ColumnActivity.this,ArticleContentActivity.class);
        intent.putExtra("whichlayout", "1");
        startActivity(intent);
    }
    public void toArticle2(View view){
        Intent intent =new Intent(ColumnActivity.this,ArticleContentActivity.class);
        intent.putExtra("whichlayout", "2");
        startActivity(intent);
    }
}
