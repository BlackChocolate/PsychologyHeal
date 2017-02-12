package com.example.sukurax.psychologyheal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.RequestMobileCodeCallback;

public class LoginActivity extends AppCompatActivity {
    EditText loginUsername,registerPhoneNumber,Captcha,loginPassword;
    TextView resetPassword;
    String loginusername,loginpassword,registerphonenumber,captcha;
    Button loginBtn,next,sendCaptchaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("登录");
        spec.setContent(R.id.login);
        spec.setIndicator("登录");
        host.addTab(spec);

        spec = host.newTabSpec("注册");
        spec.setContent(R.id.register);
        spec.setIndicator("注册");
        host.addTab(spec);

        loginUsername=(EditText)findViewById(R.id.loginUsername);
        loginPassword=(EditText)findViewById(R.id.loginPassword);
        loginBtn=(Button)findViewById(R.id.loginBtn);

        registerPhoneNumber=(EditText)findViewById(R.id.registerPhoneNumber);
        Captcha=(EditText)findViewById(R.id.captcha);
        sendCaptchaBtn=(Button)findViewById(R.id.sendCaptchaBtn);
        next=(Button)findViewById(R.id.next);

        sendCaptchaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerphonenumber=registerPhoneNumber.getText().toString().trim();
                if(registerphonenumber.length()==0){
                    Toast.makeText(getApplicationContext(), "输入不能为空！",
                            Toast.LENGTH_SHORT).show();
                }else {
                    AVOSCloud.requestSMSCodeInBackground(registerphonenumber, new RequestMobileCodeCallback() {
                        @Override
                        public void done(AVException e) {
                            if(e==null){
                                Toast.makeText(getApplicationContext(), "短信发送成功，请注意查收",
                                        Toast.LENGTH_SHORT).show();
                            }else {
                                String temp[] = e.toString().split("\"");
                                Toast.makeText(getApplicationContext(), temp[temp.length-2],
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerphonenumber=registerPhoneNumber.getText().toString().trim();
                captcha=Captcha.getText().toString().trim();
                if(registerphonenumber.length()==0||captcha.length()==0){
                    Toast.makeText(getApplicationContext(), "输入不能为空！",
                            Toast.LENGTH_SHORT).show();
                }else {
                    AVUser.signUpOrLoginByMobilePhoneInBackground(registerphonenumber, captcha, new LogInCallback<AVUser>() {
                        @Override
                        public void done(AVUser avUser, AVException e) {
                            if(e==null){
                                Intent intent = new Intent();
                                intent.putExtra("phoneNumber", registerphonenumber);
                                intent.setClass(LoginActivity.this, registerActivity.class);
                                startActivity(intent);
                            }else{
                                String temp[] = e.toString().split("\"");
                                Toast.makeText(getApplicationContext(), temp[temp.length-2],
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginusername=loginUsername.getText().toString().trim();
                loginpassword=loginPassword.getText().toString().trim();
                if(loginusername.length()==0||loginpassword.length()==0){
                    Toast.makeText(getApplicationContext(), "输入不能为空！",
                            Toast.LENGTH_SHORT).show();
                }else{
                    AVUser.logInInBackground(loginusername, loginpassword, new LogInCallback<AVUser>() {
                        @Override
                        public void done(AVUser avUser, AVException e) {
                            if(e==null){
                                Intent intent=new Intent();
                                intent.setClass(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                            }else{
                                String temp[] = e.toString().split("\"");
                                Toast.makeText(getApplicationContext(), temp[temp.length-2],
                                        Toast.LENGTH_SHORT).show();
                                if(temp[temp.length-2]=="登录成功"){
                                    Intent intent=new Intent();
                                    intent.setClass(LoginActivity.this,MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                        }
                    });
                }
            }
        });

        resetPassword=(TextView)findViewById(R.id.resetPassword);
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "点击忘记密码",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
