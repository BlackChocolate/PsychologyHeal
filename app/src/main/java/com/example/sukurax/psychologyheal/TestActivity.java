package com.example.sukurax.psychologyheal;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.avos.avoscloud.okhttp.Call;
import com.avos.avoscloud.okhttp.Callback;
import com.avos.avoscloud.okhttp.OkHttpClient;
import com.avos.avoscloud.okhttp.Request;
import com.avos.avoscloud.okhttp.Response;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import com.google.gson.Gson;
import com.show.api.ShowApiRequest;
/**
 * Created by sukurax on 2017/3/13.
 */

public class TestActivity extends AppCompatActivity {
    ImageView testBackBtn;
    WebView testContent;
    protected Handler mHandler =  new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        innerTestActivity();
    }

    private void innerTestActivity() {
        testBackBtn=(ImageView)findViewById(R.id.testBackBtn);
        testBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestActivity.super.onBackPressed();
            }
        });
        testContent=(WebView)findViewById(R.id.testContent);

        new Thread() {
            @Override
            public void run() {
                String appid="33556";
                String secret="323f5cebeb8841e8a5841bba1f79497a";
                final String res=new ShowApiRequest( "http://route.showapi.com/970-2", appid, secret)
                        .addTextPara("id", "/art/renge/80959.html")
                        .post();

                System.out.println(res);
                //把返回内容通过handler对象更新到界面
                mHandler.post(new Thread(){
                    public void run() {
                        JSONObject js=JSONObject.parseObject(res);
                        JSONObject contentObject=js.getJSONObject("showapi_res_body");       //获取对象中的对象
                        JSONObject item=contentObject.getJSONObject("item");    //获取对象中的一个值
                        String content=item.getString("content");
                        testContent.loadDataWithBaseURL(null, content, "text/html", "UTF-8", null);
                    }
                });

            }
        }.start();
    }
}
