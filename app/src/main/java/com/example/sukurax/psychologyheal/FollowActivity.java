package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by sukurax on 2017/3/13.
 */

public class FollowActivity extends AppCompatActivity {
    ImageView followBackBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        innerFollowActivity();
    }

    private void innerFollowActivity() {
        followBackBtn=(ImageView)findViewById(R.id.followBackBtn);
        followBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FollowActivity.super.onBackPressed();
            }
        });
    }
    public void toDoctorIfo(View view) {
        String whichDoc=view.getTag().toString();
        switch (whichDoc){
            case "WuXiongBo":
                Intent intent =new Intent(this,DoctorIfoActivity.class);
                intent.putExtra("whichdoctor", "1");
                startActivity(intent);
                break;
            case "LinLiZhou":
                Intent intent2 =new Intent(this,DoctorIfoActivity.class);
                intent2.putExtra("whichdoctor", "2");
                startActivity(intent2);
                break;
            case "ZhaoXiaoRuo":
                Intent intent3 =new Intent(this,DoctorIfoActivity.class);
                intent3.putExtra("whichdoctor", "3");
                startActivity(intent3);
                break;
            default:
                break;

        }
    }
}