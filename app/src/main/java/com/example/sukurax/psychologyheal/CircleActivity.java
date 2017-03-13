package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by sukurax on 2017/3/13.
 */

public class CircleActivity extends AppCompatActivity {
    ImageView circleBackBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        innerCollectionActivity();
    }

    private void innerCollectionActivity() {
        circleBackBtn=(ImageView)findViewById(R.id.circleBackBtn);
        circleBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CircleActivity.super.onBackPressed();
            }
        });
    }
    public void toArticle3(View view){
        Intent intent =new Intent(CircleActivity.this,ArticleContentActivity.class);
        intent.putExtra("whichlayout", "3");
        startActivity(intent);
    }
    public void toArticle4(View view){
        Intent intent =new Intent(CircleActivity.this,ArticleContentActivity.class);
        intent.putExtra("whichlayout", "4");
        startActivity(intent);
    }
    public void toArticle5(View view){
        Intent intent =new Intent(CircleActivity.this,ArticleContentActivity.class);
        intent.putExtra("whichlayout", "5");
        startActivity(intent);
    }
}
