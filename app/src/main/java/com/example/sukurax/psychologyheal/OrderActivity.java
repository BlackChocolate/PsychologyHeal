package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by sukurax on 2017/2/12.
 */

public class OrderActivity extends AppCompatActivity {
    ImageView orderBackBtn;
    LinearLayout orderAndPayBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        innerOrderActivity();
        getWidgetId();
        setClickListener();

    }

    private void innerOrderActivity() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(OrderActivity.this,
                R.array.optional_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void setClickListener() {

        orderBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderActivity.super.onBackPressed();
            }
        });
        orderAndPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "点击支付并预约",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getWidgetId() {
        orderBackBtn=(ImageView)findViewById(R.id.orderBackBtn);
        orderAndPayBtn=(LinearLayout)findViewById(R.id.orderAndPayBtn);

    }
}
