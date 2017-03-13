package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.CloudQueryCallback;
import com.avos.avoscloud.FindCallback;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sukurax on 2017/3/9.
 */

public class ArticleContentActivity extends AppCompatActivity {
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
                ArticleContentActivity.super.onBackPressed();
            }
        });
    }

    public void followDoctor(View view) {
        String getDocName=view.getTag().toString();
        //获取当前用户信息
        final AVUser currentUser = AVUser.getCurrentUser();
        switch (getDocName){
            case "WuXiongBo":
                //判断当前用户和点击关注的对象是否相同
                if(currentUser.getUsername().equals("WuXiongBo")){
                    Toast.makeText(getApplicationContext(),"不能关注自己!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    final AVQuery<AVObject> priorityQuery = new AVQuery<>("CounselorFollow");
                    priorityQuery.whereEqualTo("patientId", currentUser.getUsername());

                    final AVQuery<AVObject> statusQuery = new AVQuery<>("CounselorFollow");
                    statusQuery.whereEqualTo("counselorId", "WuXiongBo");

                    AVQuery<AVObject> query = AVQuery.and(Arrays.asList(priorityQuery, statusQuery));
                    query.findInBackground(new FindCallback<AVObject>() {
                        @Override
                        public void done(List<AVObject> list, AVException e) {
                            // 返回 priority 大于等于3 或 status 等于 1 的 Todo
                            if(list.isEmpty()){
                                //list为空代表没有关注，此时进行关注操作
                                AVQuery.doCloudQueryInBackground("insert into CounselorFollow(counselorId, patientId) values(\"WuXiongBo\""+",\""+currentUser.getUsername()+"\")", new CloudQueryCallback<AVCloudQueryResult>() {
                                    @Override
                                    public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
                                        Toast.makeText(getApplicationContext(),"关注成功!",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{
                                Toast.makeText(getApplicationContext(),"您已经关注过了!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                break;
            case "LinLiZhou":
                //判断当前用户和点击关注的对象是否相同
                if(currentUser.getUsername().equals("LinLiZhou")){
                    Toast.makeText(getApplicationContext(),"不能关注自己!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    final AVQuery<AVObject> priorityQuery = new AVQuery<>("CounselorFollow");
                    priorityQuery.whereEqualTo("patientId", currentUser.getUsername());

                    final AVQuery<AVObject> statusQuery = new AVQuery<>("CounselorFollow");
                    statusQuery.whereEqualTo("counselorId", "LinLiZhou");

                    AVQuery<AVObject> query = AVQuery.and(Arrays.asList(priorityQuery, statusQuery));
                    query.findInBackground(new FindCallback<AVObject>() {
                        @Override
                        public void done(List<AVObject> list, AVException e) {
                            // 返回 priority 大于等于3 或 status 等于 1 的 Todo
                            if(list.isEmpty()){
                                //list为空代表没有关注，此时进行关注操作
                                AVQuery.doCloudQueryInBackground("insert into CounselorFollow(counselorId, patientId) values(\"LinLiZhou\""+",\""+currentUser.getUsername()+"\")", new CloudQueryCallback<AVCloudQueryResult>() {
                                    @Override
                                    public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
                                        Toast.makeText(getApplicationContext(),"关注成功!",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{
                                Toast.makeText(getApplicationContext(),"您已经关注过了!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                break;
            case "ZhaoXiaoRuo":
                //判断当前用户和点击关注的对象是否相同
                if(currentUser.getUsername().equals("ZhaoXiaoRuo")){
                    Toast.makeText(getApplicationContext(),"不能关注自己!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    final AVQuery<AVObject> priorityQuery = new AVQuery<>("CounselorFollow");
                    priorityQuery.whereEqualTo("patientId", currentUser.getUsername());

                    final AVQuery<AVObject> statusQuery = new AVQuery<>("CounselorFollow");
                    statusQuery.whereEqualTo("counselorId", "ZhaoXiaoRuo");

                    AVQuery<AVObject> query = AVQuery.and(Arrays.asList(priorityQuery, statusQuery));
                    query.findInBackground(new FindCallback<AVObject>() {
                        @Override
                        public void done(List<AVObject> list, AVException e) {
                            // 返回 priority 大于等于3 或 status 等于 1 的 Todo
                            if(list.isEmpty()){
                                //list为空代表没有关注，此时进行关注操作
                                AVQuery.doCloudQueryInBackground("insert into CounselorFollow(counselorId, patientId) values(\"ZhaoXiaoRuo\""+",\""+currentUser.getUsername()+"\")", new CloudQueryCallback<AVCloudQueryResult>() {
                                    @Override
                                    public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
                                        Toast.makeText(getApplicationContext(),"关注成功!",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{
                                Toast.makeText(getApplicationContext(),"您已经关注过了!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                break;
            case "NiMing":
                Toast.makeText(getApplicationContext(),"匿名用户无法关注!",
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(),"关注失败",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
