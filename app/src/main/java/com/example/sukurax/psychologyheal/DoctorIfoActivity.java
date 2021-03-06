package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.CloudQueryCallback;
import com.avos.avoscloud.FindCallback;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sukurax on 2017/2/12.
 */

public class DoctorIfoActivity extends AppCompatActivity{
    Button orderBtn;
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
                break;
            case "2":
                setContentView(R.layout.activity_doctorifo2);
                break;
            case "3":
                setContentView(R.layout.activity_doctorifo3);
                break;
            default:
                setContentView(R.layout.activity_doctorifo1);
                break;
        }
    }

    private void getWidgetId() {
        orderBtn=(Button)findViewById(R.id.orderBtn);
        doctorIfoBackBtn=(ImageView)findViewById(R.id.doctorIfoBackBtn);
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
    }

    public void chatToWu(View view){
        Intent chat = new Intent(DoctorIfoActivity.this,ChatActivity.class);
        chat.putExtra(EaseConstant.EXTRA_USER_ID,"WuXiongBo");  //对方账号
        chat.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat); //单聊模式
        startActivity(chat);
    }
    public void chatToLin(View view){
        Intent chat = new Intent(DoctorIfoActivity.this,ChatActivity.class);
        chat.putExtra(EaseConstant.EXTRA_USER_ID,"LinLiZhou");  //对方账号
        chat.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat); //单聊模式
        startActivity(chat);
    }
    public void chatToZhao(View view){
        Intent chat = new Intent(DoctorIfoActivity.this,ChatActivity.class);
        chat.putExtra(EaseConstant.EXTRA_USER_ID,"ZhaoXiaoRuo");  //对方账号
        chat.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat); //单聊模式
        startActivity(chat);
    }
    public void toArticle1(View view){
        Intent intent =new Intent(DoctorIfoActivity.this,ArticleContentActivity.class);
        intent.putExtra("whichlayout", "1");
        startActivity(intent);
    }
    public void toArticle2(View view){
        Intent intent =new Intent(DoctorIfoActivity.this,ArticleContentActivity.class);
        intent.putExtra("whichlayout", "2");
        startActivity(intent);
    }
    public void toArticle5(View view){
        Intent intent =new Intent(DoctorIfoActivity.this,ArticleContentActivity.class);
        intent.putExtra("whichlayout", "5");
        startActivity(intent);
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
