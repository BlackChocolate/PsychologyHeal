package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by sukurax on 2017/3/13.
 */

public class CollectionActivity extends AppCompatActivity {
    ImageView collectBackBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        innerCollectionActivity();
    }

    private void innerCollectionActivity() {
        collectBackBtn=(ImageView)findViewById(R.id.collectBackBtn);
        collectBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CollectionActivity.super.onBackPressed();
            }
        });
    }
    public void toArticle5(View view){
        Intent intent =new Intent(CollectionActivity.this,ArticleContentActivity.class);
        intent.putExtra("whichlayout", "5");
        startActivity(intent);
    }
}
